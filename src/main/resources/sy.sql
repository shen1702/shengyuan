/*
Navicat MySQL Data Transfer

Source Server         : MySql
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : sy

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-06-03 20:48:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `password` varchar(20) NOT NULL COMMENT '密码',
  `name` varchar(20) NOT NULL COMMENT '姓名',
  `sex` char(2) DEFAULT NULL COMMENT '电话',
  `mobilephone` varchar(15) DEFAULT NULL COMMENT '地址',
  `email` varchar(50) NOT NULL COMMENT '手机',
  `address` varchar(100) DEFAULT NULL COMMENT '邮编',
  `status` int(1) DEFAULT '1' COMMENT 'status',
  `createtime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('16', 'admin', 'admin', 'admin', '男', '133333333', 'admin@admin.com', '111', '1', '2018-06-02 18:02:44');
