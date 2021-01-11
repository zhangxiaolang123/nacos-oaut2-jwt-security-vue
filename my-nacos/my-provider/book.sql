/*
 Navicat Premium Data Transfer

 Source Server         : changgou
 Source Server Type    : MySQL
 Source Server Version : 50714
 Source Host           : localhost:3306
 Source Schema         : changgou_goods

 Target Server Type    : MySQL
 Target Server Version : 50714
 File Encoding         : 65001

 Date: 11/01/2021 22:12:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` int(255) NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 142 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (121, 'zhangxl1', 123, 18, '张晓朗1', '鲁迅先生1r2');
INSERT INTO `book` VALUES (122, 'zxl', 232, 18, 'zxzl', '鲁迅先生111');
INSERT INTO `book` VALUES (123, NULL, NULL, NULL, '张晓朗', '西游记');
INSERT INTO `book` VALUES (124, NULL, NULL, NULL, '是发生的1', '范德萨');
INSERT INTO `book` VALUES (132, NULL, NULL, NULL, '1231', '1让人');
INSERT INTO `book` VALUES (133, NULL, NULL, NULL, '12312', '额外11');
INSERT INTO `book` VALUES (134, NULL, NULL, NULL, '123123', '双方的');
INSERT INTO `book` VALUES (135, NULL, NULL, NULL, '12312123', '2423');
INSERT INTO `book` VALUES (136, NULL, NULL, NULL, '12312312', '2412');
INSERT INTO `book` VALUES (137, NULL, NULL, NULL, '地方2312312', '12312');
INSERT INTO `book` VALUES (138, NULL, NULL, NULL, '123123', '的萨芬');
INSERT INTO `book` VALUES (139, NULL, NULL, NULL, '地方231231211', '1231211');
INSERT INTO `book` VALUES (140, NULL, NULL, NULL, '12312311', '的111萨芬11');
INSERT INTO `book` VALUES (141, NULL, NULL, NULL, '123123', '2321佛山');

SET FOREIGN_KEY_CHECKS = 1;
