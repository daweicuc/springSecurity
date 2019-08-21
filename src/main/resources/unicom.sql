/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : unicom

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2019-08-19 23:25:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `login`
-- ----------------------------
DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT '0',
  `user_agent` varchar(128) DEFAULT '' COMMENT '浏览器标识',
  `ip_address` varchar(128) DEFAULT '' COMMENT 'IP地址',
  `type` int(11) DEFAULT '1' COMMENT '1：网页登录\r\n2：OpenId登录',
  `login_time` datetime DEFAULT NULL COMMENT '登录时间',
  `modified_time` datetime DEFAULT NULL,
  `status` int(11) DEFAULT '1' COMMENT '1：正常',
  `is_delete` tinyint(4) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of login
-- ----------------------------

-- ----------------------------
-- Table structure for `menu`
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `icon` varchar(255) DEFAULT '' COMMENT '资源图标',
  `name` varchar(24) DEFAULT '' COMMENT '资源名字',
  `authority` varchar(64) DEFAULT '' COMMENT '权限',
  `url` varchar(255) DEFAULT '' COMMENT '资源路径',
  `type` int(11) DEFAULT '0' COMMENT '资源类型（1:一级菜单，2:二级菜单，3:链接）',
  `parent_id` bigint(20) DEFAULT '0' COMMENT '父资源ID',
  `sort` int(11) DEFAULT '0' COMMENT '资源顺序',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modified_time` datetime DEFAULT NULL COMMENT '修改时间',
  `status` int(11) DEFAULT '1' COMMENT '1：正常',
  `is_delete` tinyint(4) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '', 'Spring Security', 'index', '/index', '1', '0', '1', '2016-12-02 19:57:40', '2016-12-02 19:57:41', '1', '0');
INSERT INTO `menu` VALUES ('3', '', '会员列表', 'user_list', '/user/list', '2', '1', '1', '2016-12-23 15:40:27', '2016-12-23 15:40:27', '1', '0');
INSERT INTO `menu` VALUES ('4', '', '角色列表', 'role_list', '/role/list', '2', '1', '2', '2016-12-23 15:44:02', '2016-12-23 15:44:02', '1', '0');
INSERT INTO `menu` VALUES ('5', '', '菜单列表', 'menu_list', '/menu/list', '2', '1', '3', '2016-12-23 15:45:30', '2016-12-23 15:45:30', '1', '0');
INSERT INTO `menu` VALUES ('6', '', '添加用户', 'user_add', '/user/add', '3', '3', '1', '2016-12-28 11:38:26', '2016-12-28 11:38:26', '1', '0');
INSERT INTO `menu` VALUES ('7', '', '修改用户', 'user_edit', '/user/update', '3', '3', '2', '2016-12-28 11:39:06', '2016-12-28 11:39:06', '1', '0');
INSERT INTO `menu` VALUES ('10', '', '删除用户', 'user_del', '/user/del', '3', '3', '5', '2016-12-28 11:41:24', '2016-12-28 11:41:24', '1', '0');
INSERT INTO `menu` VALUES ('11', '', '个人资金管理', 'pay_info', '/payinfo/inmanager', '3', '4', '1', '2019-06-20 14:21:56', '2019-06-20 14:21:59', '1', '0');
INSERT INTO `menu` VALUES ('12', '', '添加开销', 'add_pay', '/payinfo/pay', '3', '4', '1', '2019-06-22 10:44:55', '2019-06-22 10:45:02', '1', '0');
INSERT INTO `menu` VALUES ('13', '', '添加收入详情', 'add_inmoney', '/inmoneyinfo/inmoney', '3', '4', '1', '2019-06-22 10:45:48', '2019-06-22 10:45:51', '1', '0');
INSERT INTO `menu` VALUES ('14', '', 'test', 'test', '/payinfo/test', '3', '4', '1', null, null, '1', '0');



-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(24) DEFAULT '' COMMENT '角色名字(英文）',
  `name_remark` varchar(24) DEFAULT '' COMMENT '角色描述',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modified_time` datetime DEFAULT NULL COMMENT '修改时间',
  `status` int(11) DEFAULT '1' COMMENT '1：正常',
  `is_delete` tinyint(4) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'super_admin', '超级管理员', '2016-12-02 12:10:07', '2016-12-02 12:10:08', '1', '0');
