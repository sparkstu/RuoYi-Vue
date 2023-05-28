package com.ruoyi.member.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.exception.CustomException;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.member.domain.SysMember;
import com.ruoyi.member.service.ISysMemberService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 会员Controller
 *
 * @author wei
 * @date 2022-07-29
 */
@RestController
@RequestMapping("/member")
public class MemberController extends BaseController {
    @Autowired
    private ISysMemberService sysMemberService;

    /**
     * 查询会员列表
     */
    @PreAuthorize("@ss.hasPermi('member:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysMember sysMember) {
        startPage();
        List<SysMember> list = sysMemberService.selectSysMemberList(sysMember);
        return getDataTable(list);
    }

    /**
     * 导出会员列表
     */
    @PreAuthorize("@ss.hasPermi('member:export')")
    @Log(title = "会员", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(HttpServletResponse response, SysMember sysMember) {
        List<SysMember> list = sysMemberService.selectSysMemberList(sysMember);
        ExcelUtil<SysMember> util = new ExcelUtil<>(SysMember.class);
        return util.exportExcel(list, "会员数据");
    }

    /**
     * 获取会员详细信息
     */
    @PreAuthorize("@ss.hasPermi('member:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(sysMemberService.selectSysMemberById(id));
    }

    /**
     * 新增会员
     */
    @Operation(summary = "新增会员")
    @PreAuthorize("@ss.hasPermi('member:add')")
    @Log(title = "会员", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysMember sysMember) {
        return toAjax(sysMemberService.insertSysMember(sysMember));
    }

    /**
     * 修改会员
     */
    @PreAuthorize("@ss.hasPermi('member:edit')")
    @Log(title = "会员", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysMember sysMember) {
        return toAjax(sysMemberService.updateSysMember(sysMember));
    }

    /**
     * 删除会员
     */
    @PreAuthorize("@ss.hasPermi('member:remove')")
    @Log(title = "会员", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(sysMemberService.deleteSysMemberByIds(ids));
    }

    /**
     * 导入会员数据
     */

    @PreAuthorize("@ss.hasPermi('member:import')")
    @Log(title = "会员", businessType = BusinessType.IMPORT)
    @PostMapping("/import")
    public AjaxResult importData(MultipartFile file) {

        ExcelUtil<SysMember> util = new ExcelUtil<>(SysMember.class);
        List<SysMember> sysMemberList;
        try {
            sysMemberList = util.importExcel(file.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("文件解析异常！message：" + e.getMessage());
        }
        String message = sysMemberService.importSysMember(sysMemberList);
        return AjaxResult.success(message);

    }

    /**
     * 下载模板
     *
     * @return AjaxResult 模板文件
     */
    @GetMapping("/importTemplate")
    public AjaxResult importTemplate() {
        ExcelUtil<SysMember> util = new ExcelUtil<>(SysMember.class);
        return util.importTemplateExcel("会员数据");
    }
}
