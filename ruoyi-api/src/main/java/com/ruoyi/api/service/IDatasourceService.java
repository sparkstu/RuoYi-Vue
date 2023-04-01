package com.ruoyi.api.service;

import com.ruoyi.api.domain.Datasource;
import com.ruoyi.api.domain.bo.DatasourceBo;
import com.ruoyi.api.domain.vo.DatasourceVo;

import java.util.List;

/**
 * 数据源Service接口
 * 
 * @author wei
 * @date 2022-08-22
 */
public interface IDatasourceService
{
    /**
     * 查询数据源
     * 
     * @param id 数据源主键
     * @return 数据源
     */
    Datasource selectDatasourceById(String id);

    /**
     * 查询数据源列表
     * 
     * @param datasource 数据源
     * @return 数据源集合
     */
    List<DatasourceVo> selectDatasourceList(DatasourceBo datasource);

    /**
     * 新增数据源
     * 
     * @param datasource 数据源
     * @return 结果
     */
    int insertDatasource(Datasource datasource);

    /**
     * 修改数据源
     * 
     * @param datasource 数据源
     * @return 结果
     */
    int updateDatasource(Datasource datasource);

    /**
     * 批量删除数据源
     * 
     * @param ids 需要删除的数据源主键集合
     * @return 结果
     */
    int deleteDatasourceByIds(String[] ids);

    /**
     * 删除数据源信息
     * 
     * @param id 数据源主键
     * @return 结果
     */
    int deleteDatasourceById(String id);

    /**
     * 导入数据
     *
     * @param datasourceList 导入数据源数据
     * @return String
     */
    String importDatasource(List<Datasource> datasourceList);
}
