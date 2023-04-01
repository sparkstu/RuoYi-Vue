package com.ruoyi.api.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ObjectUtil;
import com.ruoyi.api.domain.Datasource;
import com.ruoyi.api.domain.bo.DatasourceBo;
import com.ruoyi.api.domain.vo.DatasourceVo;
import com.ruoyi.api.mapper.DatasourceMapper;
import com.ruoyi.api.service.IDatasourceService;
import com.admin.common.utils.DateUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 数据源Service业务层处理
 * 
 * @author wei
 * @date 2022-08-22
 */
@Service
public class DatasourceServiceImpl implements IDatasourceService 
{
    @Resource
    private DatasourceMapper datasourceMapper;

    /**
     * 查询数据源
     * 
     * @param id 数据源主键
     * @return 数据源
     */
    @Override
    public Datasource selectDatasourceById(String id)
    {
        return datasourceMapper.selectDatasourceById(id);
    }

    /**
     * 查询数据源列表
     * 
     * @param datasource 数据源
     * @return 数据源
     */
    @Override
    public List<DatasourceVo> selectDatasourceList(DatasourceBo datasource)
    {
        return datasourceMapper.selectDatasourceList(datasource);
    }

    /**
     * 新增数据源
     * 
     * @param datasource 数据源
     * @return 结果
     */
    @Override
    public int insertDatasource(Datasource datasource)
    {
        datasource.setCreateTime(DateUtils.getNowDate());
        return datasourceMapper.insertDatasource(datasource);
    }

    /**
     * 修改数据源
     * 
     * @param datasource 数据源
     * @return 结果
     */
    @Override
    public int updateDatasource(Datasource datasource)
    {
        datasource.setUpdateTime(DateUtils.getNowDate());
        return datasourceMapper.updateDatasource(datasource);
    }

    /**
     * 批量删除数据源
     * 
     * @param ids 需要删除的数据源主键
     * @return 结果
     */
    @Override
    public int deleteDatasourceByIds(String[] ids)
    {
        return datasourceMapper.deleteDatasourceByIds(ids);
    }

    /**
     * 删除数据源信息
     * 
     * @param id 数据源主键
     * @return 结果
     */
    @Override
    public int deleteDatasourceById(String id)
    {
        return datasourceMapper.deleteDatasourceById(id);
    }

    @Override
    public String importDatasource(List<Datasource> datasourceList) {
        Assert.isTrue(ObjectUtil.isNotEmpty(datasourceList), "导入数据不能为空");
        int successNum = 0;
        for (Datasource datasource : datasourceList) {
            Datasource add = BeanUtil.toBean(datasource, Datasource.class);
            insertDatasource(add);
            successNum++;
        }
        String msg = String.format("导入完成，共计 %d 条数据，成功 %d 条！", datasourceList.size(), successNum);
        if (successNum != datasourceList.size()) {
            msg = msg + String.format("失败 %d 条！", datasourceList.size() - successNum);
        }
        return msg;
    }
}
