package com.ruoyi.api.controller;

import com.ruoyi.api.domain.Datasource;
import com.ruoyi.api.domain.bo.DatasourceBo;
import com.ruoyi.api.domain.vo.DatasourceVo;
import com.ruoyi.api.service.IDatasourceService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.exception.CustomException;
import com.ruoyi.common.utils.poi.ExcelUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 数据源Controller
 *
 * @author wei
 * @date 2022-08-22
 */
@Api(tags="数据源模块")
@RestController
@RequestMapping("/api/datasource")
@RequiredArgsConstructor
public class DatasourceController extends BaseController {

    private final IDatasourceService datasourceService;

    /**
     * 查询数据源列表
     */
    @ApiOperation("查询数据源列表")
    @PreAuthorize("@ss.hasPermi('api:datasource:list')")
    @GetMapping("/list")
    public TableDataInfo list(DatasourceBo datasource) {
        startPage();
        List<DatasourceVo> list = datasourceService.selectDatasourceList(datasource);
        return getDataTable(list);
    }

    /**
     * 导出数据源列表
     */
    @ApiOperation("导出数据源列表")
    @PreAuthorize("@ss.hasPermi('api:datasource:export')")
    @Log(title = "数据源", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(DatasourceBo datasource) {
        List<DatasourceVo> list = datasourceService.selectDatasourceList(datasource);
        ExcelUtil<DatasourceVo> util = new ExcelUtil<>(DatasourceVo.class);
        return util.exportExcel(list, "数据源数据");
    }

    /**
     * 获取数据源详细信息
     */
    @ApiOperation("获取数据源详细信息")
    @PreAuthorize("@ss.hasPermi('api:datasource:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id) {
        return AjaxResult.success(datasourceService.selectDatasourceById(id));
    }

    /**
     * 新增数据源
     */
    @ApiOperation("新增数据源")
    @PreAuthorize("@ss.hasPermi('api:datasource:add')")
    @Log(title = "数据源", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Datasource datasource) {
        return toAjax(datasourceService.insertDatasource(datasource));
    }

    /**
     * 修改数据源
     */
    @ApiOperation("修改数据源")
    @PreAuthorize("@ss.hasPermi('api:datasource:edit')")
    @Log(title = "数据源", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Datasource datasource) {
        return toAjax(datasourceService.updateDatasource(datasource));
    }

    /**
     * 删除数据源
     */
    @ApiOperation("删除数据源")
    @PreAuthorize("@ss.hasPermi('api:datasource:remove')")
    @Log(title = "数据源", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids) {
        return toAjax(datasourceService.deleteDatasourceByIds(ids));
    }

    /**
     * 导入数据源数据
     */
    @ApiOperation("导入数据源数据")
    @ApiImplicitParam(name = "file", value = "文件", required = true, dataType = "file")
    @PreAuthorize("@ss.hasPermi('api:datasource:import')")
    @Log(title = "数据源", businessType = BusinessType.IMPORT)
    @PostMapping("/import")
    public AjaxResult importData(MultipartFile file) {

        ExcelUtil<Datasource> util = new ExcelUtil<>(Datasource. class);
        List<Datasource> datasourceList;
        try {
                datasourceList = util.importExcel(file.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("文件解析异常！message：" + e.getMessage());
        }
        String message = datasourceService.importDatasource(datasourceList);
        return AjaxResult.success(message);

    }

    /**
     * 下载模板
     *
     * @return AjaxResult 模板文件
     */
    @ApiOperation("下载模板")
    @GetMapping("/importTemplate")
    public AjaxResult importTemplate() {
        ExcelUtil<Datasource> util = new ExcelUtil<>(Datasource. class);
        return util.importTemplateExcel("数据源数据");
    }
}
