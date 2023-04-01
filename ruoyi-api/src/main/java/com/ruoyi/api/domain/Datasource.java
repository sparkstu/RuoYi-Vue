package com.ruoyi.api.domain;

import com.admin.common.annotation.Excel;
import com.admin.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * 数据源对象 api_datasource
 *
 * @author wei
 * @date 2022-08-22
 */
@Data
@ToString
@Accessors(chain = true)
@ApiModel("数据源")
public class Datasource extends BaseEntity
        {
            private static final long serialVersionUID = 1L;

            /** 主键 */
            @ApiModelProperty("主键")
            private String id;

            /** 名称 */
            @Excel(name = "名称")
            @ApiModelProperty("名称")
            private String name;

            /** 描述 */
            @Excel(name = "描述")
            @ApiModelProperty("描述")
            private String note;

            /** 数据库 */
            @Excel(name = "数据库")
            @ApiModelProperty("数据库")
            private String type;

            /** url */
            @Excel(name = "url")
            @ApiModelProperty("url")
            private String url;

            /** 用户名 */
            @Excel(name = "用户名")
            @ApiModelProperty("用户名")
            private String username;

            /** 密码 */
            @Excel(name = "密码")
            @ApiModelProperty("密码")
            private String password;

            /** 驱动 */
            @Excel(name = "驱动")
            @ApiModelProperty("驱动")
            private String driver;

            /** 查询所有表名称的SQL */
            @Excel(name = "查询所有表名称的SQL")
            @ApiModelProperty("查询所有表名称的SQL")
            private String tableSql;

        }
