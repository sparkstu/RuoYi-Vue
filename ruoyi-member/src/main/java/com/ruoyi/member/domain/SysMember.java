package com.ruoyi.member.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 会员对象 sys_member
 *
 * @author wei
 * @date 2022-07-29
 */
@Data
@ToString
@Accessors(chain = true)
@Schema(defaultValue = "会员对象")
@TableName("sys_member")
public class SysMember extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @Schema(defaultValue = "主键id")
    private Long id;

    /**
     * 用户名
     */
    @Excel(name = "用户名")
    @Schema(defaultValue = "用户名")
    private String username;

    /**
     * 用户密码
     */
    @Excel(name = "用户密码")
    @Schema(title = "用户密码")
    private String password;

    /**
     * 昵称
     */
    @Excel(name = "昵称")
    @Schema(name = "昵称")
    private String nickname;

    /**
     * 头像地址
     */
    @Excel(name = "头像地址")
    @Schema(title = "头像地址")
    private String image;

    /**
     * 真实姓名
     */
    @Excel(name = "真实姓名")
    private String relename;

    /**
     * 身份证
     */
    @Excel(name = "身份证")
    private String cardid;

    /**
     * 性别  0 保密 1男 2女 默认0
     */
    @Excel(name = "性别  0 保密 1男 2女 默认0")
    private String gender;

    /**
     * 生日
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "生日", width = 30, dateFormat = "yyyy-MM-dd")
    private Date birthday;

    /**
     * 月收入  0 无收入 1 2000以下 2 2000-3999 3 4000-5999
     * 4 6000－7999  5 8000以上
     */
    @Excel(name = "月收入  0 无收入 1 2000以下 2 2000-3999 3 4000-59994 6000－7999 5 8000以上")
    private String monthlyIncome;

    /**
     * 婚姻状况  0 保密 1未婚 2 已婚 默认0 保姆
     */
    @Excel(name = "婚姻状况  0 保密 1未婚 2 已婚 默认0 保姆")
    private String marriageStatus;

    /**
     * 手机号码
     */
    @Excel(name = "手机号码")
    private String mobile;

    /**
     * 邮箱地址
     */
    @Excel(name = "邮箱地址")
    private String email;

    /**
     * 更改中的邮箱（绑定新邮箱使用）
     */
    @Excel(name = "更改中的邮箱", readConverterExp = "绑=定新邮箱使用")
    private String modifiedEmail;

    /**
     * 校验码（绑定新邮箱时使用）
     */
    @Excel(name = "校验码", readConverterExp = "绑=定新邮箱时使用")
    private String checkCode;

    /**
     * 省
     */
    @Excel(name = "省")
    private Long province;

    /**
     * 市
     */
    @Excel(name = "市")
    private Long city;

    /**
     * 区
     */
    @Excel(name = "区")
    private Long county;

    /**
     * 详细地址
     */
    @Excel(name = "详细地址")
    private String detailaddress;

    /**
     * 兴趣爱好
     */
    @Excel(name = "兴趣爱好")
    private String interest;

    /**
     * 用户注册来源 1 pc  2app  3 手机h5 4 管理员后台新增
     */
    @Excel(name = "用户注册来源 1 pc  2app  3 手机h5 4 管理员后台新增 ")
    private String source;

    /**
     * 用户状态 1 正常 2 冻结  3 未启用 默认1
     */
    @Excel(name = "用户状态 1 正常 2 冻结  3 未启用 默认1 ")
    private String status;

    /**
     * 会员签到次数
     */
    @Excel(name = "会员签到次数")
    private Long signNum;

    /**
     * 手机是否验证  0 否 1 验证 默认0
     */
    @Excel(name = "手机是否验证  0 否 1 验证 默认0 ")
    private String isMobileVerification;

    /**
     * 邮箱是否验证   0 否 1 验证  默认0
     */
    @Excel(name = "邮箱是否验证   0 否 1 验证  默认0  ")
    private String isEmailVerification;

    /**
     * 错误登录的次数
     */
    @Excel(name = "错误登录的次数")
    private Long loginErrorCount;

    /**
     * 删除标记 0 未删除 1删除 默认0
     */
    private String delFlag;

    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "修改时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date modifyTime;

    /**
     * 删除时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "删除时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date delTime;

    /**
     * 锁定时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "锁定时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date lockTime;

    /**
     * 最近登陆时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "最近登陆时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date lastLoginTime;

    /**
     * 会员自己的推荐码
     */
    @Excel(name = "会员自己的推荐码")
    private String selfRecommendCode;

    /**
     * $column.columnComment
     */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String appletOpenId;

    /**
     * $column.columnComment
     */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String appOpenId;

    /**
     * $column.columnComment
     */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String h5OpenId;

}
