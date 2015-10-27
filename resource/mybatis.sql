/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50622
Source Host           : localhost:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 50622
File Encoding         : 65001

Date: 2015-10-27 17:46:10
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
  `imei` varchar(15) DEFAULT NULL COMMENT '移动设备国际身份码',
  `salt` varchar(100) DEFAULT NULL COMMENT '盐渍算法密钥',
  `state` int(1) DEFAULT NULL COMMENT '状态',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `address` varchar(200) DEFAULT NULL COMMENT '地址',
  `company` text COMMENT '公司',
  `phone` varchar(20) DEFAULT NULL COMMENT '电话',
  `ip` varchar(15) DEFAULT NULL COMMENT 'IP',
  `client` varchar(100) DEFAULT NULL COMMENT '客户端类型',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `head_url` varchar(255) DEFAULT NULL COMMENT '头像',
  `creator` varchar(255) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `dsc` text COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of tbl_user
-- ----------------------------
INSERT INTO `tbl_user` VALUES ('1', '何俊霖', '123', null, null, null, null, '100', 'shenzhen', '123124', '34234', '234', '234', '2015-10-21 10:27:12', '324', '324', '2015-10-21 10:27:06', null);
INSERT INTO `tbl_user` VALUES ('2', '哈哈哒', '2323', null, null, null, null, '19', 'ewrwe', 'sdfeewr', '18500000000', '127.0.0.1', '1', '2015-10-22 17:16:01', '234', 'me', '2015-10-22 17:16:01', '213');
INSERT INTO `tbl_user` VALUES ('3', '萌萌哒', '12344', null, null, null, null, '19', 'ewrwe', 'sdfeewr', '18500000000', '127.0.0.1', '1', '2015-10-23 10:16:34', '234', 'me', '2015-10-23 10:16:34', '213');
INSERT INTO `tbl_user` VALUES ('4', '啥地方的法规', 'fdb52bfa016a86f7ff378acc928b2946', 'f3eff190552bab98a07b8ab6c3afc909', null, '169rLVEn1', null, '19', 'ewrwe', 'sdfeewr', '18500000000', '127.0.0.1', '1', '2015-10-26 16:35:21', '234', 'me', '2015-10-26 16:35:21', '213');
INSERT INTO `tbl_user` VALUES ('5', '啥地方的法规', '1c94a1b2cd66873b7d63910fdfe9df3a', '9b4dfc806d464b1dec3de86f30aa65c9', null, 'qmTeeQB3x', null, '20', 'ewrwe', 'sdfeewr', '18500000000', '127.0.0.1', '1', '2015-10-26 16:36:07', '234', 'me', '2015-10-26 16:36:07', '213');
INSERT INTO `tbl_user` VALUES ('6', '啥地方的法规', 'aa3dbf9134ed2e504ac26714ad98f632', '63cc6e022015b94b536add58180d07ce', null, 'OeHMfvN1O', null, '20', 'ewrwe', 'sdfeewr', '18500000000', '127.0.0.1', '1', '2015-10-26 16:36:08', '234', 'me', '2015-10-26 16:36:08', '213');
INSERT INTO `tbl_user` VALUES ('7', '啥地方的法规', '7557e979f4d35d509dc0baefbd1e20d1', 'ea7c1d23e9307b5620825d84ecc9c800', null, '1GAsfbJG6', null, '20', 'ewrwe', 'sdfeewr', '18500000000', '127.0.0.1', '1', '2015-10-26 16:36:08', '234', 'me', '2015-10-26 16:36:08', '213');
INSERT INTO `tbl_user` VALUES ('8', '啥地方的法规', '3438f272b08c12e42097e53cb6087c39', '8ae35ade6d68c653bc02a2169961e2a3', null, 'egKfkoVLt', null, '20', 'ewrwe', 'sdfeewr', '18500000000', '127.0.0.1', '1', '2015-10-26 16:36:08', '234', 'me', '2015-10-26 16:36:08', '213');
INSERT INTO `tbl_user` VALUES ('9', '啥地方的法规', '09a2bcc1e4e476750b8370fa739fb37f', '3a9986c9be2a5d3fdf7a99217240e9e2', null, 'ygKgW5oEr', null, '20', 'ewrwe', 'sdfeewr', '18500000000', '127.0.0.1', '1', '2015-10-26 16:36:08', '234', 'me', '2015-10-26 16:36:08', '213');
INSERT INTO `tbl_user` VALUES ('10', '啥地方的法规', '9fd131206b31b15e15514d81d5856205', '99f0e265db6595d72a46a626435833d3', null, '3j9Ix7q3N', null, '20', 'ewrwe', 'sdfeewr', '18500000000', '127.0.0.1', '1', '2015-10-26 16:36:08', '234', 'me', '2015-10-26 16:36:08', '213');
INSERT INTO `tbl_user` VALUES ('11', '啥地方的法规', 'd004ee303ab5744877aeb8b5587dfdee', '3bd35cbd2c6de79fca22d02389afaa7b', null, 'lLmeiNeSA', null, '20', 'ewrwe', 'sdfeewr', '18500000000', '127.0.0.1', '1', '2015-10-26 16:36:09', '234', 'me', '2015-10-26 16:36:09', '213');
INSERT INTO `tbl_user` VALUES ('12', '啥地方的法规', 'f2b0f4191eddfd0faee914df91544014', '761d8054689e857030b4ca384dd2d33c', null, 'oD8aU5IpC', null, '20', 'ewrwe', 'sdfeewr', '18500000000', '127.0.0.1', '1', '2015-10-26 16:36:09', '234', 'me', '2015-10-26 16:36:09', '213');
INSERT INTO `tbl_user` VALUES ('13', '啥地方的法规', '1d59df9b6e415e88cafc38432c07a534', 'a444e8aba16219dcf2647ca08c9be336', null, 'c4yZa03PJ', null, '20', 'ewrwe', 'sdfeewr', '18500000000', '127.0.0.1', '1', '2015-10-26 16:36:09', '234', 'me', '2015-10-26 16:36:09', '213');
INSERT INTO `tbl_user` VALUES ('14', '啥地方的法规', 'fd5f163957fafd9d3c014427de15c8ca', 'cf88b1f23252bd0ed7f342594c3f2aa0', null, 'ppIyNnzU1', null, '20', 'ewrwe', 'sdfeewr', '18500000000', '127.0.0.1', '1', '2015-10-26 16:36:09', '234', 'me', '2015-10-26 16:36:09', '213');
INSERT INTO `tbl_user` VALUES ('15', '啥地方的法规', '57107bfadbf9cf58023887a9e259c900', '9504ac7f89bf2a6ba5d0e7f9830c892a', null, 'GJb0xN8W1', null, '20', 'ewrwe', 'sdfeewr', '18500000000', '127.0.0.1', '1', '2015-10-26 16:36:09', '234', 'me', '2015-10-26 16:36:09', '213');
INSERT INTO `tbl_user` VALUES ('16', '啥地方的法规', 'c35f81b935949524d820839ee986517d', 'fc4af2bf4b1c4ecde4bd6b29ca802983', null, 'YSxcrTtjD', null, '20', 'ewrwe', 'sdfeewr', '18500000000', '127.0.0.1', '1', '2015-10-26 16:36:09', '234', 'me', '2015-10-26 16:36:09', '213');
INSERT INTO `tbl_user` VALUES ('17', '啥地方的法规', '66048224928f7bfdd729c04433754b8a', '2834f99b01eedd0337cb613efd74b29c', null, 'Ks2TT00hs', null, '20', 'ewrwe', 'sdfeewr', '18500000000', '127.0.0.1', '1', '2015-10-26 16:36:10', '234', 'me', '2015-10-26 16:36:10', '213');
INSERT INTO `tbl_user` VALUES ('18', '啥地方的法规', '83f19c292a21d42fa54e331f55b3864d', '057d54a318df7687161016b673b8826a', null, 'UKuhIOus7', null, '20', 'ewrwe', 'sdfeewr', '18500000000', '127.0.0.1', '1', '2015-10-26 16:36:10', '234', 'me', '2015-10-26 16:36:10', '213');
INSERT INTO `tbl_user` VALUES ('19', '啥地方的法规', 'b97ca073eb27fb6883f275660885968d', '6f605ad5dc96c77f3cd9ce4dc740867b', null, 'pUQsyQIwd', null, '20', 'ewrwe', 'sdfeewr', '18500000000', '127.0.0.1', '1', '2015-10-26 16:36:10', '234', 'me', '2015-10-26 16:36:10', '213');
INSERT INTO `tbl_user` VALUES ('20', '啥地方的法规', '63485e069f34456f969f774c778c4ce1', 'db7acb7512a055a71c07314ad907fd88', null, 'ymIxEwDzu', null, '20', 'ewrwe', 'sdfeewr', '18500000000', '127.0.0.1', '1', '2015-10-26 16:36:10', '234', 'me', '2015-10-26 16:36:10', '213');
INSERT INTO `tbl_user` VALUES ('21', '啥地方的法规', '0c3e7c0870fe1efd92e2bd175f2faa6f', '326c7f09d21cc99b4aedb61a22b8ece2', null, 'kjiKD0H8Y', null, '20', 'ewrwe', 'sdfeewr', '18500000000', '127.0.0.1', '1', '2015-10-26 16:36:10', '234', 'me', '2015-10-26 16:36:10', '213');
INSERT INTO `tbl_user` VALUES ('22', '啥地方的法规', '02a6908164413a6bf6b06ba9ba15cf8e', 'a6b03e789e29c7095728cb24a8adf6c4', null, 'vwH6pfDF5', null, '20', 'ewrwe', 'sdfeewr', '18500000000', '127.0.0.1', '1', '2015-10-26 16:36:10', '234', 'me', '2015-10-26 16:36:10', '213');
INSERT INTO `tbl_user` VALUES ('23', '啥地方的法规', '90baa5770fcf73abf04a3e112399deef', '4a12df520964df647ca43dc231b06d13', null, 'XoqVdoCd0', null, '20', 'ewrwe', 'sdfeewr', '18500000000', '127.0.0.1', '1', '2015-10-26 16:36:11', '234', 'me', '2015-10-26 16:36:11', '213');
INSERT INTO `tbl_user` VALUES ('24', '啥地方的法规', '0fcbc1ab184e50a2dcf54efe41791a75', '0ff289805edccf50900c31b6cf45e6ec', null, 'B0zVZBdZD', null, '20', 'ewrwe', 'sdfeewr', '18500000000', '127.0.0.1', '1', '2015-10-26 16:36:11', '234', 'me', '2015-10-26 16:36:11', '213');
INSERT INTO `tbl_user` VALUES ('25', '', '75281bc5849a6d89f5e6124f7c98769d', 'fa680801809d19d0a06306e700d43621', '12345678', 'h3a8GPDes', '0', '19', 'ewrwe', 'sdfeewr', '18500000000', '127.0.0.1', '1', '2015-10-27 15:29:16', '234', 'me', '2015-10-27 15:29:16', '213');
INSERT INTO `tbl_user` VALUES ('26', '', '54c3a8d18708f3c6d07aec9a1a8c982a', 'c3d8a0891b4126cf687e42cca3990c05', '12345678', 'YNOPRM2fL', '0', '19', 'ewrwe', 'sdfeewr', '18500000000', '127.0.0.1', '1', '2015-10-27 15:29:22', '234', 'me', '2015-10-27 15:29:22', '213');

