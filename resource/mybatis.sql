/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50622
Source Host           : localhost:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 50622
File Encoding         : 65001

Date: 2015-11-04 17:51:20
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
  `ip` varchar(15) DEFAULT NULL COMMENT '最后登录IP',
  `client` varchar(100) DEFAULT NULL COMMENT '客户端类型',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `head_url` varchar(255) DEFAULT NULL COMMENT '头像',
  `creator` varchar(255) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `dsc` text COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of tbl_user
-- ----------------------------
INSERT INTO `tbl_user` VALUES ('1', '何俊霖2', '1a2a008bca04c3c51df947151e37f844', '10d066131053c9e713e36463c2e7c8f9', '12345659', '', '0', '19', 'ewrwe', 'sdfeewr', '18500000000', '86132587@qq.com', '139.212.73.18', 'WEB', '2015-11-03 14:13:40', '234', '何俊霖2', '2015-11-03 14:13:39', '213');
INSERT INTO `tbl_user` VALUES ('2', '何俊霖2', 'ff9cd6e0da8870bf343b0ff1c45ad0e4', '4f63ee5122319d2335b6c6057329733b', '123566659', '', '0', '19', 'ewrwe', 'sdfeewr', '18500000000', '86132587@qq.com', '106.88.153.28', '安卓', '2015-11-03 14:18:46', '234', '何俊霖2', '2015-11-03 14:18:46', '213');
INSERT INTO `tbl_user` VALUES ('3', '何俊霖2', '17bf69d8c1aba4f30851ff0e0f2cbcd2', '91e8d95f4be27b3a5dc4d4f939124ab4', '1235759', '', '0', '19', 'ewrwe', 'sdfeewr', '18500000000', '86132587@qq.com', '222.39.183.183', '安卓', '2015-11-03 14:18:54', '234', '何俊霖2', '2015-11-03 14:18:54', '213');
INSERT INTO `tbl_user` VALUES ('4', '何俊霖2', 'f05b59857ff16d509a2c0bc41b89592c', '1f8e36e42d6b3bd774de70630f04480a', '12567759', '', '0', '19', 'ewrwe', 'sdfeewr', '18500000000', '86132587@qq.com', '182.85.210.44', '安卓', '2015-11-03 14:18:59', '234', '何俊霖2', '2015-11-03 14:18:59', '213');
INSERT INTO `tbl_user` VALUES ('5', '改好', 'bba499115a11adc26b09fb8d10477a88', '832a84828088d3b4507ea661b380b52e', '4652567759', '', '0', '19', 'ewrwe', 'sdfeewr', '18500000000', '86132587@qq.com', '121.77.46.167', 'PC客户端', '2015-11-03 14:19:19', '234', '改好', '2015-11-03 14:19:19', '213');
INSERT INTO `tbl_user` VALUES ('6', '改好', 'c11d035164b21d00682d992e80caf7f5', '322e9cf58e66c4de20bd0753d63d3ad3', '465557759', '', '0', '19', 'ewrwe', 'sdfeewr', '18500000000', '86132587@qq.com', '222.80.64.153', 'PC客户端', '2015-11-03 14:19:29', '234', '改好', '2015-11-03 14:19:24', '213');
INSERT INTO `tbl_user` VALUES ('7', '改好', '8db6d641628ded91d6f3e741f326d9a2', '8b721cc4a3b17b143ba0b6be236c7642', '456687759', '', '0', '19', 'ewrwe', 'sdfeewr', '18500000000', '86132587@qq.com', '210.43.53.31', 'PC客户端', '2015-11-03 14:19:59', '234', '改好', '2015-11-03 14:19:31', '213');
INSERT INTO `tbl_user` VALUES ('8', '改好', 'e365ffc950949167bece9fe79462cef6', 'b010460b50f75fc59afcca03c6acaac0', '45667859', '', '0', '19', 'ewrwe', 'sdfeewr', '18500000000', '86132587@qq.com', '123.233.23.29', 'PC客户端', '2015-11-03 14:19:59', '234', '改好', '2015-11-03 14:19:35', '213');
INSERT INTO `tbl_user` VALUES ('9', '改好', 'f41b666354c2c268f3c312c24571d7fe', '8b4296dd4c2b9f39bcdf4e22f32fd247', '455667859', '', '0', '19', 'ewrwe', 'sdfeewr', '18500000000', '86132587@qq.com', '121.76.18.242', 'PC客户端', '2015-11-03 14:19:59', '234', '改好', '2015-11-03 14:19:37', '213');
INSERT INTO `tbl_user` VALUES ('10', '改好', 'bb14868c76707b2dbc0f5a56aab32a6b', '0ea7bf244745df637264093734a157a2', '5465667859', '', '0', '19', 'ewrwe', 'sdfeewr', '18500000000', '86132587@qq.com', '36.58.47.67', 'PC客户端', '2015-11-03 14:19:59', '234', '改好', '2015-11-03 14:19:40', '213');
INSERT INTO `tbl_user` VALUES ('11', '改好', '3836f4340156d4cda3e97ee21d7627fb', 'eb3583a4a03ea0811131e288a3b04264', '0985667859', '', '0', '19', 'ewrwe', 'sdfeewr', '18500000000', '86132587@qq.com', '123.235.48.130', 'PC客户端', '2015-11-03 14:19:59', '234', '改好', '2015-11-03 14:19:43', '213');
INSERT INTO `tbl_user` VALUES ('12', '改好', 'df891625dd459d9ac888b3c8f58d81f0', 'dc2875115eda3e1919c04b4ebab33549', '0985859', '', '0', '19', 'ewrwe', 'sdfeewr', '18500000000', '86132587@qq.com', '171.14.28.45', 'WEB', '2015-11-03 14:32:37', '234', '改好', '2015-11-03 14:32:37', '213');
INSERT INTO `tbl_user` VALUES ('13', '改好', 'b168476e7de16a1c92023c9788f6e304', '0f770762c438d9260b5c2be9e8bc8fa1', '09858594', '', '0', '19', 'ewrwe', 'sdfeewr', '18500000000', '86132587@qq.com', '106.92.58.42', 'WEB', '2015-11-03 14:32:41', '234', '改好', '2015-11-03 14:32:41', '213');
INSERT INTO `tbl_user` VALUES ('14', '改好', '41524a8d876e9f03dc16bbbba293f4b4', '64d20c8a2f63e6aef8efe98f16b1698d', '098554', '', '0', '19', 'ewrwe', 'sdfeewr', '18500000000', '86132587@qq.com', '106.81.235.182', 'WEB', '2015-11-03 14:32:43', '234', '改好', '2015-11-03 14:32:43', '213');
INSERT INTO `tbl_user` VALUES ('15', '改好', 'bb9cb46cc09e70fb45ae3688028feffe', '93db22cdc9bef6d781d162f84b1aeb2d', '0967744', '', '0', '19', 'ewrwe', 'sdfeewr', '18500000000', '86132587@qq.com', '210.46.61.137', 'WEB', '2015-11-03 14:32:46', '234', '改好', '2015-11-03 14:32:46', '213');
INSERT INTO `tbl_user` VALUES ('16', '改好', '097393e21cc6ab068e67115a9fd36938', 'e0caeece63e2cf074e5515981504c5f3', '0965744', '', '0', '19', 'ewrwe', 'sdfeewr', '18500000000', '86132587@qq.com', '182.84.45.239', 'WEB', '2015-11-03 14:33:16', '234', '改好', '2015-11-03 14:32:49', '213');
INSERT INTO `tbl_user` VALUES ('17', '改好', 'c1002a7779c02f945e6800be81c9a6c6', '708127838772d06e36c7dc435100a4e0', '456765744', '', '0', '19', 'ewrwe', 'sdfeewr', '18500000000', '86132587@qq.com', '139.214.196.142', 'WEB', '2015-11-03 14:33:16', '234', '改好', '2015-11-03 14:32:51', '213');
INSERT INTO `tbl_user` VALUES ('18', '改好', '05af920ee36e6497a58dc5f131dc8f66', '53fd914afd926414637e2a60cacbd30c', '67686678', '', '0', '19', 'ewrwe', 'sdfeewr', '18500000000', '86132587@qq.com', '123.233.211.67', 'WEB', '2015-11-03 14:33:16', '234', '改好', '2015-11-03 14:32:56', '213');
INSERT INTO `tbl_user` VALUES ('19', '改好', 'aeee9f43c4c5697ef27c5834ebd28678', 'c3689369336b0ad24fa2c55fa6f527d8', '6768667779', '', '0', '19', 'ewrwe', 'sdfeewr', '18500000000', '86132587@qq.com', '123.235.253.31', 'WEB', '2015-11-03 14:33:16', '234', '改好', '2015-11-03 14:32:58', '213');
INSERT INTO `tbl_user` VALUES ('20', '改好', '2a88c0b82ac4728fa6ba5ccd5657050e', '56cae2e044b3bd5aa498890bc224a5a0', '6767677779', '', '0', '19', 'ewrwe', 'sdfeewr', '18500000000', '86132587@qq.com', '36.60.81.76', 'WEB', '2015-11-03 14:33:16', '234', '改好', '2015-11-03 14:33:01', '213');
INSERT INTO `tbl_user` VALUES ('21', '改好', 'f67809f099a0a068412acfbe9ae1bc33', '4dc774c9d00621b904baea7b69cc5902', '56767677779', '', '0', '19', 'ewrwe', 'sdfeewr', '18500000000', '86132587@qq.com', '123.234.39.47', 'WEB', '2015-11-03 14:33:16', '234', '改好', '2015-11-03 14:33:04', '213');
INSERT INTO `tbl_user` VALUES ('22', '改好', 'cf4fd9e0f67726ec3de2bbdcbe13b9b6', '2f5c4d00bbd83ce54dfe40b97cbde3e5', '564564679', '', '0', '19', 'ewrwe', 'sdfeewr', '18500000000', '86132587@qq.com', '61.232.80.202', '安卓', '2015-11-03 14:33:16', '234', '改好', '2015-11-03 14:33:15', '213');
INSERT INTO `tbl_user` VALUES ('23', '改好', '379baf0b4728291bb1973dee5a4a8444', '13950651fbe93aa60eff5b18950d2bf5', '768564679', '', '0', '19', 'ewrwe', 'sdfeewr', '18500000000', '86132587@qq.com', '139.204.52.253', '安卓', '2015-11-03 14:33:47', '234', '改好', '2015-11-03 14:33:17', '213');
INSERT INTO `tbl_user` VALUES ('24', '改好', '33672044cbd955b9c7024fb8defe4ae1', 'a157043f5a47f00f077dbb6a783adda3', '768567898', '', '0', '19', 'ewrwe', 'sdfeewr', '18500000000', '86132587@qq.com', '106.84.115.44', '安卓', '2015-11-03 14:33:47', '234', '改好', '2015-11-03 14:33:19', '213');
INSERT INTO `tbl_user` VALUES ('25', '改好', '7e1887933b25014d0e8aa1617f4da20f', 'ec0499af18a4dcf5b1b803528f9fdb6b', '67668567898', '', '0', '19', 'ewrwe', 'sdfeewr', '18500000000', '86132587@qq.com', '222.72.73.237', '安卓', '2015-11-03 14:33:47', '234', '改好', '2015-11-03 14:33:21', '213');
INSERT INTO `tbl_user` VALUES ('26', '改好', 'bdf00d04a13a356a5ae0b2fa1a7284a9', '4233ffdfd49b48d40bcc393b7de14281', '6766856788998', '', '0', '19', 'ewrwe', 'sdfeewr', '18500000000', '86132587@qq.com', '210.33.153.46', '安卓', '2015-11-03 14:33:47', '234', '改好', '2015-11-03 14:33:24', '213');
INSERT INTO `tbl_user` VALUES ('27', '改好', 'd655f432cc946d2cbe2a8c7e1d78a70e', '9d08fb9f3908701fc552bb6e2bc7052c', '676788998', '', '0', '19', 'ewrwe', 'sdfeewr', '18500000000', '86132587@qq.com', '210.33.153.46', '安卓', '2015-11-03 14:33:47', '234', '改好', '2015-11-03 14:33:27', '213');
INSERT INTO `tbl_user` VALUES ('28', '改好', '32b7aa39bfaf32fbcd18c618a09f9460', '85f1323dc976e5209eca5458a811f668', '67678676998', '', '0', '19', 'ewrwe', 'sdfeewr', '18500000000', '86132587@qq.com', '139.215.137.164', '安卓', '2015-11-03 14:33:47', '234', '改好', '2015-11-03 14:33:29', '213');
INSERT INTO `tbl_user` VALUES ('29', '啦啦啦', 'd784632f5ec6cccd45bb5f9d617d2344', 'f6083039ef9c7eaf7e76768e7f472ed8', '999999', '', '0', '19', 'ewrwe', 'sdfeewr', '18500000000', '86132587@qq.com', '61.232.90.67', 'PC客户端', '2015-11-04 09:57:29', '234', '啦啦啦', '2015-11-04 09:57:29', '213');
INSERT INTO `tbl_user` VALUES ('33', '啦啦啦1', 'b0f23860948a8591efac80f2880061c1', 'a58aa929177517551c3005db0a3d6b75', '996699', '', '0', '19', 'ewrwe', 'sdfeewr', '18500000000', '86132587@qq.com', '222.50.159.175', '1', '2015-11-04 10:09:39', '234', '啦啦啦1', '2015-11-04 10:09:39', '213');
INSERT INTO `tbl_user` VALUES ('34', '啦啦啦2', '7ee0b8c271e30e7edc718dac3cdfaf31', 'abeca32f596cb19c48f5fb740d7a76b9', '9967779', '', '0', '19', 'ewrwe', 'sdfeewr', '18500000000', '86132587@qq.com', '222.29.27.72', '1', '2015-11-04 10:11:31', '234', '啦啦啦2', '2015-11-04 10:11:31', '213');
INSERT INTO `tbl_user` VALUES ('35', '啦啦啦3', 'b02086042e55ef7f8c50f6a081a6be62', '86bc74ca8d7487a61c2d8b8ec964a536', '99675786', '', '0', '19', 'ewrwe', 'sdfeewr', '18500000000', '86132587@qq.com', '123.232.195.85', '1', '2015-11-04 10:16:28', '234', '啦啦啦3', '2015-11-04 10:16:06', '213');
INSERT INTO `tbl_user` VALUES ('36', '啦啦啦4', 'b478dc135be164d3ec16ce47979398e7', 'e56b754b580c17dea66890d74d7184c0', '49675786', '', '0', '19', 'ewrwe', 'sdfeewr', '18500000000', '86132587@qq.com', '182.86.225.238', '1', '2015-11-04 10:23:33', '234', '啦啦啦4', '2015-11-04 10:23:28', '213');
INSERT INTO `tbl_user` VALUES ('37', '榕榕兔用途 ', '87e261dc8f075d05d520d1b61659d285', '4e1c2637f0be1a088002ac1b4696599a', '4967487957', 'yicoUrjFr', '0', '19', 'ewrwe', 'sdfeewr', '18500000000', '86132587@qq.com', '121.76.17.85', '1', '2015-11-04 10:29:39', '234', '榕榕兔用途 ', '2015-11-04 10:29:39', '213');

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
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COMMENT='操作日志';

