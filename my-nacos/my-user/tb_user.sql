/*
 Navicat Premium Data Transfer

 Source Server         : changgou
 Source Server Type    : MySQL
 Source Server Version : 50714
 Source Host           : localhost:3306
 Source Schema         : changgou_user

 Target Server Type    : MySQL
 Target Server Version : 50714
 File Encoding         : 65001

 Date: 11/01/2021 22:14:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码，加密存储',
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '注册手机号',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '注册邮箱',
  `created` datetime(0) NOT NULL COMMENT '创建时间',
  `updated` datetime(0) NOT NULL COMMENT '修改时间',
  `source_type` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '会员来源：1:PC，2：H5，3：Android，4：IOS',
  `nick_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `status` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '使用状态（1正常 0非正常）',
  `head_pic` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像地址',
  `qq` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'QQ号码',
  `is_mobile_check` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '手机是否验证 （0否  1是）',
  `is_email_check` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '邮箱是否检测（0否  1是）',
  `sex` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT '性别，1男，0女',
  `user_level` int(11) NULL DEFAULT NULL COMMENT '会员等级',
  `points` int(11) NULL DEFAULT NULL COMMENT '积分',
  `experience_value` int(11) NULL DEFAULT NULL COMMENT '经验值',
  `birthday` datetime(0) NULL DEFAULT NULL COMMENT '出生年月日',
  `last_login_time` datetime(0) NULL DEFAULT NULL COMMENT '最后登录时间',
  `author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '作者',
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('13904211939', '123123', '13904211939', NULL, '2019-03-06 15:40:47', '2019-03-06 15:40:47', NULL, NULL, NULL, '1', NULL, NULL, '1', '0', NULL, NULL, 0, NULL, NULL, NULL, '张晓朗', 1);
INSERT INTO `tb_user` VALUES ('17701265258', '111222', '17701265258', NULL, '2019-03-06 15:22:32', '2019-03-06 15:22:32', NULL, NULL, NULL, '1', NULL, NULL, '1', '0', NULL, NULL, 0, NULL, NULL, NULL, '张晓朗1', 2);
INSERT INTO `tb_user` VALUES ('changgou', '$2a$10$njSeoI2fhKLb29QUJ1i0g.WCsDUZT/tSEM1fZEFxdjN30iPyaPU5.', '13670081376', NULL, '2019-05-18 10:02:39', '2019-05-18 10:02:42', NULL, NULL, NULL, '1', NULL, NULL, '1', '1', '1', NULL, 0, NULL, NULL, NULL, 'zxl', 3);
INSERT INTO `tb_user` VALUES ('chuanzhi777', 'f1c1592588411002af340cbaedd6fc33', '17701265258', NULL, '2018-08-07 21:19:08', '2018-08-07 21:19:08', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, '123', 4);
INSERT INTO `tb_user` VALUES ('honghaier', 'f14029217ff5e7a50cdc7e70f686cf29', '13919991999', NULL, '2017-10-08 11:23:02', '2017-10-08 11:23:02', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, 'er\'w', 5);
INSERT INTO `tb_user` VALUES ('leileia', '$2a$10$MDtVJwxGs09/9XNifJxeGOIlYFYuu9MAU3nXfz8AdjxioCu.zkR6q', '13677788899', '717777777@qq.com', '2019-05-18 03:38:15', '2019-05-18 03:38:15', NULL, NULL, NULL, NULL, NULL, NULL, '0', '0', '1', NULL, 0, NULL, NULL, NULL, '22', 6);
INSERT INTO `tb_user` VALUES ('lijialong', '4297f44b13955235245b2497399d7a93', '13260006290', NULL, '2017-08-20 12:23:37', '2017-08-20 12:23:37', NULL, NULL, NULL, '1', NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, 'f', 7);
INSERT INTO `tb_user` VALUES ('lisi', '8fbaad286e993d37b34b41749894b4a7', '13401341444', NULL, '2017-08-20 11:08:29', '2017-08-20 11:08:29', NULL, NULL, NULL, '1', NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, 's', 8);
INSERT INTO `tb_user` VALUES ('litianwang', 'b0baee9d279d34fa1dfd71aadb908c3f', '17338118923', NULL, '2017-10-08 12:28:25', '2017-10-08 12:28:25', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, 'fsdf', 9);
INSERT INTO `tb_user` VALUES ('nezha', '1a100d2c0dab19c4430e7d73762b3423', '17338118923', NULL, '2017-10-08 12:23:27', '2017-10-08 12:23:27', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, 'fsdf1', 10);
INSERT INTO `tb_user` VALUES ('niumowang', '4297f44b13955235245b2497399d7a93', '13900112222', NULL, '2017-10-07 23:46:53', '2017-10-07 23:46:53', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, 'fff', 11);
INSERT INTO `tb_user` VALUES ('shaheshang', '96e79218965eb72c92a549dd5a330112', '13900112222', NULL, '2017-08-19 22:37:44', '2017-08-19 22:37:44', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, '3r', 12);
INSERT INTO `tb_user` VALUES ('sunwukong', '123123', '1112221111', NULL, '2017-08-19 20:50:21', '2017-08-19 20:50:21', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, 'hh', 13);
INSERT INTO `tb_user` VALUES ('szitheima', '$2a$10$FpSl6n6x7pl/AKu0LEcZDOlrg1Nt7sKtpgXKYUOSfPZFXV3.j4mJq', '13670000000', 'szitheima@itcast.cn', '2019-05-18 23:05:43', '2019-05-18 23:05:43', '1', 'hello', NULL, NULL, NULL, NULL, '0', '0', '1', NULL, 70, NULL, NULL, NULL, 'fd', 14);
INSERT INTO `tb_user` VALUES ('taiba', '97d84aa49109e72a54980e79802844be', '17338118923', NULL, '2017-10-08 12:34:53', '2017-10-08 12:34:53', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, 'sh', 15);
INSERT INTO `tb_user` VALUES ('tangseng', '4297f44b13955235245b2497399d7a93', '13901223232', NULL, '2017-10-07 23:07:42', '2017-10-07 23:07:42', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, '3432', 16);
INSERT INTO `tb_user` VALUES ('tieshanxian', 'f14029217ff5e7a50cdc7e70f686cf29', '13999999999', NULL, '2017-10-08 12:10:26', '2017-10-08 12:10:26', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, '234', 17);
INSERT INTO `tb_user` VALUES ('wangwu', '$2a$10$FpSl6n6x7pl/AKu0LEcZDOlrg1Nt7sKtpgXKYUOSfPZFXV3.j4mJq', '13601566766', NULL, '2017-08-20 11:09:26', '2017-08-20 11:09:26', NULL, NULL, NULL, '1', NULL, NULL, NULL, NULL, NULL, NULL, 31, NULL, NULL, NULL, 'fd', 18);
INSERT INTO `tb_user` VALUES ('xiaogao', '967856e8dd46d819c09d4999e64b9eed', '13900002222', NULL, '2018-08-08 11:56:41', '2018-08-08 11:56:41', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, '234', 19);
INSERT INTO `tb_user` VALUES ('xiaoxiong', '4297f44b13955235245b2497399d7a93', '13900009999', NULL, '2018-08-08 12:30:12', '2018-08-08 12:30:12', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, 'sd', 20);
INSERT INTO `tb_user` VALUES ('zhangsan', '$2a$10$KMmF1Hmh4g1AEeyD2Z6IyeEGvlzrkwhimdMJ8XSro4eCeLG58tq.O', '17701265258', NULL, '2017-08-19 23:44:45', '2017-08-19 23:44:45', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, '234', 21);

SET FOREIGN_KEY_CHECKS = 1;
