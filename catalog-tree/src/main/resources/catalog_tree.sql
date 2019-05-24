/*
 Navicat MySQL Data Transfer

 Source Server         : java-test
 Source Server Type    : MySQL
 Source Server Version : 50640
 Source Host           : localhost:3306
 Source Schema         : java-test

 Target Server Type    : MySQL
 Target Server Version : 50640
 File Encoding         : 65001

 Date: 23/05/2019 16:52:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for catalog_tree
-- ----------------------------
DROP TABLE IF EXISTS `catalog_tree`;
CREATE TABLE `catalog_tree`  (
  `tier_id` int(11) NOT NULL AUTO_INCREMENT,
  `catalog_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `parent_id` int(11) NULL DEFAULT NULL,
  `level` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`tier_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of catalog_tree
-- ----------------------------
INSERT INTO `catalog_tree` VALUES (1, '北京市', 0, 1);
INSERT INTO `catalog_tree` VALUES (2, '青岛市', 0, 1);
INSERT INTO `catalog_tree` VALUES (3, '朝阳区', 1, 2);
INSERT INTO `catalog_tree` VALUES (4, '海淀区', 1, 2);
INSERT INTO `catalog_tree` VALUES (5, '西二旗南街', 3, 3);
INSERT INTO `catalog_tree` VALUES (6, '欧冠农大南路', 3, 3);
INSERT INTO `catalog_tree` VALUES (7, '天宫院', 3, 3);
INSERT INTO `catalog_tree` VALUES (8, '四号院', 5, 4);
INSERT INTO `catalog_tree` VALUES (9, '老祝院', 5, 4);
INSERT INTO `catalog_tree` VALUES (10, '三号大楼', 8, 5);
INSERT INTO `catalog_tree` VALUES (11, '四号大楼', 8, 5);
INSERT INTO `catalog_tree` VALUES (12, '七号楼', 9, 5);
INSERT INTO `catalog_tree` VALUES (13, '八号楼', 9, 5);
INSERT INTO `catalog_tree` VALUES (14, '九号楼', 9, 5);
INSERT INTO `catalog_tree` VALUES (15, '黄岛区', 2, 2);
INSERT INTO `catalog_tree` VALUES (16, '崂山区', 2, 2);
INSERT INTO `catalog_tree` VALUES (17, '家佳源', 15, 3);
INSERT INTO `catalog_tree` VALUES (18, '海外家园', 15, 3);
INSERT INTO `catalog_tree` VALUES (19, '天津市', 0, 1);
INSERT INTO `catalog_tree` VALUES (20, '河东区', 19, 2);

SET FOREIGN_KEY_CHECKS = 1;