-- ----------------------------
-- Records of tbl_user_log
-- ----------------------------
INSERT INTO `tbl_user_log` VALUES ('1', '1', '0', '用户登录', '2015-11-03 14:13:39', '172.16.1.48', '未分配或者内网IP', '', 'com.sky.statistics.web.controller.UserController$1', null, null);
INSERT INTO `tbl_user_log` VALUES ('2', '2', '0', '用户登录', '2015-11-03 14:18:46', '172.16.1.48', '未分配或者内网IP', '', 'com.sky.statistics.web.controller.UserController$1', null, null);
INSERT INTO `tbl_user_log` VALUES ('3', '3', '0', '用户登录', '2015-11-03 14:18:54', '172.16.1.48', '未分配或者内网IP', '', 'com.sky.statistics.web.controller.UserController$1', null, null);
INSERT INTO `tbl_user_log` VALUES ('4', '4', '0', '用户登录', '2015-11-03 14:18:59', '172.16.1.48', '未分配或者内网IP', '', 'com.sky.statistics.web.controller.UserController$1', null, null);
INSERT INTO `tbl_user_log` VALUES ('5', '5', '0', '用户登录', '2015-11-03 14:19:19', '172.16.1.48', '未分配或者内网IP', '', 'com.sky.statistics.web.controller.UserController$1', null, null);
INSERT INTO `tbl_user_log` VALUES ('6', '6', '0', '用户登录', '2015-11-03 14:19:29', '172.16.1.48', '未分配或者内网IP', '', 'com.sky.statistics.web.controller.UserController$1', null, null);
INSERT INTO `tbl_user_log` VALUES ('7', '7', '0', '用户登录', '2015-11-03 14:19:59', '172.16.1.48', '未分配或者内网IP', '', 'com.sky.statistics.web.controller.UserController$1', null, null);
INSERT INTO `tbl_user_log` VALUES ('8', '12', '0', '用户登录', '2015-11-03 14:32:37', '172.16.1.48', '未分配或者内网IP', '', 'com.sky.statistics.web.controller.UserController$1', null, null);
INSERT INTO `tbl_user_log` VALUES ('9', '13', '0', '用户登录', '2015-11-03 14:32:41', '172.16.1.48', '未分配或者内网IP', '', 'com.sky.statistics.web.controller.UserController$1', null, null);
INSERT INTO `tbl_user_log` VALUES ('10', '14', '0', '用户登录', '2015-11-03 14:32:43', '172.16.1.48', '未分配或者内网IP', '', 'com.sky.statistics.web.controller.UserController$1', null, null);
INSERT INTO `tbl_user_log` VALUES ('11', '15', '0', '用户登录', '2015-11-03 14:32:46', '172.16.1.48', '未分配或者内网IP', '', 'com.sky.statistics.web.controller.UserController$1', null, null);
INSERT INTO `tbl_user_log` VALUES ('12', '16', '0', '用户登录', '2015-11-03 14:33:16', '172.16.1.48', '未分配或者内网IP', '', 'com.sky.statistics.web.controller.UserController$1', null, null);
INSERT INTO `tbl_user_log` VALUES ('13', '23', '0', '用户登录', '2015-11-03 14:33:46', '172.16.1.48', '未分配或者内网IP', '', 'com.sky.statistics.web.controller.UserController$1', null, null);
INSERT INTO `tbl_user_log` VALUES ('14', '29', '0', '用户登录', '2015-11-04 09:57:29', '172.16.1.48', '未分配或者内网IP', '', 'com.sky.statistics.web.controller.UserController$1', null, null);
INSERT INTO `tbl_user_log` VALUES ('15', '19', '0', '用户登录', '2015-11-04 09:59:56', '172.16.1.48', '未分配或者内网IP', 'methodName', 'model_name', null, null);
INSERT INTO `tbl_user_log` VALUES ('16', '18', '0', '用户登录', '2015-11-04 10:03:23', '61.234.193.168', '中国,福建省,福州市,铁通', 'methodName', 'model_name', null, null);
INSERT INTO `tbl_user_log` VALUES ('17', '18', '0', '用户登录', '2015-11-04 10:03:49', '210.25.40.144', '中国,北京市,北京市,教育网', 'methodName', 'model_name', null, null);
INSERT INTO `tbl_user_log` VALUES ('18', '33', '0', '用户登录', '2015-11-04 10:09:39', '172.16.1.48', '未分配或者内网IP', '', 'com.sky.statistics.web.controller.UserController$1', null, null);
INSERT INTO `tbl_user_log` VALUES ('19', '34', '0', '用户登录', '2015-11-04 10:11:31', '172.16.1.48', '未分配或者内网IP', '', 'com.sky.statistics.web.controller.UserController$1', null, null);
INSERT INTO `tbl_user_log` VALUES ('20', '35', '0', '用户登录', '2015-11-04 10:18:26', '36.63.158.231', '中国,安徽省,芜湖市,电信', '', 'com.sky.statistics.web.controller.UserController$1', null, null);
INSERT INTO `tbl_user_log` VALUES ('21', '36', '0', '用户登录', '2015-11-04 10:24:06', '61.235.10.223', '中国,江西省,新余市,铁通', '', 'com.sky.statistics.web.controller.UserController$1', null, null);
INSERT INTO `tbl_user_log` VALUES ('22', '1', '0', '分页查询日志', '2015-11-04 12:58:58', '210.39.214.230', '中国,广东省,汕头市,教育网', 'selectByExampleAndPage', 'com.sky.statistics.web.service.impl.UserLogServiceImpl', null, null);
