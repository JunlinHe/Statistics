/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50622
Source Host           : localhost:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 50622
File Encoding         : 65001

Date: 2015-10-29 17:46:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tbl_user
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user`;
CREATE TABLE `tbl_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL COMMENT '姓名',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `serial_number` varchar(50) DEFAULT NULL COMMENT '注册后的序列号',
  `uuid` varchar(15) DEFAULT NULL COMMENT '移动设备国际身份码',
  `salt` varchar(100) DEFAULT NULL COMMENT '盐渍算法密钥',
  `state` int(1) DEFAULT NULL COMMENT '状态',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `address` varchar(200) DEFAULT NULL COMMENT '地址',
  `company` text COMMENT '公司',
  `phone` varchar(20) DEFAULT NULL COMMENT '电话',
  `email` varchar(100) DEFAULT NULL,
  `ip` varchar(15) DEFAULT NULL COMMENT 'IP',
  `client` varchar(100) DEFAULT NULL COMMENT '客户端类型',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `head_url` varchar(255) DEFAULT NULL COMMENT '头像',
  `creator` varchar(255) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `dsc` text COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of tbl_user
-- ----------------------------

-- ----------------------------
-- Table structure for tbl_user_log
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user_log`;
CREATE TABLE `tbl_user_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `log_type` int(1) DEFAULT NULL COMMENT '日志类型：0 正常 1 异常',
  `log_info` text COMMENT '日志信息',
  `log_time` datetime DEFAULT NULL COMMENT '日志时间',
  `ip` varchar(15) DEFAULT NULL COMMENT '操作IP',
  `area` varchar(255) DEFAULT NULL COMMENT 'IP所在地区',
  `method_name` varchar(100) DEFAULT NULL COMMENT '操作方法',
  `model_name` varchar(100) DEFAULT NULL COMMENT '操作模块',
  `err_code` varchar(255) DEFAULT NULL COMMENT '异常代码',
  `err_info` text COMMENT '异常信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='操作日志';

-- ----------------------------
-- Records of tbl_user_log
-- ----------------------------
