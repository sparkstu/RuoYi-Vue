-- ----------------------------
-- Table structure for ums_member
-- ----------------------------
DROP TABLE IF EXISTS `sys_member`;
CREATE TABLE `sys_member`
(
    `id`                     bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `username`               varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci           DEFAULT NULL COMMENT '用户名',
    `password`               varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户密码',
    `nickname`               varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci           DEFAULT NULL COMMENT '昵称',
    `image`                  varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci          DEFAULT NULL COMMENT '头像地址',
    `relename`               varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci           DEFAULT NULL COMMENT '真实姓名',
    `cardid`                 varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci           DEFAULT NULL COMMENT '身份证',
    `gender`                 char(1) CHARACTER SET utf8 COLLATE utf8_general_ci      NOT NULL DEFAULT '0' COMMENT '性别  0 保密 1男 2女 默认0',
    `birthday`               date                                                             DEFAULT NULL COMMENT '生日',
    `monthly_income`         char(1) CHARACTER SET utf8 COLLATE utf8_general_ci               DEFAULT NULL COMMENT '月收入  0 无收入 1 2000以下 2 2000-3999 3 4000-5999\n4 6000－7999  5 8000以上',
    `marriage_status`        char(1) CHARACTER SET utf8 COLLATE utf8_general_ci      NOT NULL DEFAULT '0' COMMENT '婚姻状况  0 保密 1未婚 2 已婚 默认0 保姆',
    `mobile`                 varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci           DEFAULT NULL COMMENT '手机号码',
    `email`                  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci           DEFAULT NULL COMMENT '邮箱地址',
    `modified_email`         varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci          DEFAULT NULL COMMENT '更改中的邮箱（绑定新邮箱使用）',
    `check_code`             varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci          DEFAULT NULL COMMENT '校验码（绑定新邮箱时使用）',
    `province`               bigint(20) DEFAULT NULL COMMENT '省',
    `city`                   bigint(20) DEFAULT NULL COMMENT '市',
    `county`                 bigint(20) DEFAULT NULL COMMENT '区',
    `detailaddress`          varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci          DEFAULT NULL COMMENT '详细地址',
    `interest`               varchar(2048) CHARACTER SET utf8 COLLATE utf8_general_ci         DEFAULT NULL COMMENT '兴趣爱好',
    `source`                 char(1) CHARACTER SET utf8 COLLATE utf8_general_ci               DEFAULT NULL COMMENT '用户注册来源 1 pc  2app  3 手机h5 4 管理员后台新增\n',
    `status`                 char(1) CHARACTER SET utf8 COLLATE utf8_general_ci               DEFAULT '1' COMMENT '用户状态 1 正常 2 冻结  3 未启用 默认1 ',
    `sign_num`               int(11) DEFAULT 0 COMMENT '会员签到次数',
    `is_mobile_verification` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci               DEFAULT '0' COMMENT '手机是否验证  0 否 1 验证 默认0 ',
    `is_email_verification`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci               DEFAULT '0' COMMENT '邮箱是否验证   0 否 1 验证  默认0  ',
    `login_error_count`      int(11) DEFAULT NULL COMMENT '错误登录的次数',
    `del_flag`               char(1) CHARACTER SET utf8 COLLATE utf8_general_ci               DEFAULT '0' COMMENT '删除标记 0 未删除 1删除 默认0 ',
    `create_time`            timestamp(0)                                                     DEFAULT NULL COMMENT '创建时间',
    `modify_time`            timestamp(0)                                                     DEFAULT NULL COMMENT '修改时间',
    `del_time`               timestamp(0)                                                     DEFAULT NULL COMMENT '删除时间',
    `lock_time`              timestamp(0)                                                     DEFAULT NULL COMMENT '锁定时间',
    `last_login_time`        timestamp(0)                                                     DEFAULT NULL COMMENT '最近登陆时间',
    `self_recommend_code`    varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci           DEFAULT NULL COMMENT '会员自己的推荐码',
    `applet_open_id`         varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci           DEFAULT NULL,
    `app_open_id`            varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci           DEFAULT NULL,
    `h5_open_id`             varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci           DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB  CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '会员表' ROW_FORMAT = Dynamic;
INSERT INTO `sys_menu` values ('1070', '会员管理', 0, 1, 'member', 'member', '', 1, 0, 'C', '0', '0', 'member:list', 'peoples', 'admin', sysdate(), '', null, '会员菜单');
INSERT INTO `sys_menu` values ('1071', '会员查询', '1070', '1', '#', '', 1, 0, 'F', '0', '0', 'member:query', '#', 'admin', sysdate(), '',null, '');
INSERT INTO `sys_menu` values ('1072', '会员新增', '1070', '2', '#', '', 1, 0, 'F', '0', '0', 'member:add', '#', 'admin', sysdate(), '',null, '');
INSERT INTO `sys_menu` values ('1073', '会员修改', '1070', '3', '#', '', 1, 0, 'F', '0', '0', 'member:edit', '#', 'admin', sysdate(), '',null, '');
INSERT INTO `sys_menu` values ('1074', '会员删除', '1070', '4', '#', '', 1, 0, 'F', '0', '0', 'member:remove', '#', 'admin', sysdate(), '',null, '');
INSERT INTO `sys_menu` values ('1075', '会员导出', '1070', '5', '#', '', 1, 0, 'F', '0', '0', 'member:export', '#', 'admin', sysdate(), '',null, '');
INSERT INTO `sys_menu` values ('1076', '会员导出', '1070', '5', '#', '', 1, 0, 'F', '0', '0', 'member:import', '#', 'admin', sysdate(), '',null, '');
INSERT INTO `sys_menu` VALUES (2007, '内容管理', 0, 1, 'cms', NULL, NULL, 1, 0, 'M', '0', '0', NULL, 'documentation', 'admin', '2021-12-20 14:53:48', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2026, '文件管理', 2007, 8, 'fileInfo', 'cms/fileInfo/index', NULL, 1, 0, 'C', '0', '0', 'cms:fileInfo:list', '#', 'admin', '2021-12-27 22:29:53', 'admin', '2022-01-21 10:28:14', '文件管理菜单');