INSERT INTO `role` VALUES ('2', 'general_user', '普通用户', '2018-09-11 15:02:20', '2018-09-11 15:02:22', '1', '0');

-- ----------------------------
-- Table structure for `role_menu`
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT '0' COMMENT '角色ID',
  `menu_id` bigint(20) DEFAULT '0' COMMENT '菜单ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of role_menu
-- ----------------------------
INSERT INTO `role_menu` VALUES ('1', '1', '1');
INSERT INTO `role_menu` VALUES ('2', '1', '10');
INSERT INTO `role_menu` VALUES ('3', '1', '3');
INSERT INTO `role_menu` VALUES ('4', '1', '4');
INSERT INTO `role_menu` VALUES ('5', '1', '5');
INSERT INTO `role_menu` VALUES ('6', '1', '6');
INSERT INTO `role_menu` VALUES ('7', '1', '7');
INSERT INTO `role_menu` VALUES ('8', '2', '1');
INSERT INTO `role_menu` VALUES ('9', '2', '3');
INSERT INTO `role_menu` VALUES ('10', '2', '4');
INSERT INTO `role_menu` VALUES ('11', '2', '5');
INSERT INTO `role_menu` VALUES ('13', '2', '11');
INSERT INTO `role_menu` VALUES ('14', '2', '12');
INSERT INTO `role_menu` VALUES ('15', '2', '13');
INSERT INTO `role_menu` VALUES ('16', '2', '14');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(32) DEFAULT '' COMMENT '名字',
  `username` varchar(24) DEFAULT '' COMMENT '用户名',
  `password` varchar(200) DEFAULT '' COMMENT '密码',
  `admin` int(11) DEFAULT '1' COMMENT '1：普通\r\n2：管理员',
  `create_date` datetime DEFAULT NULL COMMENT '注册时间',
  `modified_time` datetime DEFAULT NULL,
  `status` int(11) DEFAULT '1' COMMENT '1：正常\r\n2：停用',
  `is_delete` tinyint(4) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '管理员账号', 'admin', '$2a$10$QrFzqVQJnFDL/Fvw5P5vbO0Z8bNAZlso.VWWoYSuGmYRR4T.zHmZq', '2', '2016-12-23 16:18:38', '2016-12-28 16:02:55', '1', '0');
INSERT INTO `user` VALUES ('2', '李四', 'user', '$2a$2a$10$nNda16zcHi7bff42He2qaOU.muB/IG/k2j.Y3gV1yqlx0IHZdJ70W', '1', '2018-09-11 15:00:33', '2018-09-11 15:00:34', '1', '0');
INSERT INTO `user` VALUES ('3', '11', 'dd', '$2a$10$.oHXsUaEDmF1zfhH1VKriOzrOX09Gmw4d2WG7oFaPqAvXM0yrplpK', '1', '2019-06-19 22:20:50', '2019-06-19 22:20:57', '1', '0');
INSERT INTO `user` VALUES ('4', '22', 'aa', '$2a$2a$2a$10$rfv9L3RVKe3V7yxM3yUAJeB/3VZ/aClnwrZwvUbQGrI83T8VeoQYy', '1', '2019-06-20 14:19:10', '2019-06-20 14:19:14', '1', '0');

-- ----------------------------
-- Table structure for `user_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT '0' COMMENT '用户ID',
  `role_id` bigint(20) DEFAULT '0' COMMENT '角色ID',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modified_time` datetime DEFAULT NULL COMMENT '修改时间',
  `status` int(11) DEFAULT '1' COMMENT '1：正常',
  `is_delete` tinyint(4) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1', '1', '2016-12-02 12:10:19', '2016-12-25 17:11:15', '1', '0');
INSERT INTO `user_role` VALUES ('2', '2', '2', '2018-09-11 16:12:14', '2018-09-11 16:12:15', '1', '0');
INSERT INTO `user_role` VALUES ('3', '3', '2', '2019-06-19 22:21:40', '2019-06-19 22:21:42', '1', '0');
INSERT INTO `user_role` VALUES ('4', '4', '2', '2019-06-20 14:19:32', '2019-06-20 14:19:36', '1', '0');