-- ----------------------------
-- Table structure for tbl_user_log
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user_log`;
CREATE TABLE `tbl_user_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `user_serial_num` varchar(255) DEFAULT NULL COMMENT '用户序列号',
  `log_info` text COMMENT '日志信息',
  `log_time` datetime DEFAULT NULL COMMENT '日志时间',
  `ip` varchar(15) DEFAULT NULL COMMENT '操作IP',
  `area` varchar(255) DEFAULT NULL COMMENT 'IP所在地区',
  `method_name` varchar(100) DEFAULT NULL COMMENT '操作方法',
  `model_name` varchar(100) DEFAULT NULL COMMENT '操作模块',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='操作日志';

-- ----------------------------
-- Records of tbl_user_log
-- ----------------------------
INSERT INTO `tbl_user_log` VALUES ('1', '2', '123123123', '122', '2015-10-26 10:15:36', '192.168.1.1', '未分配或者内网IP,,,', 'methodName1', 'model_name1');
INSERT INTO `tbl_user_log` VALUES ('2', '2', '123123123', '122', '2015-10-26 10:27:28', '192.168.1.1', '未分配或者内网IP,,,', 'methodName1', 'model_name1');
INSERT INTO `tbl_user_log` VALUES ('3', '1', '123123123', '19', '2015-10-26 10:31:04', 'ewrwe', '未分配或者内网IP,,,', 'methodName', 'model_name');
INSERT INTO `tbl_user_log` VALUES ('4', '2', '123123123', '122', '2015-10-26 12:18:24', '172.16.1.48', 'null,null,null,null', 'methodName1', 'model_name1');
INSERT INTO `tbl_user_log` VALUES ('5', '2', '123123123', '122', '2015-10-26 12:19:43', '172.16.1.48', '未分配或者内网IP,,,', 'methodName1', 'model_name1');
INSERT INTO `tbl_user_log` VALUES ('6', '2', '123123123', '122', '2015-10-26 12:19:49', '172.16.1.48', '未分配或者内网IP,,,', 'methodName1', 'model_name1');
INSERT INTO `tbl_user_log` VALUES ('7', '2', '123123123', '19', '2015-10-27 12:02:04', '172.16.1.48', '未分配或者内网IP,,,', 'methodName', 'model_name');
INSERT INTO `tbl_user_log` VALUES ('8', '2', '123123123', '19', '2015-10-27 12:02:04', '172.16.1.48', '未分配或者内网IP,,,', 'methodName', 'model_name');
INSERT INTO `tbl_user_log` VALUES ('9', '2', '123123123', '19', '2015-10-27 12:02:05', '172.16.1.48', '未分配或者内网IP,,,', 'methodName', 'model_name');
INSERT INTO `tbl_user_log` VALUES ('10', '2', '123123123', '19', '2015-10-27 12:02:35', '172.16.1.48', '未分配或者内网IP,,,', 'methodName', 'model_name');
INSERT INTO `tbl_user_log` VALUES ('11', '2', '123123123', '19', '2015-10-27 12:02:35', '172.16.1.48', '未分配或者内网IP,,,', 'methodName', 'model_name');
INSERT INTO `tbl_user_log` VALUES ('12', '2', '123123123', '19', '2015-10-27 12:05:52', '172.16.1.48', '未分配或者内网IP,,,', 'methodName', 'model_name');
INSERT INTO `tbl_user_log` VALUES ('13', '2', '123123123', '19', '2015-10-27 12:15:04', '172.16.1.48', '未分配或者内网IP,,,', 'methodName', 'model_name');
INSERT INTO `tbl_user_log` VALUES ('14', '2', '123123123', '19', '2015-10-27 12:15:16', '172.16.1.48', '未分配或者内网IP,,,', 'methodName', 'model_name');
INSERT INTO `tbl_user_log` VALUES ('15', '2', '123123123', '19', '2015-10-27 12:15:45', '172.16.1.48', '未分配或者内网IP,,,', 'methodName', 'model_name');
INSERT INTO `tbl_user_log` VALUES ('16', '2', '123123123', '19', '2015-10-27 15:09:24', '172.16.1.48', '未分配或者内网IP,,,', 'methodName', 'model_name');
