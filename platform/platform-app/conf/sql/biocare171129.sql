/*
Navicat MySQL Data Transfer

Source Server         : localhost3307
Source Server Version : 50556
Source Host           : localhost:3307
Source Database       : biocare

Target Server Type    : MYSQL
Target Server Version : 50556
File Encoding         : 65001

Date: 2017-11-29 17:01:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for template_table
-- ----------------------------
DROP TABLE IF EXISTS `template_table`;
CREATE TABLE `template_table` (
  `template_id` varchar(255) NOT NULL COMMENT 'ID 生成器会默认将注释的空格前的内容作为字段显示标题',
  `template_string` varchar(255) DEFAULT NULL COMMENT '模板-字符串 ',
  `template_int` int(10) DEFAULT NULL COMMENT '模板-数字 0男1女3其他',
  `template_double` decimal(10,5) DEFAULT NULL COMMENT '模板-小数 ',
  `template_date` datetime DEFAULT NULL COMMENT '模板-时间 ',
  PRIMARY KEY (`template_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of template_table
-- ----------------------------
INSERT INTO `template_table` VALUES ('8d36e044-955d-420171129152725800', '测试新增', '10000', '2.50000', '2017-10-31 00:00:00');
INSERT INTO `template_table` VALUES ('d0fd0ef6-ea8d-420171129152702815', '测试新增', '10000', '2.50000', '2017-11-29 00:00:00');

-- ----------------------------
-- Table structure for t_banner_info
-- ----------------------------
DROP TABLE IF EXISTS `t_banner_info`;
CREATE TABLE `t_banner_info` (
  `banner_id` varchar(255) NOT NULL,
  `system_id` varchar(255) DEFAULT NULL,
  `pic_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`banner_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_banner_info
-- ----------------------------
INSERT INTO `t_banner_info` VALUES ('1', '1', '1');
INSERT INTO `t_banner_info` VALUES ('2', '2', '2');
