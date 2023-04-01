package com.ruoyi.api.domain.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;



/**
 * 数据源视图对象 api_datasource
 *
 * @author wei
 * @date 2022-08-22
 */
@Data
@ApiModel("数据源视图对象")
@ExcelIgnoreUnannotated
public class DatasourceVo {

    private static final long serialVersionUID = 1L;

    /**
     * 名称
     */
    @ExcelProperty(value = "名称")
    @ApiModelProperty("名称")
    private String name;

    /**
     * 描述
     */
    @ExcelProperty(value = "描述")
    @ApiModelProperty("描述")
    private String note;

    /**
     * 数据库
     */
    @ExcelProperty(value = "数据库")
    @ApiModelProperty("数据库")
    private String type;

    /**
     * url
     */
    @ExcelProperty(value = "url")
    @ApiModelProperty("url")
    private String url;

    /**
     * 用户名
     */
    @ExcelProperty(value = "用户名")
    @ApiModelProperty("用户名")
    private String username;

    /**
     * 密码
     */
    @ExcelProperty(value = "密码")
    @ApiModelProperty("密码")
    private String password;

    /**
     * 驱动
     */
    @ExcelProperty(value = "驱动")
    @ApiModelProperty("驱动")
    private String driver;

    /**
     * 查询所有表名称的SQL
     */
    @ExcelProperty(value = "查询所有表名称的SQL")
    @ApiModelProperty("查询所有表名称的SQL")
    private String tableSql;


}
