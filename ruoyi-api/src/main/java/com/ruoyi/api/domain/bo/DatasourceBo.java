package com.ruoyi.api.domain.bo;

import com.ruoyi.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 数据源业务对象 api_datasource
 *
 * @author wei
 * @date 2022-08-22
 */

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("数据源业务对象")
public class DatasourceBo extends BaseEntity {

    /**
     * 主键
     */
    @ApiModelProperty(value = "主键")
    private String id;

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    private String name;

    /**
     * 描述
     */
    @ApiModelProperty(value = "描述")
    private String note;

    /**
     * 数据库
     */
    @ApiModelProperty(value = "数据库")
    private String type;

    /**
     * url
     */
    @ApiModelProperty(value = "url")
    private String url;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    private String username;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    private String password;

    /**
     * 驱动
     */
    @ApiModelProperty(value = "驱动")
    private String driver;

    /**
     * 查询所有表名称的SQL
     */
    @ApiModelProperty(value = "查询所有表名称的SQL")
    private String tableSql;


}
