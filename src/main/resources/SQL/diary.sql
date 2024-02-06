/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50743
 Source Host           : localhost:3306
 Source Schema         : diary

 Target Server Type    : MySQL
 Target Server Version : 50743
 File Encoding         : 65001

 Date: 23/01/2024 00:57:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for text
-- ----------------------------
DROP TABLE IF EXISTS `text`;
CREATE TABLE `text`  (
  `textID` int(11) NOT NULL AUTO_INCREMENT,
  `createDate` datetime(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `autherID` int(11) NOT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`textID`) USING BTREE,
  INDEX `auther`(`autherID`) USING BTREE,
  CONSTRAINT `auther` FOREIGN KEY (`autherID`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 57 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of text
-- ----------------------------
INSERT INTO `text` VALUES (2, '2024-01-22 17:25:44', 1, 'dreimrie', 'dcece');
INSERT INTO `text` VALUES (3, '2024-01-22 17:25:44', 2, '标题二', '这是与标题二相关的100字文字。');
INSERT INTO `text` VALUES (4, '2024-01-22 17:25:44', 3, '标题三', '这是与标题三相关的100字文字。');
INSERT INTO `text` VALUES (5, '2024-01-22 17:25:44', 4, '标题四', '这是与标题四相关的100字文字。');
INSERT INTO `text` VALUES (6, '2024-01-22 17:25:44', 5, '标题五', '这是与标题五相关的100字文字。');
INSERT INTO `text` VALUES (8, '2024-01-22 17:25:44', 2, '标题七', '这是与标题七相关的100字文字。');
INSERT INTO `text` VALUES (9, '2024-01-22 17:25:44', 3, '标题八', '这是与标题八相关的100字文字。');
INSERT INTO `text` VALUES (10, '2024-01-22 17:25:44', 4, '标题九', '这是与标题九相关的100字文字。');
INSERT INTO `text` VALUES (11, '2024-01-22 17:25:44', 5, '标题十', '这是与标题十相关的100字文字。');
INSERT INTO `text` VALUES (13, '2024-01-22 17:25:44', 2, '标题十二', '这是与标题十二相关的100字文字。');
INSERT INTO `text` VALUES (14, '2024-01-22 17:25:44', 3, '标题十三', '这是与标题十三相关的100字文字。');
INSERT INTO `text` VALUES (15, '2024-01-22 17:25:44', 4, '标题十四', '这是与标题十四相关的100字文字。');
INSERT INTO `text` VALUES (16, '2024-01-22 17:25:44', 5, '标题十五', '这是与标题十五相关的100字文字。');
INSERT INTO `text` VALUES (18, '2024-01-22 17:25:44', 2, '标题十七', '这是与标题十七相关的100字文字。');
INSERT INTO `text` VALUES (19, '2024-01-22 17:25:44', 3, '标题十八', '这是与标题十八相关的100字文字。');
INSERT INTO `text` VALUES (20, '2024-01-22 17:25:44', 4, '标题十九', '这是与标题十九相关的100字文字。');
INSERT INTO `text` VALUES (21, '2024-01-22 17:25:44', 5, '标题二十', '这是与标题二十相关的100字文字。');
INSERT INTO `text` VALUES (23, '2024-01-22 17:25:44', 2, '标题二十二', '这是与标题二十二相关的100字文字。');
INSERT INTO `text` VALUES (24, '2024-01-22 17:25:44', 3, '标题二十三', '这是与标题二十三相关的100字文字。');
INSERT INTO `text` VALUES (25, '2024-01-22 17:25:44', 4, '标题二十四', '这是与标题二十四相关的100字文字。');
INSERT INTO `text` VALUES (26, '2024-01-22 17:25:44', 5, '标题二十五', '这是与标题二十五相关的100字文字。');
INSERT INTO `text` VALUES (28, '2024-01-22 17:25:44', 2, '标题二十七', '这是与标题二十七相关的100字文字。');
INSERT INTO `text` VALUES (29, '2024-01-22 17:25:44', 3, '标题二十八', '这是与标题二十八相关的100字文字。');
INSERT INTO `text` VALUES (30, '2024-01-22 17:25:44', 4, '标题二十九', '这是与标题二十九相关的100字文字。');
INSERT INTO `text` VALUES (31, '2024-01-22 17:25:44', 5, '标题三十', '这是与标题三十相关的100字文字。');
INSERT INTO `text` VALUES (33, '2024-01-22 17:25:44', 2, '标题三十二', '这是与标题三十二相关的100字文字。');
INSERT INTO `text` VALUES (34, '2024-01-22 17:25:44', 3, '标题三十三', '这是与标题三十三相关的100字文字。');
INSERT INTO `text` VALUES (35, '2024-01-22 17:25:44', 4, '标题三十四', '这是与标题三十四相关的100字文字。');
INSERT INTO `text` VALUES (36, '2024-01-22 17:25:44', 5, '标题三十五', '这是与标题三十五相关的100字文字。');
INSERT INTO `text` VALUES (38, '2024-01-22 17:25:44', 2, '标题三十七', '这是与标题三十七相关的100字文字。');
INSERT INTO `text` VALUES (39, '2024-01-22 17:25:44', 3, '标题三十八', '这是与标题三十八相关的100字文字。');
INSERT INTO `text` VALUES (40, '2024-01-22 17:25:44', 4, '标题三十九', '这是与标题三十九相关的100字文字。');
INSERT INTO `text` VALUES (41, '2024-01-22 17:25:44', 5, '标题四十', '这是与标题四十相关的100字文字。');
INSERT INTO `text` VALUES (43, '2024-01-22 17:25:44', 2, '标题四十二', '这是与标题四十二相关的100字文字。');
INSERT INTO `text` VALUES (44, '2024-01-22 17:25:44', 3, '标题四十三', '这是与标题四十三相关的100字文字。');
INSERT INTO `text` VALUES (45, '2024-01-22 17:25:44', 4, '标题四十四', '这是与标题四十四相关的100字文字。');
INSERT INTO `text` VALUES (46, '2024-01-22 17:25:44', 5, '标题四十五', '这是与标题四十五相关的100字文字。');
INSERT INTO `text` VALUES (50, '2024-01-22 23:35:33', 1, '修改标题', '<html dir=\"ltr\"><head></head><body contenteditable=\"true\"><p><font face=\"Segoe UI\">修改内容</font></p></body></html>');
INSERT INTO `text` VALUES (52, '2024-01-22 23:44:58', 1, '这个是修改后题', '<html dir=\"ltr\"><head></head><body contenteditable=\"true\"><p><font face=\"Segoe UI\">vrewcwwefvcwecwece</font></p></body></html>');
INSERT INTO `text` VALUES (55, '2024-01-23 00:15:13', 1, 'jrincirnceri', '<html dir=\"ltr\"><head></head><body contenteditable=\"true\"><p><font face=\"Segoe UI\">frencferinfcerimcre</font></p></body></html>');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `password` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `email` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'linco', '12345', '12345@linco.com');
INSERT INTO `user` VALUES (2, 'user1', 'pass1', 'user1@example.com');
INSERT INTO `user` VALUES (3, 'user2', 'pass2', 'user2@example.com');
INSERT INTO `user` VALUES (4, 'user3', 'pass3', 'user3@example.com');
INSERT INTO `user` VALUES (5, 'user4', 'pass4', 'user4@example.com');
INSERT INTO `user` VALUES (6, 'user5', 'pass5', 'user5@example.com');
INSERT INTO `user` VALUES (7, 'user123', '123456', '123456@qq.com');

SET FOREIGN_KEY_CHECKS = 1;
