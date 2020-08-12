/*
Navicat MySQL Data Transfer

Source Server         : SSS
Source Server Version : 50714
Source Host           : localhost:3306
Source Database       : sss

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2018-12-27 22:54:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `course`
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `course_id` char(6) NOT NULL,
  `course_name` varchar(40) NOT NULL,
  `teacher` varchar(40) NOT NULL,
  `point` int(4) NOT NULL,
  `time_1` char(2) NOT NULL,
  `time_2` char(2) NOT NULL,
  `location` varchar(40) NOT NULL,
  `limited` int(4) NOT NULL,
  PRIMARY KEY (`course_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('01', '游泳', '涂逸朗', '2', '十点', '十点', '家里', '1');
INSERT INTO `course` VALUES ('02', '爬山', '涂逸朗1', '3', '两点', '两点', '你家里', '2');

-- ----------------------------
-- Table structure for `elective`
-- ----------------------------
DROP TABLE IF EXISTS `elective`;
CREATE TABLE `elective` (
  `username` varchar(20) NOT NULL,
  `course_id` char(6) NOT NULL,
  KEY `course_id` (`course_id`),
  KEY `user` (`username`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of elective
-- ----------------------------
INSERT INTO `elective` VALUES ('aa', '02');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `realname` varchar(20) NOT NULL,
  `role` char(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('aa', '123', 'tu', '0');
INSERT INTO `user` VALUES ('ww', '123', 'yi', '1');
