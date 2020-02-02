/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50644
 Source Host           : localhost:3306
 Source Schema         : sccadmin

 Target Server Type    : MySQL
 Target Server Version : 50644
 File Encoding         : 65001

 Date: 02/02/2020 16:28:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for activity_d
-- ----------------------------
DROP TABLE IF EXISTS `activity_d`;
CREATE TABLE `activity_d`  (
  `day_id` int(11) NOT NULL,
  `am_one` int(6) NOT NULL DEFAULT 0,
  `am_two` int(6) NOT NULL DEFAULT 0,
  `am_three` int(6) NOT NULL DEFAULT 0,
  `am_four` int(6) NOT NULL DEFAULT 0,
  `am_five` int(6) NOT NULL DEFAULT 0,
  `am_six` int(6) NOT NULL DEFAULT 0,
  `am_seven` int(6) NOT NULL DEFAULT 0,
  `am_eight` int(6) NOT NULL DEFAULT 0,
  `am_nine` int(6) NOT NULL DEFAULT 0,
  `am_ten` int(6) NOT NULL DEFAULT 0,
  `am_eleven` int(6) NOT NULL DEFAULT 0,
  `am_twelve` int(6) NOT NULL DEFAULT 0,
  `pm_one` int(6) NOT NULL DEFAULT 0,
  `pm_two` int(6) NOT NULL DEFAULT 0,
  `pm_three` int(6) NOT NULL DEFAULT 0,
  `pm_four` int(6) NOT NULL DEFAULT 0,
  `pm_five` int(6) NOT NULL DEFAULT 0,
  `pm_six` int(6) NOT NULL DEFAULT 0,
  `pm_seven` int(6) NOT NULL DEFAULT 0,
  `pm_eight` int(6) NOT NULL DEFAULT 0,
  `pm_nine` int(6) NOT NULL DEFAULT 0,
  `pm_ten` int(6) NOT NULL DEFAULT 0,
  `pm_eleven` int(6) NOT NULL DEFAULT 0,
  `pm_twelve` int(6) NOT NULL DEFAULT 0,
  `total_day` int(7) NOT NULL,
  PRIMARY KEY (`day_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '时间普日分配比列' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for activity_m
-- ----------------------------
DROP TABLE IF EXISTS `activity_m`;
CREATE TABLE `activity_m`  (
  `month_id` int(11) NOT NULL,
  `january` int(6) NOT NULL DEFAULT 0,
  `february` int(6) NOT NULL DEFAULT 0,
  `march` int(6) NOT NULL DEFAULT 0,
  `april` int(6) NOT NULL DEFAULT 0,
  `may` int(6) NOT NULL DEFAULT 0,
  `june` int(6) NOT NULL DEFAULT 0,
  `july` int(6) NOT NULL DEFAULT 0,
  `august` int(6) NOT NULL DEFAULT 0,
  `september` int(6) NOT NULL DEFAULT 0,
  `october` int(6) NOT NULL DEFAULT 0,
  `november` int(6) NOT NULL DEFAULT 0,
  `december` int(6) NOT NULL DEFAULT 0,
  `total_month` int(8) NOT NULL,
  PRIMARY KEY (`month_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for activity_w
-- ----------------------------
DROP TABLE IF EXISTS `activity_w`;
CREATE TABLE `activity_w`  (
  `week_id` int(11) NOT NULL,
  `monday` int(6) NOT NULL DEFAULT 0,
  `tuesday` int(6) NOT NULL DEFAULT 0,
  `wednesday` int(6) NOT NULL DEFAULT 0,
  `thursday` int(6) NOT NULL DEFAULT 0,
  `friday` int(6) NOT NULL DEFAULT 0,
  `saturday` int(6) NOT NULL DEFAULT 0,
  `sunday` int(6) NOT NULL DEFAULT 0,
  `total_week` int(8) NOT NULL,
  PRIMARY KEY (`week_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for adminuser
-- ----------------------------
DROP TABLE IF EXISTS `adminuser`;
CREATE TABLE `adminuser`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `salt` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '盐',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `status` int(1) NULL DEFAULT NULL COMMENT '账号状态: 0: 未激活, 1: 已激活. ',
  `last_login_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后登录时间',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `modify_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `active_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '注册激活码',
  `dept_id` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门ID',
  `realname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `mobilephone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `workphone` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工作电话',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for agriculture_machinery
-- ----------------------------
DROP TABLE IF EXISTS `agriculture_machinery`;
CREATE TABLE `agriculture_machinery`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `year` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '年份',
  `county_id` char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '区县编码',
  `scc_code` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'scc编码',
  `source_descrip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'scc描述',
  `fuel_type` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '燃料类型',
  `holdings` int(10) NULL DEFAULT NULL COMMENT '保有量',
  `fuel_usage` double(18, 10) NULL DEFAULT NULL COMMENT '单位机动车燃油消耗量',
  `fuel_annual_usage` double(18, 10) NULL DEFAULT NULL COMMENT '燃料年使用量',
  `annal_average_milage` double(18, 10) NULL DEFAULT NULL COMMENT '年平均行驶里程',
  `fuel_sulfur_content` double(18, 10) NULL DEFAULT NULL COMMENT '含硫率',
  `pm10_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'pm10排放量',
  `pm25_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'pm25排放量',
  `vocs_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'voc排放量',
  `co_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'co排放量',
  `nox_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'nox排放量',
  `so2_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'so2排放量',
  `bc_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'bc排放量',
  `oc_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'oc排放量',
  `nh3_emission` double(18, 10) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `year`(`year`, `county_id`, `scc_code`) USING BTREE,
  INDEX `countyid_agriculture`(`county_id`) USING BTREE,
  INDEX `scccode_agriculture`(`scc_code`) USING BTREE,
  CONSTRAINT `countyid_agriculture` FOREIGN KEY (`county_id`) REFERENCES `county` (`COUNTY_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `scccode_agriculture` FOREIGN KEY (`scc_code`) REFERENCES `scc` (`scc`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for airplane
-- ----------------------------
DROP TABLE IF EXISTS `airplane`;
CREATE TABLE `airplane`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `year` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '年份',
  `county_id` char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '区县编码',
  `scc_code` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'scc编码',
  `source_descrip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'scc描述',
  `fuel_type` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '燃料类型',
  `activity_level` double(18, 10) NULL DEFAULT NULL COMMENT '活动水平',
  `fuel_annual_usage` double(18, 10) NULL DEFAULT NULL COMMENT '燃料年使用量',
  `fuel_sulfur_usage` double(18, 10) NULL DEFAULT NULL COMMENT '燃料含硫率',
  `pm10_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'pm10排放量',
  `pm25_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'pm25排放量',
  `co_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'co排放量',
  `so2_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'so2排放量',
  `nox_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'nox排放量',
  `vocs_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'voc排放量',
  `bc_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'bc排放量',
  `oc_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'oc排放量',
  `nh3_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'nh3排放量',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `year`(`year`, `county_id`, `scc_code`) USING BTREE,
  INDEX `scccode_airplane`(`scc_code`) USING BTREE,
  INDEX `countyid_airplane`(`county_id`) USING BTREE,
  CONSTRAINT `airplane_ibfk_1` FOREIGN KEY (`county_id`) REFERENCES `county` (`COUNTY_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `scccode_airplane` FOREIGN KEY (`scc_code`) REFERENCES `scc` (`scc`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for base_soil
-- ----------------------------
DROP TABLE IF EXISTS `base_soil`;
CREATE TABLE `base_soil`  (
  `id` int(14) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `year` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '年份',
  `county_id` char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '区县编码',
  `scccode` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'Scc编码',
  `source_descrip` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述信息',
  `cultivate_area` double(20, 10) NULL DEFAULT NULL COMMENT '耕地面积',
  `pm10_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'Pm10排放量',
  `pm25_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'PM25排放量',
  `voc_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'VOC排放量',
  `nh3_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'NH3排放量',
  `so2_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'SO2排放量',
  `co_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'CO排放量',
  `oc_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'OC排放量',
  `bc_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'BC排放量',
  `nox_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'NOX排放量',
  `flagd` tinyint(4) NULL DEFAULT NULL COMMENT '排放因子标志位',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `year`(`year`, `county_id`, `scccode`) USING BTREE,
  INDEX `county_id`(`county_id`) USING BTREE,
  INDEX `scccode`(`scccode`) USING BTREE,
  CONSTRAINT `base_soil_ibfk_1` FOREIGN KEY (`county_id`) REFERENCES `county` (`COUNTY_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `base_soil_ibfk_2` FOREIGN KEY (`scccode`) REFERENCES `scc` (`scc`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 33 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '农牧源-土壤本底源' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for biomass_boiler
-- ----------------------------
DROP TABLE IF EXISTS `biomass_boiler`;
CREATE TABLE `biomass_boiler`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `scc_code` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT 'scc编码',
  `com_id` int(14) NOT NULL COMMENT '企业编号',
  `source_descrip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'scc描述',
  `boiler_no` int(10) NULL DEFAULT NULL COMMENT '锅炉编号',
  `fuel_type` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '燃料类型',
  `fuel_consumption` double(18, 10) NULL DEFAULT NULL COMMENT '燃料使用量',
  `dust_remove_tech` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '除尘措施',
  `pm10_remove_ratio` double(18, 10) NULL DEFAULT NULL COMMENT 'pm10去除率',
  `pm25_remove_ratio` double(18, 10) NULL DEFAULT NULL COMMENT 'pm25去除率',
  `DESULPHUR_REMOVE_TECH` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '除硫措施',
  `SO2_REMOVE_RATIO` double(18, 10) NULL DEFAULT NULL COMMENT 'so2去除率',
  `DENITRIFIC_REMOVE_TECH` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '脱硝技术',
  `NOX_REMOVE_RATIO` double(18, 10) NULL DEFAULT NULL COMMENT 'nox去除率',
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `year` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '年份',
  `pm10_emission` double(18, 10) NULL DEFAULT 0.0000000000,
  `pm25_emission` double(18, 10) NULL DEFAULT 0.0000000000,
  `co_emission` double(18, 10) NULL DEFAULT 0.0000000000,
  `voc_emission` double(18, 10) NULL DEFAULT 0.0000000000,
  `pm_emission` double(18, 10) NULL DEFAULT 0.0000000000,
  `so2_emission` double(18, 10) NULL DEFAULT 0.0000000000,
  `nox_emission` double(18, 10) NULL DEFAULT 0.0000000000,
  `nh3_emission` double(18, 10) NULL DEFAULT 0.0000000000,
  `oc_emission` double(18, 10) NULL DEFAULT 0.0000000000,
  `bc_emission` double(18, 10) NULL DEFAULT 0.0000000000,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `com_id`(`com_id`, `boiler_no`, `year`) USING BTREE,
  INDEX `scc_code`(`scc_code`) USING BTREE,
  CONSTRAINT `biomass_boiler_ibfk_2` FOREIGN KEY (`scc_code`) REFERENCES `scc` (`scc`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `biomass_boiler_ibfk_4` FOREIGN KEY (`com_id`) REFERENCES `company` (`com_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for biomass_forest_grassland
-- ----------------------------
DROP TABLE IF EXISTS `biomass_forest_grassland`;
CREATE TABLE `biomass_forest_grassland`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `county_id` char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '区县编码',
  `scc_code` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'scc编码',
  `source_descrip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `VEGETATION_TYPES` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '植被类型',
  `fire_area` double(18, 10) NULL DEFAULT NULL COMMENT '火灾面积',
  `DRY_BIOMASS` double(18, 10) NULL DEFAULT NULL COMMENT '干生物量',
  `BURNING_RATIO` double(18, 10) NULL DEFAULT NULL COMMENT '燃烧率',
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `year` char(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '年份',
  `pm10_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'pm10排放量',
  `pm25_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'pm25排放量',
  `co_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'co排放量',
  `voc_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'voc排放量',
  `pm_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'pm排放量',
  `so2_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'so2排放量',
  `nox_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'nox排放量',
  `nh3_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'nh3排放量',
  `oc_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'oc排放量',
  `bc_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'bc排放量',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `county_id`(`county_id`, `scc_code`, `year`) USING BTREE,
  INDEX `county_id_forest`(`county_id`) USING BTREE,
  INDEX `scc_code_forest`(`scc_code`) USING BTREE,
  CONSTRAINT `county_id_forest` FOREIGN KEY (`county_id`) REFERENCES `county` (`COUNTY_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `scc_code_forest` FOREIGN KEY (`scc_code`) REFERENCES `scc` (`scc`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for biomass_stove
-- ----------------------------
DROP TABLE IF EXISTS `biomass_stove`;
CREATE TABLE `biomass_stove`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `year` char(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '年份',
  `county_id` char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '区县',
  `stove_type` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '炉灶类型',
  `CROP_TYPE` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '农作物种类',
  `CROP_YIELD` double(18, 10) NULL DEFAULT NULL COMMENT '农作物产量',
  `scc_code` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'scc编码',
  `source_descrip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `GRASS_VALLEY_RATIO` double(18, 10) NULL DEFAULT NULL COMMENT '草谷比',
  `BURNING_RATIO_stove` double(18, 10) NULL DEFAULT NULL COMMENT '户用燃烧比率',
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `pm10_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'pm10排放量',
  `pm25_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'pm25排放量',
  `co_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'co排放量',
  `voc_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'voc排放量',
  `pm_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'pm排放量',
  `so2_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'so2排放量',
  `nox_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'nox排放量',
  `nh3_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'nh3排放量',
  `oc_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'oc排放量',
  `bc_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'bc排放量',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `year`(`year`, `county_id`, `scc_code`) USING BTREE,
  INDEX `county_id_stove`(`county_id`) USING BTREE,
  INDEX `scc_code_stove`(`scc_code`) USING BTREE,
  CONSTRAINT `county_id_stove` FOREIGN KEY (`county_id`) REFERENCES `county` (`COUNTY_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `scc_code_stove` FOREIGN KEY (`scc_code`) REFERENCES `scc` (`scc`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for biomass_straw
-- ----------------------------
DROP TABLE IF EXISTS `biomass_straw`;
CREATE TABLE `biomass_straw`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `county_id` char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '区县编码',
  `scc_code` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'scc编码',
  `source_descrip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CROPS` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '农作物种类',
  `CROPS_OUTPUT` double(18, 10) NULL DEFAULT NULL COMMENT '农作物产量',
  `GRASS_VALLEY_RATIO` double(18, 10) NULL DEFAULT NULL COMMENT '谷草比',
  `OPEN_BURNING_RATIO` double(18, 10) NULL DEFAULT NULL COMMENT '露天焚烧比率',
  `BURNING_RATIO` double(18, 10) NULL DEFAULT NULL COMMENT '燃烧率',
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `year` char(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '年份',
  `pm10_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'pm10排放量',
  `pm25_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'pm25排放量',
  `co_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'co排放量',
  `voc_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'voc排放量',
  `pm_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'pm排放量',
  `so2_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'so2排放量',
  `nox_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'nox排放量',
  `nh3_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'nh3排放量',
  `oc_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'oc排放量',
  `bc_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'bc排放量',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `county_id`(`county_id`, `scc_code`, `year`) USING BTREE,
  INDEX `county_id_straw`(`county_id`) USING BTREE,
  INDEX `scc_code_straw`(`scc_code`) USING BTREE,
  CONSTRAINT `county_id_straw` FOREIGN KEY (`county_id`) REFERENCES `county` (`COUNTY_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `scc_code_straw` FOREIGN KEY (`scc_code`) REFERENCES `scc` (`scc`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for boiler
-- ----------------------------
DROP TABLE IF EXISTS `boiler`;
CREATE TABLE `boiler`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NK_NO` int(5) NOT NULL COMMENT '锅炉编号',
  `EXHUST_ID` int(11) NULL DEFAULT NULL COMMENT '对应烟囱',
  `version` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '锅炉设备型号',
  `FUNCTIO` char(2) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '锅炉用途',
  `MODEL` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '锅炉类型',
  `FUELTYPE` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '锅炉所用燃料类型',
  `TONS` double(20, 4) NOT NULL COMMENT '锅炉吨位',
  `COALASH` double(14, 8) NULL DEFAULT NULL COMMENT '燃煤灰分',
  `COALSULFUR` double(14, 8) NULL DEFAULT NULL COMMENT '燃煤硫分',
  `COMBUSTIONSYSTEM` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '燃烧方式',
  `FUEL_AUSAGE` double(18, 4) NOT NULL COMMENT '燃料年使用量',
  `FUEL_AUSAGEUNIT` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '燃料年使用量单位（自动生成）',
  `sulphurremove_id` int(10) NULL DEFAULT NULL COMMENT '脱硫方式',
  `dustremove_id` int(10) NULL DEFAULT NULL COMMENT '除尘方式',
  `nitreremove_id` int(10) NULL DEFAULT NULL COMMENT '脱硝方式',
  `feiqiti` double(25, 5) NULL DEFAULT NULL COMMENT '废气排放量（万立方米）、',
  `pm10` double(18, 5) NULL DEFAULT NULL,
  `pm25` double(18, 5) NULL DEFAULT NULL,
  `co` double(18, 5) NULL DEFAULT NULL,
  `voc` double(18, 5) NULL DEFAULT NULL,
  `pm` double(18, 5) NULL DEFAULT NULL,
  `so2` double(18, 5) NULL DEFAULT NULL,
  `nox` double(18, 5) NULL DEFAULT NULL,
  `nh3` double(18, 5) NULL DEFAULT NULL,
  `oc` double(18, 5) NULL DEFAULT NULL,
  `bc` double(18, 5) NULL DEFAULT NULL,
  `scc` char(10) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `machine_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '机组编号',
  `coal_volatilisation` double(5, 2) NULL DEFAULT NULL COMMENT '煤炭挥发分',
  `installed_capacity` double(15, 4) NULL DEFAULT NULL COMMENT '装机容量',
  `Jan_useamount` double(15, 4) NULL DEFAULT NULL COMMENT '燃料一月份使用量',
  `Feb_useamount` double(15, 4) NULL DEFAULT NULL COMMENT '燃料二月份使用量',
  `Mar_useamount` double(15, 4) NULL DEFAULT NULL COMMENT '燃料三月份使用量',
  `Apr_useamount` double(15, 4) NULL DEFAULT NULL COMMENT '燃料四月份使用量',
  `May_useamount` double(15, 4) NULL DEFAULT NULL COMMENT '燃料五月份使用量',
  `June_useamount` double(15, 4) NULL DEFAULT NULL COMMENT '燃料六月份使用量',
  `July_useamount` double(15, 4) NULL DEFAULT NULL COMMENT '燃料七月份使用量',
  `aug_useamount` double(15, 4) NULL DEFAULT NULL COMMENT '燃料八月份使用量',
  `sept_useamount` double(15, 4) NULL DEFAULT NULL COMMENT '燃料九月份使用量',
  `oct_use_amount` double(15, 4) NULL DEFAULT NULL COMMENT '燃料十月份使用量',
  `nov_useamount` double(15, 4) NULL DEFAULT NULL COMMENT '燃料十一月份使用量',
  `dec_useamount` double(15, 4) NULL DEFAULT NULL COMMENT '燃料十二月份使用量',
  `so2out` double(15, 5) NULL DEFAULT NULL COMMENT '二氧化硫排放量（吨）',
  `pmout` double(15, 5) NULL DEFAULT NULL COMMENT '烟粉尘排放量（吨）',
  `noxout` double(15, 5) NULL DEFAULT NULL COMMENT '氮氧化物排放量（吨）',
  PRIMARY KEY (`ID`) USING BTREE,
  INDEX `EXF_ID`(`EXHUST_ID`) USING BTREE,
  INDEX `boiler_temp_ibfk_3`(`dustremove_id`) USING BTREE,
  INDEX `boiler_temp_ibfk_4`(`sulphurremove_id`) USING BTREE,
  INDEX `boiler_temp_ibfk_5`(`nitreremove_id`) USING BTREE,
  CONSTRAINT `boiler_ibfk_2` FOREIGN KEY (`dustremove_id`) REFERENCES `dustremove` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `boiler_ibfk_4` FOREIGN KEY (`nitreremove_id`) REFERENCES `nitreremove` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `boiler_ibfk_5` FOREIGN KEY (`EXHUST_ID`) REFERENCES `exhaust` (`EXF_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `boiler_ibfk_6` FOREIGN KEY (`sulphurremove_id`) REFERENCES `sulphurremove` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3535 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = '固定燃烧源-锅炉表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for building_smear
-- ----------------------------
DROP TABLE IF EXISTS `building_smear`;
CREATE TABLE `building_smear`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `year` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '年份',
  `county_id` char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '区县',
  `paint_amount` double(20, 10) NULL DEFAULT NULL COMMENT '涂料使用量',
  `scccode` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '天津Scc编码',
  `pm10_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'Pm10排放量',
  `pm25_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'PM25排放量',
  `voc_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'VOC排放量',
  `nh3_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'NH3排放量',
  `so2_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'SO2排放量',
  `co_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'CO排放量',
  `oc_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'OC排放量',
  `bc_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'BC排放量',
  `nox_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'NOX排放量',
  `flagd` tinyint(4) NULL DEFAULT NULL COMMENT '排放因子标志位',
  `source_descrip` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述信息',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `year`(`year`, `county_id`, `scccode`) USING BTREE,
  INDEX `countyid`(`county_id`) USING BTREE,
  INDEX `scccode`(`scccode`) USING BTREE,
  CONSTRAINT `building_smear_ibfk_1` FOREIGN KEY (`county_id`) REFERENCES `county` (`COUNTY_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `building_smear_ibfk_2` FOREIGN KEY (`scccode`) REFERENCES `scc` (`scc`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for car_repair
-- ----------------------------
DROP TABLE IF EXISTS `car_repair`;
CREATE TABLE `car_repair`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `year` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '年份',
  `company_id` int(14) NULL DEFAULT NULL COMMENT '企业代码',
  `solvent_amount` double(20, 10) NULL DEFAULT NULL COMMENT '溶剂使用量',
  `scccode` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '天津Scc编码',
  `pm10_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'Pm10排放量',
  `pm25_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'PM25排放量',
  `voc_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'VOC排放量',
  `nh3_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'NH3排放量',
  `so2_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'so2_emission',
  `co_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'CO排放量',
  `oc_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'OC排放量',
  `bc_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'BC排放量',
  `nox_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'NOX排放量',
  `flagd` tinyint(4) NULL DEFAULT NULL COMMENT '排放因子标志位',
  `source_descrip` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述信息',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `year`(`year`, `company_id`, `scccode`) USING BTREE,
  INDEX `com_id`(`company_id`) USING BTREE,
  INDEX `scccode`(`scccode`) USING BTREE,
  CONSTRAINT `car_repair_ibfk_1` FOREIGN KEY (`company_id`) REFERENCES `company` (`com_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `car_repair_ibfk_2` FOREIGN KEY (`scccode`) REFERENCES `scc` (`scc`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1908 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for city
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `province_code` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `city_code` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `city_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for collectbreeding
-- ----------------------------
DROP TABLE IF EXISTS `collectbreeding`;
CREATE TABLE `collectbreeding`  (
  `id` int(14) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `year` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '年份',
  `company_id` int(14) NOT NULL,
  `source_discrip` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述信息',
  `scccode` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'Scc编码',
  `activity_level` double(20, 10) NULL DEFAULT NULL COMMENT '饲养量',
  `compute_cycle` int(8) NULL DEFAULT NULL COMMENT '计算周期',
  `pm10_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'pm10排放量',
  `pm25_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'PM25排放量',
  `voc_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'VOC排放量',
  `nh3_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'NH3排放量',
  `so2_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'SO2排放量',
  `co_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'CO排放量',
  `oc_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'OC排放量',
  `bc_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'BC排放量',
  `nox_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'NOX排放量',
  `flag` tinyint(4) NULL DEFAULT NULL COMMENT '排放因子标志位',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `year`(`year`, `company_id`, `scccode`) USING BTREE,
  INDEX `company_id`(`company_id`) USING BTREE,
  INDEX `scccode`(`scccode`) USING BTREE,
  CONSTRAINT `collectbreeding_ibfk_1` FOREIGN KEY (`company_id`) REFERENCES `company` (`com_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `collectbreeding_ibfk_2` FOREIGN KEY (`scccode`) REFERENCES `scc` (`scc`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1320 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '农牧源-畜禽集约化养殖源' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for company
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company`  (
  `com_id` int(14) NOT NULL AUTO_INCREMENT COMMENT '后台企业、加油站、加气站信息',
  `county_id` char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '区县编号',
  `company_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '企业、工厂、加油站等的名称',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '企业地址',
  `longitude` double(20, 10) NULL DEFAULT NULL COMMENT '企业经度',
  `latitude` double(20, 10) NULL DEFAULT NULL COMMENT '企业纬度',
  `domain` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所在功能区',
  `company_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '组织机构代码',
  `category` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '行业类别',
  PRIMARY KEY (`com_id`) USING BTREE,
  UNIQUE INDEX `county_id`(`county_id`, `company_name`, `address`, `longitude`, `latitude`) USING BTREE,
  CONSTRAINT `company_ibfk_1` FOREIGN KEY (`county_id`) REFERENCES `county` (`COUNTY_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 10715 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for county
-- ----------------------------
DROP TABLE IF EXISTS `county`;
CREATE TABLE `county`  (
  `provice_code` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `city_code` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `COUNTY_ID` char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `COUNTY_NAME` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TOTALGRIDS` int(4) NOT NULL DEFAULT 0,
  `XMAX` double(20, 4) NULL DEFAULT NULL,
  `XMIN` double(20, 4) NULL DEFAULT NULL,
  `YMAX` double(20, 4) NULL DEFAULT NULL,
  `YMIN` double(20, 4) NULL DEFAULT NULL,
  PRIMARY KEY (`COUNTY_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for deoil
-- ----------------------------
DROP TABLE IF EXISTS `deoil`;
CREATE TABLE `deoil`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `year` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '年份',
  `county_id` char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '区县编号',
  `peoplenumber` int(12) NULL DEFAULT NULL COMMENT '人口数量',
  `scccode` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '天津Scc编码',
  `pm10_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'Pm10排放量',
  `pm25_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'PM25排放量',
  `voc_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'VOC排放量',
  `nh3_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'NH3排放量',
  `so2_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'SO2排放量',
  `co_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'CO排放量',
  `oc_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'OC排放量',
  `bc_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'BC排放量',
  `nox_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'NOX排放量',
  `flagd` tinyint(4) NULL DEFAULT NULL COMMENT '排放因子标志位',
  `source_descrip` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述信息',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `year`(`year`, `county_id`, `scccode`) USING BTREE,
  INDEX `countyid`(`county_id`) USING BTREE,
  INDEX `scccode`(`scccode`) USING BTREE,
  CONSTRAINT `deoil_ibfk_1` FOREIGN KEY (`county_id`) REFERENCES `county` (`COUNTY_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `deoil_ibfk_2` FOREIGN KEY (`scccode`) REFERENCES `scc` (`scc`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept`  (
  `dept_id` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部门ID',
  `dept_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门名称',
  `parent_id` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '上级部门ID',
  `order_num` int(11) NULL DEFAULT NULL COMMENT '排序',
  `dept_level` int(4) NULL DEFAULT NULL,
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `modify_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`dept_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for device
-- ----------------------------
DROP TABLE IF EXISTS `device`;
CREATE TABLE `device`  (
  `id` int(14) NOT NULL AUTO_INCREMENT,
  `nk_no` int(14) NOT NULL COMMENT '设备编号',
  `EXHUST_ID` int(5) NULL DEFAULT NULL COMMENT '排气筒编号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '生产装置名称',
  `device_flow` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '主要工艺流程',
  `design_power` double(14, 2) NULL DEFAULT NULL COMMENT '设计生产',
  `practical_power` double(14, 2) NULL DEFAULT NULL COMMENT '实际生产能力',
  `yearrun_days` int(14) NULL DEFAULT NULL COMMENT '全年运行天数',
  `design_unit` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '生产能力单位',
  `factory_id` int(14) NULL DEFAULT NULL COMMENT '新增',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1764 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '工艺过程源设备表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for device_product
-- ----------------------------
DROP TABLE IF EXISTS `device_product`;
CREATE TABLE `device_product`  (
  `id` int(14) NOT NULL AUTO_INCREMENT,
  `nk_no` int(14) NOT NULL COMMENT '产品编号',
  `device_id` int(14) NULL DEFAULT NULL COMMENT '关联设备编号',
  `activities_category` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '生产活动类别ascc2',
  `name_category` char(3) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '产品名称/类别bSCC3',
  `scc_code` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `drainage_process` char(3) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '生产/排污工艺dSCC4',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品备注',
  `uint` varchar(14) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '计量单位e',
  `annual_output` double(14, 2) NULL DEFAULT NULL COMMENT '年产量',
  `nox` double(13, 2) NULL DEFAULT NULL,
  `co` double(13, 2) NULL DEFAULT NULL,
  `pm10` double(13, 2) NULL DEFAULT NULL,
  `pm25` double(13, 2) NULL DEFAULT NULL,
  `pm` double(13, 2) NULL DEFAULT NULL,
  `so2` double(13, 2) NULL DEFAULT NULL,
  `voc` double(13, 2) NULL DEFAULT NULL,
  `nh3` double(13, 2) NULL DEFAULT NULL,
  `oc` double(13, 2) NULL DEFAULT NULL,
  `bc` double(13, 2) NULL DEFAULT NULL,
  `danwei` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '计量单位',
  `Jan_useamount` double(15, 4) NULL DEFAULT NULL,
  `Feb_useamount` double(15, 4) NULL DEFAULT NULL,
  `Mar_useamount` double(15, 4) NULL DEFAULT NULL,
  `Apr_useamount` double(15, 4) NULL DEFAULT NULL,
  `May_useamount` double(15, 4) NULL DEFAULT NULL,
  `June_useamount` double(15, 4) NULL DEFAULT NULL,
  `July_useamount` double(15, 4) NULL DEFAULT NULL,
  `aug_useamount` double(15, 4) NULL DEFAULT NULL,
  `sept_useamount` double(15, 4) NULL DEFAULT NULL,
  `oct_use_amount` double(15, 4) NULL DEFAULT NULL,
  `nov_useamount` double(15, 4) NULL DEFAULT NULL,
  `dec_useamount` double(15, 4) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `device_product_temp_ibfk_1`(`device_id`) USING BTREE,
  CONSTRAINT `device_product_ibfk_1` FOREIGN KEY (`device_id`) REFERENCES `device` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1350 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '工艺过程源和溶剂使用源的设备产品信息' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for device_raw
-- ----------------------------
DROP TABLE IF EXISTS `device_raw`;
CREATE TABLE `device_raw`  (
  `id` int(14) NOT NULL AUTO_INCREMENT,
  `nk_no` int(14) NOT NULL COMMENT '原料编号',
  `device_id` int(14) NULL DEFAULT NULL COMMENT '对应装置编号',
  `mname` varchar(14) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '原辅料名称',
  `musage` double(14, 2) NULL DEFAULT NULL COMMENT '年使用量',
  `unit` varchar(14) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '计量单位',
  `scc2` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '生产活动类别a',
  `scc3` char(3) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '产品名称/类别b',
  `scc4` char(3) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `scc_code` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `nox` double(18, 2) NULL DEFAULT NULL,
  `co` double(18, 2) NULL DEFAULT NULL,
  `pm10` double(18, 2) NULL DEFAULT NULL,
  `pm25` double(18, 2) NULL DEFAULT NULL,
  `pm` double(18, 2) NULL DEFAULT NULL,
  `so2` double(18, 2) NULL DEFAULT NULL,
  `voc` double(18, 2) NULL DEFAULT NULL,
  `nh3` double(18, 2) NULL DEFAULT NULL,
  `oc` double(18, 2) NULL DEFAULT NULL,
  `bc` double(18, 2) NULL DEFAULT NULL,
  `Jan_useamount` double(15, 4) NULL DEFAULT NULL,
  `Feb_useamount` double(15, 4) NULL DEFAULT NULL,
  `Mar_useamount` double(15, 4) NULL DEFAULT NULL,
  `Apr_useamount` double(15, 4) NULL DEFAULT NULL,
  `May_useamount` double(15, 4) NULL DEFAULT NULL,
  `June_useamount` double(15, 4) NULL DEFAULT NULL,
  `July_useamount` double(15, 4) NULL DEFAULT NULL,
  `aug_useamount` double(15, 4) NULL DEFAULT NULL,
  `sept_useamount` double(15, 4) NULL DEFAULT NULL,
  `oct_use_amount` double(15, 4) NULL DEFAULT NULL,
  `nov_useamount` double(15, 4) NULL DEFAULT NULL,
  `dec_useamount` double(15, 4) NULL DEFAULT NULL,
  `gas_no` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '集气设施编号',
  `gas_pre` double(5, 2) NULL DEFAULT NULL COMMENT '集气效率',
  `gas_vocs` double(5, 2) NULL DEFAULT NULL COMMENT '原辅料VOCs含量',
  `treat_no` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '治理设施编号',
  `treat_pre` double(5, 2) NULL DEFAULT NULL COMMENT '治理设施VOCs去除率',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `device_id`(`device_id`) USING BTREE,
  CONSTRAINT `device_raw_ibfk_2` FOREIGN KEY (`device_id`) REFERENCES `device` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1597 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '工艺过程源原料表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for dry_cleaner
-- ----------------------------
DROP TABLE IF EXISTS `dry_cleaner`;
CREATE TABLE `dry_cleaner`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `year` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '年份',
  `company_id` int(14) NOT NULL COMMENT '企业代码',
  `scccode` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '天津Scc编码',
  `year_amount` double(20, 10) NULL DEFAULT NULL COMMENT '年干洗剂使用量',
  `pm10_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'Pm10排放量',
  `pm25_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'PM25排放量',
  `voc_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'VOC排放量',
  `nh3_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'NH3排放量',
  `so2_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'SO2排放量',
  `co_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'CO排放量',
  `oc_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'OC排放量',
  `bc_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'BC排放量',
  `nox_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'NOX排放量',
  `flagd` tinyint(4) NULL DEFAULT NULL COMMENT '排放因子标志位',
  `source_descrip` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述信息',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `year`(`year`, `company_id`, `scccode`) USING BTREE,
  INDEX `com_id`(`company_id`) USING BTREE,
  INDEX `scccode`(`scccode`) USING BTREE,
  CONSTRAINT `dry_cleaner_ibfk_1` FOREIGN KEY (`company_id`) REFERENCES `company` (`com_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `dry_cleaner_ibfk_2` FOREIGN KEY (`scccode`) REFERENCES `scc` (`scc`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 438 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for dustremove
-- ----------------------------
DROP TABLE IF EXISTS `dustremove`;
CREATE TABLE `dustremove`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `dust_remove_id` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `dust_remove_name` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pm_remove_effi` double(7, 3) NULL DEFAULT NULL,
  `pm10_remove_effi` double(7, 3) NULL DEFAULT NULL,
  `pm25_remove_effi` double(7, 3) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for exhaust
-- ----------------------------
DROP TABLE IF EXISTS `exhaust`;
CREATE TABLE `exhaust`  (
  `EXF_ID` int(11) NOT NULL AUTO_INCREMENT,
  `NK_NO` int(5) NOT NULL COMMENT '排气筒编号',
  `FACTORY_ID` int(14) NOT NULL COMMENT '企业ID',
  `EXF_MATERIAL` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '排气筒材质',
  `EXF_HEIGHT` double(16, 6) NOT NULL COMMENT '排气筒高度（m）',
  `SMOKE_OUTD` double(16, 6) NULL DEFAULT NULL COMMENT '烟气出口直径（m）',
  `SMOKE_O_UTTE_M` double(16, 6) NULL DEFAULT NULL COMMENT '烟气出口温度(℃)',
  `SMOKE_OUTA` double(16, 6) NULL DEFAULT NULL COMMENT '烟气流量',
  `SMOKE_OUTV` double(16, 6) NULL DEFAULT NULL COMMENT '烟气出口流速(m/s)',
  `EXF_LONGITUDE` double(10, 4) NULL DEFAULT NULL COMMENT '排气筒经度',
  `EXF_LATITUDE` double(10, 4) NULL DEFAULT NULL COMMENT '排气筒维度',
  PRIMARY KEY (`EXF_ID`) USING BTREE,
  INDEX `FACTORY_ID`(`FACTORY_ID`) USING BTREE,
  CONSTRAINT `exhaust_ibfk_2` FOREIGN KEY (`FACTORY_ID`) REFERENCES `factory` (`factory_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2736 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for f_bare_soil_dust_source
-- ----------------------------
DROP TABLE IF EXISTS `f_bare_soil_dust_source`;
CREATE TABLE `f_bare_soil_dust_source`  (
  `bare_soilid` int(11) NOT NULL AUTO_INCREMENT COMMENT '裸土扬尘源编号',
  `sccCode` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'scc编码',
  `factoryid` int(14) NULL DEFAULT NULL COMMENT '工厂id号',
  `bare_soil_area` double(20, 10) NULL DEFAULT NULL COMMENT '裸土面积',
  `pm25_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'pm2.5排放量',
  `pm10_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'pm10排放量',
  `oc_emission` double(20, 10) NULL DEFAULT NULL,
  `bc_emission` double(20, 10) NULL DEFAULT NULL,
  PRIMARY KEY (`bare_soilid`) USING BTREE,
  INDEX `scc2`(`sccCode`) USING BTREE,
  INDEX `fac1`(`factoryid`) USING BTREE,
  CONSTRAINT `fac1` FOREIGN KEY (`factoryid`) REFERENCES `factory` (`factory_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `scc2` FOREIGN KEY (`sccCode`) REFERENCES `scc` (`scc`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 84 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for f_construction_dust_source
-- ----------------------------
DROP TABLE IF EXISTS `f_construction_dust_source`;
CREATE TABLE `f_construction_dust_source`  (
  `construct_dustid` int(11) NOT NULL AUTO_INCREMENT COMMENT '施工扬尘源编号',
  `scccode` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'scc编码',
  `factoryid` int(14) NULL DEFAULT NULL COMMENT '工厂id号',
  `construct_state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '建筑施工阶段',
  `construct_area` double(20, 5) NULL DEFAULT NULL COMMENT '施工规划面积(m2)',
  `construct_months` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '施工活跃月份数',
  `control_measures` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '控制措施',
  `finisharea` double(20, 5) NULL DEFAULT NULL COMMENT '已竣工面积(m2)',
  `nowkgarea` double(20, 5) NULL DEFAULT NULL COMMENT '现在开工面积(m2)',
  `startdate` date NULL DEFAULT NULL COMMENT '施工开始日期',
  `pm10_emission` double(20, 5) NULL DEFAULT NULL COMMENT 'pm10排放量',
  `pm25_emission` double(20, 5) NULL DEFAULT NULL COMMENT 'pm2.5排放量',
  `oc_emission` double(20, 5) NULL DEFAULT NULL,
  `bc_emission` double(20, 5) NULL DEFAULT NULL,
  `LONGITUDE1` double(20, 5) NULL DEFAULT NULL COMMENT '拐点1经度',
  `LATITUDE1` double(20, 5) NULL DEFAULT NULL COMMENT '拐点1纬度',
  `LONGITUDE2` double(20, 5) NULL DEFAULT NULL COMMENT '拐点2经度',
  `LATITUDE2` double(20, 5) NULL DEFAULT NULL COMMENT '拐点2纬度',
  `LONGITUDE3` double(20, 5) NULL DEFAULT NULL COMMENT '拐点3经度',
  `LATITUDE3` double(20, 5) NULL DEFAULT NULL COMMENT '拐点3纬度',
  `LONGITUDE4` double(20, 5) NULL DEFAULT NULL COMMENT '拐点4经度',
  `LATITUDE4` double(20, 5) NULL DEFAULT NULL COMMENT '拐点4纬度',
  `construction_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '施工类型',
  `finishdate` date NULL DEFAULT NULL COMMENT '施工结束日期',
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`construct_dustid`) USING BTREE,
  INDEX `SCC`(`scccode`) USING BTREE,
  INDEX `fid`(`factoryid`) USING BTREE,
  CONSTRAINT `f_construction_dust_source_ibfk_1` FOREIGN KEY (`factoryid`) REFERENCES `factory` (`factory_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `f_construction_dust_source_ibfk_2` FOREIGN KEY (`scccode`) REFERENCES `scc` (`scc`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 95 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for f_no_organization_workshop_discharge
-- ----------------------------
DROP TABLE IF EXISTS `f_no_organization_workshop_discharge`;
CREATE TABLE `f_no_organization_workshop_discharge`  (
  `wsid` int(11) NOT NULL AUTO_INCREMENT,
  `workshopid` int(11) NOT NULL COMMENT '车间编号',
  `factoryid` int(14) NOT NULL COMMENT '工厂id号',
  `scccode` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'scc编码',
  `longitude` double(20, 10) NULL DEFAULT NULL COMMENT '经度',
  `latitude` double(20, 10) NULL DEFAULT NULL COMMENT '纬度',
  `production_use` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '生产用途',
  `workshop_area` double(20, 10) NULL DEFAULT NULL COMMENT '车间面积（m2）',
  `pm10_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'pm10排放量',
  `oc_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'oc排放量',
  `pm25_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'pm2.5排放量',
  `ec_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'ec排放量',
  `so2_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'so2排放量',
  `nox_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'nox排放量',
  `co_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'co排放量',
  `nh3_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'nh3排放量',
  `vocs_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'vocs排放量',
  PRIMARY KEY (`wsid`) USING BTREE,
  INDEX `factoryid`(`factoryid`) USING BTREE,
  INDEX `scccode`(`scccode`) USING BTREE,
  CONSTRAINT `f_no_organization_workshop_discharge_ibfk_1` FOREIGN KEY (`factoryid`) REFERENCES `factory` (`factory_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `f_no_organization_workshop_discharge_ibfk_2` FOREIGN KEY (`scccode`) REFERENCES `scc` (`scc`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1020 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for f_road_dust_source
-- ----------------------------
DROP TABLE IF EXISTS `f_road_dust_source`;
CREATE TABLE `f_road_dust_source`  (
  `road_dustid` int(11) NOT NULL AUTO_INCREMENT COMMENT '裸土扬尘源编号',
  `factoryid` int(14) NULL DEFAULT NULL COMMENT '工厂id号',
  `scccode` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'scc编码',
  `start_longitude` double(20, 10) NULL DEFAULT NULL COMMENT '起点经度',
  `start_latitude` double(20, 10) NULL DEFAULT NULL COMMENT '起点纬度',
  `end_longitude` double(20, 10) NULL DEFAULT NULL COMMENT '终点经度',
  `end_latitude` double(20, 10) NULL DEFAULT NULL COMMENT '终点纬度',
  `road_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '道路类型',
  `path_length` double(20, 10) NULL DEFAULT NULL COMMENT '道路长度',
  `ispave` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '道路铺设情况，是否铺装',
  `aver_width` double(20, 10) NULL DEFAULT NULL COMMENT '道路平均宽度',
  `aver_weight` double(20, 10) NULL DEFAULT NULL COMMENT '平均车重',
  `car_flow` int(11) NULL DEFAULT NULL COMMENT '车流量',
  `aver_speed` double(20, 10) NULL DEFAULT NULL COMMENT '平均车速',
  `clear_time_install` double(11, 5) NULL DEFAULT NULL COMMENT '清扫次数，安装真空装置',
  `clear_time_uninstall` double(11, 5) NULL DEFAULT NULL COMMENT '清扫次数，未安装真空装置',
  `sweep_spring` double(11, 5) NULL DEFAULT NULL COMMENT '春季湿扫 次数/天',
  `sweep_summer` double(11, 5) NULL DEFAULT NULL COMMENT '夏季湿扫 次数/天',
  `sweep_fall` double(11, 5) NULL DEFAULT NULL COMMENT '秋季湿扫 次数/天',
  `water_times_spring` double(11, 5) NULL DEFAULT NULL COMMENT '春季每日洒水次数',
  `water_times_summer` double(11, 5) NULL DEFAULT NULL COMMENT '夏季每日洒水次数',
  `water_times_fall` double(11, 5) NULL DEFAULT NULL COMMENT '秋季每日洒水次数',
  `dust_suppression` int(11) NULL DEFAULT NULL COMMENT '是否喷洒抑尘剂,0表示是，1表示否',
  `control_measures` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '控制措施',
  `pm25_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'pm2.5排放量',
  `pm10_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'pm10排放量',
  `oc_emission` double(20, 10) NULL DEFAULT NULL,
  `bc_emission` double(20, 10) NULL DEFAULT NULL,
  PRIMARY KEY (`road_dustid`) USING BTREE,
  INDEX `scc3`(`scccode`) USING BTREE,
  INDEX `fac3`(`factoryid`) USING BTREE,
  CONSTRAINT `fac3` FOREIGN KEY (`factoryid`) REFERENCES `factory` (`factory_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `scc3` FOREIGN KEY (`scccode`) REFERENCES `scc` (`scc`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 758 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for f_yard_dust_source
-- ----------------------------
DROP TABLE IF EXISTS `f_yard_dust_source`;
CREATE TABLE `f_yard_dust_source`  (
  `wind_dustid` int(11) NOT NULL AUTO_INCREMENT COMMENT '堆场装卸扬尘源id号',
  `factoryid` int(14) NULL DEFAULT NULL COMMENT '工厂id号',
  `scccode` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'scc编码',
  `longitude1` double(20, 5) NULL DEFAULT NULL COMMENT '拐点经度1',
  `latitude1` double(20, 5) NULL DEFAULT NULL COMMENT '拐点纬度1',
  `longitude2` double(20, 5) NULL DEFAULT NULL COMMENT '拐点经度2',
  `latitude2` double(20, 5) NULL DEFAULT NULL COMMENT '拐点纬度2',
  `longitude3` double(20, 5) NULL DEFAULT NULL COMMENT '拐点经度3',
  `latitude3` double(20, 5) NULL DEFAULT NULL COMMENT '拐点纬度3',
  `longitude4` double(20, 5) NULL DEFAULT NULL COMMENT '拐点经度4',
  `latitude4` double(20, 5) NULL DEFAULT NULL COMMENT '拐点纬度4',
  `material_type` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '物料种类',
  `wind_speed` double(20, 5) NULL DEFAULT NULL COMMENT '地面风速',
  `material_capacity` double(20, 5) NULL DEFAULT NULL COMMENT '物料装卸量',
  `loading_count` double(10, 4) NULL DEFAULT NULL COMMENT '每日装卸次数',
  `loading_start` time(0) NULL DEFAULT NULL COMMENT '装卸开始时间',
  `loading_time` time(0) NULL DEFAULT NULL COMMENT '每日装卸结束时间',
  `loading_capacity` double(20, 5) NULL DEFAULT NULL COMMENT '每次装卸量，t',
  `control_measures` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '风蚀扬尘控制措施',
  `moisture_materia` double(20, 5) NULL DEFAULT NULL COMMENT '物料含水率，%',
  `pm25_emission` double(20, 5) NULL DEFAULT NULL COMMENT 'pm2.5排放量',
  `pm10_emission` double(20, 5) UNSIGNED NULL DEFAULT NULL COMMENT 'pm10排放量',
  `bc_emission` double(20, 5) NULL DEFAULT NULL,
  `oc_emission` double(20, 5) NULL DEFAULT NULL,
  `heap_area` double(10, 5) NULL DEFAULT NULL COMMENT '堆料面积(m2)',
  `heap_covered` double(10, 5) NULL DEFAULT NULL COMMENT '堆料占地面积（m2）',
  `heap_heigh` double(10, 5) NULL DEFAULT NULL COMMENT '堆料高度（m）',
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `control_measures1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '装卸控制措施',
  `material_type1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '装卸物料种类',
  PRIMARY KEY (`wind_dustid`) USING BTREE,
  INDEX `FACTORYID`(`factoryid`) USING BTREE,
  INDEX `SCCCODE`(`scccode`) USING BTREE,
  CONSTRAINT `f_yard_dust_source_ibfk_1` FOREIGN KEY (`factoryid`) REFERENCES `factory` (`factory_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `f_yard_dust_source_ibfk_2` FOREIGN KEY (`scccode`) REFERENCES `scc` (`scc`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 281 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for factory
-- ----------------------------
DROP TABLE IF EXISTS `factory`;
CREATE TABLE `factory`  (
  `factory_id` int(14) NOT NULL AUTO_INCREMENT,
  `factory_no` char(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '组织机构代码',
  `legalperson` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '法定代表人',
  `factory_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '企业名称',
  `factory_usedname` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '企业曾用名',
  `factory_size` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '企业规模',
  `county_id` char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '区县ID',
  `industry_bigid` char(6) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '行业大分类ID',
  `industry_id` char(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '行业小分类ID',
  `address` char(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `power_amount` double(15, 4) NULL DEFAULT NULL COMMENT '年度用电',
  `address_register` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '注册地址',
  `countyid_register` char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '注册区县',
  `factory_longitude` double(20, 12) NULL DEFAULT NULL COMMENT '企业经度',
  `factory_latitude` double(20, 12) NULL DEFAULT NULL COMMENT '企业纬度',
  `source_type` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '污染源类型',
  `year` char(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '填报年份',
  `last_changed_time` datetime(0) NULL DEFAULT NULL COMMENT '最后更新时间',
  `audit_time` datetime(0) NULL DEFAULT NULL COMMENT '首次编辑时间',
  `filling_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '注册时间',
  `Year_days` int(5) UNSIGNED NULL DEFAULT NULL COMMENT '年生产天数',
  `Days_hours` int(5) NULL DEFAULT NULL COMMENT '日生产小时数',
  `total_output` double(25, 8) NULL DEFAULT NULL COMMENT '生产总值',
  `status` int(2) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '企业审核状态',
  `note` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '备注',
  `principal_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '填报人员姓名',
  `principal_phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '填报人员电话',
  `principal_mobile` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '填报人员手机号',
  `principal_email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '填报人员邮箱',
  `lat1` double(10, 6) NULL DEFAULT NULL,
  `lon1` double(10, 6) NULL DEFAULT NULL,
  `lat2` double(10, 6) NULL DEFAULT NULL,
  `lon2` double(10, 6) NULL DEFAULT NULL,
  `lat3` double(10, 6) NULL DEFAULT NULL,
  `lon3` double(10, 6) NULL DEFAULT NULL,
  `lat4` double(10, 6) NULL DEFAULT NULL,
  `lon4` double(10, 6) NULL DEFAULT NULL,
  `lat5` double(10, 6) NULL DEFAULT NULL,
  `lon5` double(10, 6) NULL DEFAULT NULL,
  `lat6` double(10, 6) NULL DEFAULT NULL,
  `lon6` double(10, 6) NULL DEFAULT NULL,
  `lat7` double(10, 6) NULL DEFAULT NULL,
  `lon7` double(10, 6) NULL DEFAULT NULL,
  `exhaust_count` int(4) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '排气筒数量',
  `boiler_count` int(4) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '锅炉数量',
  `kiln_count` int(4) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '窑炉数量',
  `device_count` int(2) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '工艺过程源-设备数量',
  `device_product_count` int(4) NULL DEFAULT NULL COMMENT '工艺过程源-产品数量',
  `device_raw_count` int(4) NULL DEFAULT NULL COMMENT '工艺过程源-原料数量',
  `rongji_product_count` int(4) NULL DEFAULT NULL COMMENT '溶剂使用源-产品数量',
  `rongji_raw_count` int(4) NULL DEFAULT NULL COMMENT '溶剂使用源-原料数量',
  `feiqi_count` int(4) NULL DEFAULT NULL COMMENT '废气-数量',
  `soil_dust_count` int(4) NULL DEFAULT NULL COMMENT '无组织扬尘排放-裸土数量',
  `con_dust_count` int(4) NULL DEFAULT NULL COMMENT '无组织扬尘排放-施工扬尘数量',
  `road_dust_count` int(4) NULL DEFAULT NULL COMMENT '无组织扬尘排放-道路扬尘数量',
  `yard_dust_count` int(4) NULL DEFAULT NULL COMMENT '无组织扬尘排放-堆场扬尘数量',
  `no_org_work_count` int(4) NULL DEFAULT NULL COMMENT '无组织车间数量',
  `flag` tinyint(1) NULL DEFAULT NULL COMMENT '是否纳入环统',
  `important` int(2) NULL DEFAULT NULL COMMENT '是否重点调查',
  PRIMARY KEY (`factory_id`) USING BTREE,
  INDEX `county_id`(`county_id`) USING BTREE,
  INDEX `industry_id`(`industry_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 32896 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for feiqi
-- ----------------------------
DROP TABLE IF EXISTS `feiqi`;
CREATE TABLE `feiqi`  (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `nkno` int(5) NOT NULL COMMENT '编号',
  `factory_id` int(5) NOT NULL COMMENT '企业编号',
  `device_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '处理工艺/设施名称',
  `scc2` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '废物类型',
  `scc3` char(3) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '废物类型',
  `scc4` char(3) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '处理技术',
  `scc_code` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `lon1` double(10, 6) NULL DEFAULT NULL COMMENT '设备经度',
  `lon2` double(10, 6) NULL DEFAULT NULL,
  `lon3` double(10, 6) NULL DEFAULT NULL,
  `lon4` double(10, 6) NULL DEFAULT NULL,
  `lat1` double(10, 6) NULL DEFAULT NULL COMMENT '设备纬度',
  `lat2` double(10, 6) NULL DEFAULT NULL,
  `lat3` double(10, 6) NULL DEFAULT NULL,
  `lat4` double(10, 6) NULL DEFAULT NULL COMMENT '污水处理量(m3/h)',
  `watter` double(15, 3) NULL DEFAULT NULL COMMENT '废水',
  `tian` double(15, 3) NULL DEFAULT NULL COMMENT '固体废弃物填埋处理量-------？',
  `dui` double(15, 3) NULL DEFAULT NULL COMMENT '固体废弃物堆肥处理量/-------？',
  `fen` double(15, 3) NULL DEFAULT NULL COMMENT '固体废弃物填埋处理量-------？',
  `pm10_emission` double(20, 10) NULL DEFAULT NULL,
  `pm25_emission` double(20, 10) NULL DEFAULT NULL,
  `vocs` double(15, 3) NULL DEFAULT NULL,
  `nh3` double(15, 3) NULL DEFAULT NULL,
  `oc_emission` double(20, 10) NULL DEFAULT NULL,
  `bc_emission` double(20, 10) NULL DEFAULT NULL,
  `so2_emission` double(20, 10) NULL DEFAULT NULL,
  `nox_emission` double(20, 10) NULL DEFAULT NULL,
  `Mar_useamount` double(15, 5) NULL DEFAULT NULL COMMENT '每月使用量--是否应该x每月时变系数',
  `Feb_useamount` double(15, 5) NULL DEFAULT NULL,
  `Jan_useamount` double(15, 5) NULL DEFAULT NULL,
  `May_useamount` double(15, 5) NULL DEFAULT NULL,
  `June_useamount` double(15, 5) NULL DEFAULT NULL,
  `July_useamount` double(15, 5) NULL DEFAULT NULL,
  `sept_useamount` double(15, 5) NULL DEFAULT NULL,
  `aug_useamount` double(15, 5) NULL DEFAULT NULL,
  `Apr_useamount` double(15, 5) NULL DEFAULT NULL,
  `oct_use_amount` double(15, 5) NULL DEFAULT NULL,
  `nov_useamount` double(15, 5) NULL DEFAULT NULL,
  `dec_useamount` double(15, 5) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 204 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for fertilization
-- ----------------------------
DROP TABLE IF EXISTS `fertilization`;
CREATE TABLE `fertilization`  (
  `id` int(14) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `year` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '年份',
  `county_id` char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '区县编码',
  `scccode` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Scc编码',
  `source_descrip` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Scc描述信息',
  `activity_level` double(20, 10) NULL DEFAULT NULL COMMENT '施肥量',
  `pm10_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'Pm10排放量',
  `pm25_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'PM25排放量',
  `voc_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'VOC排放量',
  `nh3_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'NH3排放量',
  `so2_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'SO2排放量',
  `co_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'CO排放量',
  `oc_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'OC排放量',
  `bc_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'BC排放量',
  `nox_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'NOX排放量',
  `flag` tinyint(4) NULL DEFAULT NULL COMMENT '排放因子标志位',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `year`(`year`, `county_id`, `scccode`, `source_descrip`) USING BTREE,
  INDEX `county_id`(`county_id`) USING BTREE,
  INDEX `scccode`(`scccode`) USING BTREE,
  CONSTRAINT `fertilization_ibfk_1` FOREIGN KEY (`county_id`) REFERENCES `county` (`COUNTY_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fertilization_ibfk_2` FOREIGN KEY (`scccode`) REFERENCES `scc` (`scc`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 101 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for free_stockbreeding
-- ----------------------------
DROP TABLE IF EXISTS `free_stockbreeding`;
CREATE TABLE `free_stockbreeding`  (
  `id` int(14) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `year` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '年份',
  `county_id` char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '区县编码',
  `scccode` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'scc编码',
  `source_discrip` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述信息',
  `activity_level` double(20, 10) NULL DEFAULT NULL COMMENT '饲养量(活动水平)',
  `compute_cycle` int(8) NULL DEFAULT NULL COMMENT '计算周期',
  `pm10_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'pm10排放量',
  `pm25_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'pm25排放量',
  `voc_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'voc排放量',
  `nh3_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'nh3排放量',
  `so2_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'so2排放量',
  `co_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'co排放量',
  `oc_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'oc排放量',
  `bc_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'bc排放量',
  `nox_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'nox排放量',
  `flag` tinyint(4) NULL DEFAULT NULL COMMENT '排放因子标志位',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `year`(`year`, `county_id`, `scccode`) USING BTREE,
  INDEX `county_id`(`county_id`) USING BTREE,
  INDEX `scccode`(`scccode`) USING BTREE,
  CONSTRAINT `free_stockbreeding_ibfk_1` FOREIGN KEY (`county_id`) REFERENCES `county` (`COUNTY_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `free_stockbreeding_ibfk_2` FOREIGN KEY (`scccode`) REFERENCES `scc` (`scc`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 14031 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for gas_source
-- ----------------------------
DROP TABLE IF EXISTS `gas_source`;
CREATE TABLE `gas_source`  (
  `id` int(14) NOT NULL AUTO_INCREMENT COMMENT '加气站源信息的id号',
  `company_id` int(14) NOT NULL COMMENT '加油站企业的id号，参考company表',
  `year` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '填报源信息的年份',
  `gas_type` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '销售的天然气的种类（天然气，液化石油气）',
  `scccode` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'scccode',
  `source_discrip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sales_volume` double(20, 10) NULL DEFAULT NULL COMMENT '汽油/柴油的销售量',
  `emission` double(20, 10) NULL DEFAULT NULL COMMENT '对应源数据的vocs的排放量',
  `flag` int(4) NULL DEFAULT 0 COMMENT '标志位，判断SCC用实际值还是理论值',
  `volume` double(20, 10) NULL DEFAULT 0.0000000000 COMMENT '储罐容量',
  `every_volume` double(20, 10) NULL DEFAULT 0.0000000000 COMMENT '每次充油量',
  `volume_count` int(10) NULL DEFAULT 0 COMMENT '年充油次数',
  `gun_num` int(10) NULL DEFAULT 0 COMMENT '加油枪的数量',
  `tank_num` int(10) NULL DEFAULT 0 COMMENT '储罐数量',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `company_id`(`company_id`, `year`, `scccode`) USING BTREE,
  INDEX `scccode`(`scccode`) USING BTREE,
  CONSTRAINT `gas_source_ibfk_1` FOREIGN KEY (`company_id`) REFERENCES `company` (`com_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `gas_source_ibfk_2` FOREIGN KEY (`scccode`) REFERENCES `scc` (`scc`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 136 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for house
-- ----------------------------
DROP TABLE IF EXISTS `house`;
CREATE TABLE `house`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `year` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '年份',
  `county_id` char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '区县编号',
  `solvent_amount` double(20, 10) NULL DEFAULT NULL COMMENT '溶剂使用量',
  `scccode` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '天津Scc编码',
  `pm10_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'Pm10排放量',
  `pm25_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'PM25排放量',
  `voc_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'VOC排放量',
  `nh3_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'NH3排放量',
  `so2_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'SO2排放量',
  `co_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'CO排放量',
  `oc_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'OC排放量',
  `bc_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'BC排放量',
  `nox_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'NOX排放量',
  `flagd` tinyint(4) NULL DEFAULT NULL COMMENT '排放因子标志位',
  `source_descrip` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述信息',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `countyid`(`county_id`) USING BTREE,
  INDEX `scccode`(`scccode`) USING BTREE,
  INDEX `year`(`year`, `county_id`, `scccode`) USING BTREE,
  CONSTRAINT `house_ibfk_1` FOREIGN KEY (`county_id`) REFERENCES `county` (`COUNTY_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `house_ibfk_2` FOREIGN KEY (`scccode`) REFERENCES `scc` (`scc`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for industry
-- ----------------------------
DROP TABLE IF EXISTS `industry`;
CREATE TABLE `industry`  (
  `INDUSTRY_ID` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `INDUSTRY_NAME` char(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `INDUSTRY_DESC` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  PRIMARY KEY (`INDUSTRY_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for industry_big
-- ----------------------------
DROP TABLE IF EXISTS `industry_big`;
CREATE TABLE `industry_big`  (
  `ID` int(2) NOT NULL AUTO_INCREMENT,
  `industry_code` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `industry_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 44 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for industry_small
-- ----------------------------
DROP TABLE IF EXISTS `industry_small`;
CREATE TABLE `industry_small`  (
  `id` int(6) NOT NULL,
  `industry_big` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `industry_small` char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `industry_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `industry_small`(`industry_small`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for kiln
-- ----------------------------
DROP TABLE IF EXISTS `kiln`;
CREATE TABLE `kiln`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '窑炉表',
  `NK_NO` int(5) NOT NULL COMMENT '内部使用的编号',
  `EXHUST_ID` int(11) NOT NULL COMMENT '排气筒编号',
  `FUNCTIO` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '窑炉用途',
  `KILN_MODEL` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '窑炉设备类型',
  `MODEL` varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '窑炉类型',
  `fueltype` char(3) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '窑炉类型对应SCC四级',
  `SCCCODE` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `KILN_FUEL_AUSAGE` double(10, 2) NULL DEFAULT NULL COMMENT '炉窑用途',
  `KILN_FUEL_AUSAGEUNIT` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '炉窑运行小时数',
  `NITREREMOVEID` int(10) NULL DEFAULT NULL COMMENT '除尘设施',
  `DUSTREMOVEID` int(10) NULL DEFAULT NULL COMMENT '脱硫设施',
  `SULPHURREMOVEID` int(10) NULL DEFAULT NULL COMMENT '脱硝设施',
  `COALASH` double(8, 6) NULL DEFAULT NULL COMMENT '燃料灰分',
  `coal_volatilisation` double(5, 2) NULL DEFAULT NULL COMMENT '燃料挥发分',
  `COALSULFUR` double(8, 6) NULL DEFAULT NULL COMMENT '燃料硫分',
  `PM10` double(18, 6) NULL DEFAULT NULL,
  `PM25` double(18, 6) NULL DEFAULT NULL,
  `CO` double(18, 6) NULL DEFAULT NULL,
  `VOC` double(18, 6) NULL DEFAULT NULL,
  `PM` double(18, 6) NULL DEFAULT NULL,
  `SO2` double(18, 6) NULL DEFAULT NULL,
  `NOX` double(18, 6) NULL DEFAULT NULL,
  `NH3` double(18, 6) NULL DEFAULT NULL,
  `OC` double(18, 6) NULL DEFAULT NULL,
  `BC` double(18, 6) NULL DEFAULT NULL,
  `feiqiti` double(25, 5) NULL DEFAULT NULL,
  `Jan_useamount` double(15, 4) NULL DEFAULT NULL,
  `Feb_useamount` double(15, 4) NULL DEFAULT NULL,
  `Mar_useamount` double(15, 4) NULL DEFAULT NULL,
  `Apr_useamount` double(15, 4) NULL DEFAULT NULL,
  `May_useamount` double(15, 4) NULL DEFAULT NULL,
  `June_useamount` double(15, 4) NULL DEFAULT NULL,
  `July_useamount` double(15, 4) NULL DEFAULT NULL,
  `aug_useamount` double(15, 4) NULL DEFAULT NULL,
  `sept_useamount` double(15, 4) NULL DEFAULT NULL,
  `oct_use_amount` double(15, 4) NULL DEFAULT NULL,
  `nov_useamount` double(15, 4) NULL DEFAULT NULL,
  `dec_useamount` double(15, 4) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE,
  INDEX `EXF_ID`(`EXHUST_ID`) USING BTREE,
  INDEX `SCCCODE`(`SCCCODE`) USING BTREE,
  INDEX `DUSTREMOVEID`(`DUSTREMOVEID`) USING BTREE,
  INDEX `NITREREMOVEID`(`NITREREMOVEID`) USING BTREE,
  INDEX `SULPHURREMOVEID`(`SULPHURREMOVEID`) USING BTREE,
  CONSTRAINT `kiln_ibfk_2` FOREIGN KEY (`EXHUST_ID`) REFERENCES `exhaust` (`EXF_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `kiln_ibfk_3` FOREIGN KEY (`DUSTREMOVEID`) REFERENCES `dustremove` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `kiln_ibfk_4` FOREIGN KEY (`NITREREMOVEID`) REFERENCES `nitreremove` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `kiln_ibfk_7` FOREIGN KEY (`SULPHURREMOVEID`) REFERENCES `sulphurremove` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 531 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '窑炉表\r\n' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for login_log
-- ----------------------------
DROP TABLE IF EXISTS `login_log`;
CREATE TABLE `login_log`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login_time` datetime(0) NULL DEFAULT NULL COMMENT '登录时间',
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户名',
  `login_status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '登录状态, 0 表示登录失败, 1 表示登录成功.',
  `ip` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'IP',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 722 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '登录日志表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单 ID',
  `parent_id` int(11) NOT NULL,
  `menu_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单 URL',
  `perms` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限标识符',
  `order_num` int(11) NULL DEFAULT NULL COMMENT '排序',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `modify_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `icon` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 702001 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for n_plant
-- ----------------------------
DROP TABLE IF EXISTS `n_plant`;
CREATE TABLE `n_plant`  (
  `id` int(14) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `year` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '年份',
  `county_id` char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '区县编码',
  `scccode` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Scc编码',
  `source_descrip` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Scc描述信息',
  `plant_area` double(20, 10) NULL DEFAULT NULL COMMENT '植物面积',
  `pm10_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'Pm10排放量',
  `pm25_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'PM25排放量',
  `voc_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'VOC排放量',
  `nh3_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'NH3排放量',
  `so2_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'SO2排放量',
  `co_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'CO排放量',
  `oc_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'OC排放量',
  `bc_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'BC排放量',
  `nox_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'NOX排放量',
  `flag` tinyint(4) NULL DEFAULT NULL COMMENT '排放因子标志位',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `year`(`year`, `county_id`, `scccode`) USING BTREE,
  INDEX `county_id`(`county_id`) USING BTREE,
  INDEX `scccode`(`scccode`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '农牧源-固氮植物' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for nitreremove
-- ----------------------------
DROP TABLE IF EXISTS `nitreremove`;
CREATE TABLE `nitreremove`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `nitre_remove_id` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nitre_method` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `NOX_remove_effi` double(7, 0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for nonroad_machinery
-- ----------------------------
DROP TABLE IF EXISTS `nonroad_machinery`;
CREATE TABLE `nonroad_machinery`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `year` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '年份',
  `county_id` char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '区县编码',
  `scc_code` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'scc编码',
  `source_descrip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'scc描述',
  `nonroad_type` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '非道路移动源类型',
  `type` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型',
  `fuel_type` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '燃料类型',
  `holdings` int(20) NULL DEFAULT NULL COMMENT '保有量',
  `use_hours` double(18, 10) NULL DEFAULT NULL COMMENT '使用小时数',
  `fuel_annual_usage` double(50, 20) NULL DEFAULT NULL COMMENT '燃料年使用量',
  `fuel_sulfur_content` double(18, 10) NULL DEFAULT NULL COMMENT '燃料含硫率',
  `annal_average_mileage` double(18, 10) NULL DEFAULT NULL COMMENT '年平均行驶里程',
  `pm10_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'PM10排放量',
  `pm25_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'pm25排放量',
  `co_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'co排放量',
  `so2_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'so2排放量',
  `nox_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'nox排放量',
  `vocs_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'voc排放量',
  `bc_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'bc排放量',
  `oc_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'oc排放量',
  `nh3_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'nh3排放量',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `year`(`year`, `county_id`, `scc_code`, `type`) USING BTREE,
  INDEX `scc_engine`(`scc_code`) USING BTREE,
  INDEX `countyid_engine`(`county_id`) USING BTREE,
  CONSTRAINT `nonroad_machinery_ibfk_2` FOREIGN KEY (`scc_code`) REFERENCES `scc` (`scc`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `nonroad_machinery_ibfk_3` FOREIGN KEY (`county_id`) REFERENCES `county` (`COUNTY_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 57 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for oil_source
-- ----------------------------
DROP TABLE IF EXISTS `oil_source`;
CREATE TABLE `oil_source`  (
  `id` int(14) NOT NULL COMMENT '加油站源信息的id号',
  `company_id` int(14) NOT NULL COMMENT '加油站企业的id号，参考company表',
  `year` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '填报源信息的年份',
  `oil_type` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '销售的油品的类型（汽油，柴油）',
  `scccode` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'scccode',
  `source_discrip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sales_volume` double(20, 10) NULL DEFAULT NULL COMMENT '汽油/柴油的销售量',
  `emission` double(20, 10) NULL DEFAULT NULL COMMENT '对应源数据的vocs的排放量',
  `flag` int(4) NULL DEFAULT 0 COMMENT '标志位，判断SCC用实际值还是理论值',
  `volume` double(20, 10) NULL DEFAULT 0.0000000000 COMMENT '储罐容量',
  `every_volume` double(20, 10) NULL DEFAULT 0.0000000000 COMMENT '每次充油量',
  `volume_count` double(10, 0) NULL DEFAULT 0 COMMENT '年充油次数-存在小数的情况',
  `gun_num` int(10) NULL DEFAULT 0 COMMENT '加油枪的数量',
  `tank_num` int(10) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `company_id`(`company_id`, `year`, `scccode`) USING BTREE,
  INDEX `scccode`(`scccode`) USING BTREE,
  CONSTRAINT `oil_source_ibfk_1` FOREIGN KEY (`company_id`) REFERENCES `company` (`com_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `oil_source_ibfk_2` FOREIGN KEY (`scccode`) REFERENCES `scc` (`scc`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for oil_transport
-- ----------------------------
DROP TABLE IF EXISTS `oil_transport`;
CREATE TABLE `oil_transport`  (
  `id` int(14) NOT NULL COMMENT '加油站源信息的id号',
  `company_id` int(14) NOT NULL COMMENT '加油站企业的id号，参考company表',
  `year` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '填报源信息的年份',
  `oil_type` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '运输的油品的类型',
  `scccode` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'scccode',
  `source_discrip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `year_volume` double(20, 10) NULL DEFAULT NULL COMMENT '年装卸油量Q（m3）',
  `control_rate` int(4) NULL DEFAULT 0 COMMENT '控制效率',
  `emission` double(20, 10) NULL DEFAULT NULL COMMENT '对应源数据的vocs的排放量',
  `flag` int(4) NULL DEFAULT 0 COMMENT '标志位，判断SCC用实际值还是理论值',
  `note` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '保留备用字段',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `company_id`(`company_id`, `year`, `scccode`, `oil_type`) USING BTREE,
  INDEX `scccode`(`scccode`) USING BTREE,
  CONSTRAINT `oil_transport_ibfk_1` FOREIGN KEY (`company_id`) REFERENCES `company` (`com_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `oil_transport_ibfk_2` FOREIGN KEY (`scccode`) REFERENCES `scc` (`scc`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for operator
-- ----------------------------
DROP TABLE IF EXISTS `operator`;
CREATE TABLE `operator`  (
  `operator_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单 ID',
  `menu_id` int(11) NOT NULL COMMENT '所属菜单 ID',
  `operator_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源名称',
  `url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源 URL',
  `perms` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限标识符',
  `http_method` varchar(7) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源需要的 HTTP 请求方法',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `modify_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`operator_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 82 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for pesticide
-- ----------------------------
DROP TABLE IF EXISTS `pesticide`;
CREATE TABLE `pesticide`  (
  `id` int(14) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `year` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '年份',
  `county_id` char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '区县编码',
  `scccode` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'Scc编码',
  `source_descrip` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述信息',
  `pesticideamount` double(20, 10) NULL DEFAULT NULL COMMENT '农药用量',
  `pm10_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'Pm10排放量',
  `pm25_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'PM25排放量',
  `voc_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'VOC排放量',
  `nh3_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'NH3排放量',
  `so2_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'SO2排放量',
  `co_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'CO排放量',
  `oc_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'OC排放量',
  `bc_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'BC排放量',
  `nox_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'NOX排放量',
  `flagd` tinyint(4) NULL DEFAULT NULL COMMENT '排放因子标志位',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `year`(`year`, `county_id`, `scccode`) USING BTREE,
  INDEX `county_id`(`county_id`) USING BTREE,
  INDEX `scccode`(`scccode`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 40 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '农牧源-土壤本底源' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for railway_engine
-- ----------------------------
DROP TABLE IF EXISTS `railway_engine`;
CREATE TABLE `railway_engine`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `year` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '年份',
  `county_id` char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '区县编码',
  `scc_code` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'scc编码',
  `source_descrip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型',
  `fuel_annual_usage` double(18, 10) NULL DEFAULT NULL COMMENT '燃料年使用量',
  `fuel_sulfur_content` double(18, 10) NULL DEFAULT NULL COMMENT '燃料含硫率',
  `fuel_type` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '燃料类型',
  `annal_average_mileage` double(18, 10) NULL DEFAULT NULL COMMENT '年平均行驶里程',
  `pm10_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'PM10排放量',
  `pm25_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'pm25排放量',
  `co_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'co排放量',
  `so2_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'so2排放量',
  `nox_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'nox排放量',
  `vocs_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'voc排放量',
  `bc_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'bc排放量',
  `oc_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'oc排放量',
  `nh3_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'nh3排放量',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `year`(`year`, `county_id`, `scc_code`) USING BTREE,
  INDEX `scc_engine`(`scc_code`) USING BTREE,
  INDEX `countyid_engine`(`county_id`) USING BTREE,
  CONSTRAINT `railway_engine_ibfk_1` FOREIGN KEY (`county_id`) REFERENCES `county` (`COUNTY_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `scc_engine` FOREIGN KEY (`scc_code`) REFERENCES `scc` (`scc`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for repast
-- ----------------------------
DROP TABLE IF EXISTS `repast`;
CREATE TABLE `repast`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `factoryid` int(14) NOT NULL,
  `year` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `cooking_num` int(8) NOT NULL COMMENT '灶头数',
  `cleaner_num` int(11) NULL DEFAULT NULL COMMENT '油烟净化器个数',
  `scccode` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `smoke_rate` double(20, 10) NOT NULL COMMENT '烟气排放速率',
  `annual_runtime` int(8) NOT NULL COMMENT '年经营时间',
  `removal_effi` double(20, 10) NOT NULL COMMENT '油烟净化器去除效率',
  `household_num` int(10) NULL DEFAULT NULL,
  `pm_emf` double(20, 10) NULL DEFAULT NULL COMMENT 'pm排放因子',
  `pm_emfunit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pm10_emf` double(20, 10) NULL DEFAULT NULL,
  `pm10_emfunit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pm25_emf` double(20, 10) NULL DEFAULT NULL,
  `pm25_emfunit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `so2_emf` double(20, 10) NULL DEFAULT NULL,
  `so2_emfunit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nox_emf` double(20, 10) NULL DEFAULT NULL,
  `nox_emfunit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `co_emf` double(20, 10) NULL DEFAULT NULL,
  `co_emfunit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nh3_emf` double(20, 10) NULL DEFAULT NULL,
  `nh3_emfunit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `voc_emf` double(20, 10) NULL DEFAULT NULL,
  `voc_emfunit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `oc_emf` double(20, 10) NULL DEFAULT NULL,
  `oc_emfunit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bc_emf` double(20, 10) NULL DEFAULT NULL,
  `bc_emfunit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pm_emission` double(20, 10) NULL DEFAULT 0.0000000000 COMMENT 'pm排放量',
  `pm_emiunit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pm10_emission` double(20, 10) NULL DEFAULT NULL,
  `pm10_emiunit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pm25_emission` double(20, 10) NULL DEFAULT NULL,
  `pm25_emiunit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `so2_emission` double(20, 10) NULL DEFAULT NULL,
  `so2_emiunit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nox_emission` double(20, 10) NULL DEFAULT NULL,
  `nox_emiunit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `co_emission` double(20, 10) NULL DEFAULT NULL,
  `co_emiunit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nh3_emission` double(20, 10) NULL DEFAULT NULL,
  `nh3_emiunit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `voc_emission` double(20, 10) NULL DEFAULT NULL,
  `voc_emiunit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `oc_emission` double(20, 10) NULL DEFAULT NULL,
  `oc_emiunit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bc_emission` double(20, 10) NULL DEFAULT NULL,
  `bc_emiunit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `flag` tinyint(1) NULL DEFAULT 0,
  `gas_consumption` double(20, 10) NULL DEFAULT NULL COMMENT '燃气使用量',
  `coal_consumption` double(20, 10) NULL DEFAULT NULL COMMENT '燃煤消耗量',
  `coalgas_consumption` double(20, 10) NULL DEFAULT NULL COMMENT '煤气消耗量',
  `power_consumption` double(20, 10) NULL DEFAULT NULL COMMENT '用电量',
  `methanol_consumption` double(20, 10) NULL DEFAULT NULL COMMENT '甲醛消耗量',
  `other_consumption` double(20, 10) NULL DEFAULT NULL COMMENT '其他消耗量',
  `other_conunit` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '其他消耗量单位',
  `oil_consumption` double(20, 10) NULL DEFAULT NULL COMMENT '食用油消耗量',
  `source_discrip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '污染源描述',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `scccode`(`scccode`) USING BTREE,
  INDEX `factoryid`(`factoryid`) USING BTREE,
  CONSTRAINT `repast_ibfk_2` FOREIGN KEY (`scccode`) REFERENCES `scc` (`scc`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `repast_ibfk_3` FOREIGN KEY (`factoryid`) REFERENCES `company` (`com_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 6050 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for repast_barbecue
-- ----------------------------
DROP TABLE IF EXISTS `repast_barbecue`;
CREATE TABLE `repast_barbecue`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `factoryid` int(14) NOT NULL,
  `year` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `scccode` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `annual_runtime` int(8) NOT NULL COMMENT '年经营时间',
  `day_runntime` double(10, 5) NULL DEFAULT NULL COMMENT '日均烤肉量',
  `pm_emf` double(20, 10) NULL DEFAULT NULL COMMENT 'pm排放因子',
  `pm_emfunit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pm10_emf` double(20, 10) NULL DEFAULT NULL,
  `pm10_emfunit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pm25_emf` double(20, 10) NULL DEFAULT NULL,
  `pm25_emfunit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `so2_emf` double(20, 10) NULL DEFAULT NULL,
  `so2_emfunit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nox_emf` double(20, 10) NULL DEFAULT NULL,
  `nox_emfunit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `co_emf` double(20, 10) NULL DEFAULT NULL,
  `co_emfunit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nh3_emf` double(20, 10) NULL DEFAULT NULL,
  `nh3_emfunit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `voc_emf` double(20, 10) NULL DEFAULT NULL,
  `voc_emfunit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `oc_emf` double(20, 10) NULL DEFAULT NULL,
  `oc_emfunit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bc_emf` double(20, 10) NULL DEFAULT NULL,
  `bc_emfunit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pm_emission` double(20, 10) NULL DEFAULT 0.0000000000 COMMENT 'pm排放量',
  `pm_emiunit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pm10_emission` double(20, 10) NULL DEFAULT NULL,
  `pm10_emiunit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pm25_emission` double(20, 10) NULL DEFAULT NULL,
  `pm25_emiunit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `so2_emission` double(20, 10) NULL DEFAULT NULL,
  `so2_emiunit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nox_emission` double(20, 10) NULL DEFAULT NULL,
  `nox_emiunit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `co_emission` double(20, 10) NULL DEFAULT NULL,
  `co_emiunit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nh3_emission` double(20, 10) NULL DEFAULT NULL,
  `nh3_emiunit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `voc_emission` double(20, 10) NULL DEFAULT NULL,
  `voc_emiunit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `oc_emission` double(20, 10) NULL DEFAULT NULL,
  `oc_emiunit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bc_emission` double(20, 10) NULL DEFAULT NULL,
  `bc_emiunit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `flag` tinyint(1) NULL DEFAULT 0,
  `gas_consumption` double(20, 10) NULL DEFAULT NULL COMMENT '燃气使用量',
  `coal_consumption` double(20, 10) NULL DEFAULT NULL COMMENT '木炭消耗量',
  `power_consumption` double(20, 10) NULL DEFAULT NULL COMMENT '用电量',
  `methanol_consumption` double(20, 10) NULL DEFAULT NULL COMMENT '甲醛消耗量',
  `other_consumption` double(20, 10) NULL DEFAULT NULL COMMENT '其他消耗量',
  `other_conunit` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '其他消耗量单位',
  `meal_consumption` double(20, 10) NOT NULL COMMENT '肉品消耗量',
  `source_discrip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '污染源描述',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `scccode`(`scccode`) USING BTREE,
  INDEX `factoryid`(`factoryid`) USING BTREE,
  CONSTRAINT `repast_barbecue_ibfk_1` FOREIGN KEY (`scccode`) REFERENCES `scc` (`scc`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `repast_barbecue_ibfk_2` FOREIGN KEY (`factoryid`) REFERENCES `company` (`com_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 951 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for repast_family
-- ----------------------------
DROP TABLE IF EXISTS `repast_family`;
CREATE TABLE `repast_family`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `year` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `county_name` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `county_id` char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `nonfarm_num` double(20, 10) NULL DEFAULT NULL,
  `farm_num` double(20, 10) NULL DEFAULT NULL,
  `total_num` double(20, 10) NULL DEFAULT NULL,
  `scccode` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `smoke_rate` double(20, 10) NOT NULL COMMENT '烟气排放速率',
  `annual_runtime` int(8) NOT NULL COMMENT '年经营时间',
  `gas_consumption` double(20, 10) NULL DEFAULT NULL COMMENT '燃气消耗量',
  `removal_effi` double(20, 10) NOT NULL COMMENT '油烟净化器去除效率',
  `pm_emf` double(20, 10) NULL DEFAULT NULL COMMENT 'pm排放因子',
  `pm_emfunit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pm10_emf` double(20, 10) NULL DEFAULT NULL,
  `pm10_emfunit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pm25_emf` double(20, 10) NULL DEFAULT NULL,
  `pm25_emfunit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `so2_emf` double(20, 10) NULL DEFAULT NULL,
  `so2_emfunit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nox_emf` double(20, 10) NULL DEFAULT NULL,
  `nox_emfunit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `co_emf` double(20, 10) NULL DEFAULT NULL,
  `co_emfunit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nh3_emf` double(20, 10) NULL DEFAULT NULL,
  `nh3_emfunit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `voc_emf` double(20, 10) NULL DEFAULT NULL,
  `voc_emfunit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `oc_emf` double(20, 10) NULL DEFAULT NULL,
  `oc_emfunit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bc_emf` double(20, 10) NULL DEFAULT NULL,
  `bc_emfunit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pm_emission` double(20, 10) NULL DEFAULT 0.0000000000 COMMENT 'pm排放量',
  `pm_emiunit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pm10_emission` double(20, 10) NULL DEFAULT NULL,
  `pm10_emiunit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pm25_emission` double(20, 10) NULL DEFAULT NULL,
  `pm25_emiunit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `so2_emission` double(20, 10) NULL DEFAULT NULL,
  `so2_emiunit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nox_emission` double(20, 10) NULL DEFAULT NULL,
  `nox_emiunit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `co_emission` double(20, 10) NULL DEFAULT NULL,
  `co_emiunit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nh3_emission` double(20, 10) NULL DEFAULT NULL,
  `nh3_emiunit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `voc_emission` double(20, 10) NULL DEFAULT NULL,
  `voc_emiunit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `oc_emission` double(20, 10) NULL DEFAULT NULL,
  `oc_emiunit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bc_emission` double(20, 10) NULL DEFAULT NULL,
  `bc_emiunit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `flag` tinyint(1) NULL DEFAULT 0,
  `coal_consumption` double(20, 10) NULL DEFAULT NULL COMMENT '燃煤消耗量',
  `other_consumption` double(20, 10) NULL DEFAULT NULL COMMENT '其他消耗量',
  `other_conunit` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '其它消耗量单位',
  `oil_consumption` double(20, 10) NULL DEFAULT NULL COMMENT '食用油消耗量',
  `source_discrip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '污染源描述',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `year`(`year`, `county_id`, `scccode`) USING BTREE,
  INDEX `county_id`(`county_id`) USING BTREE,
  INDEX `scccode`(`scccode`) USING BTREE,
  CONSTRAINT `repast_family_ibfk_1` FOREIGN KEY (`county_id`) REFERENCES `county` (`COUNTY_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `repast_family_ibfk_2` FOREIGN KEY (`scccode`) REFERENCES `scc` (`scc`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for road_move
-- ----------------------------
DROP TABLE IF EXISTS `road_move`;
CREATE TABLE `road_move`  (
  `id` int(3) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `scccode` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'SCC编码',
  `source_discrip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '污染源描述信息',
  `year` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '年份',
  `county_city` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '市级编码',
  `county_id` char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '区县编码',
  `average_mile` double(20, 10) NULL DEFAULT 0.0000000000 COMMENT '机动车的年均行使里程(公里/辆)',
  `car_amount` double(20, 10) NULL DEFAULT 0.0000000000 COMMENT '机动车保有量（辆）',
  `car_speed` double(20, 10) NULL DEFAULT 0.0000000000 COMMENT '机动车运行平均行驶速度（Km/小时）',
  `fuel_type` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '燃料类型(燃料类型下拉选择)',
  `car_fuelamount` double(20, 10) NULL DEFAULT 0.0000000000 COMMENT '道路机动车年燃料消耗量（吨）',
  `orvr_percentage` double(20, 10) UNSIGNED NULL DEFAULT 0.0000000000 COMMENT '带有ORVR技术的车辆比例',
  `average_samount` double(20, 10) NULL DEFAULT 0.0000000000 COMMENT '年均含硫量（质量分数百万分之一，即ppm）',
  `pm25_emission` double(20, 10) NULL DEFAULT 0.0000000000 COMMENT 'PM2.5排放量',
  `pm10_emission` double(20, 10) NULL DEFAULT 0.0000000000 COMMENT 'PM10排放量',
  `oc_emission` double(20, 10) NULL DEFAULT 0.0000000000 COMMENT 'Oc排放量',
  `ec_emission` double(20, 10) NULL DEFAULT 0.0000000000 COMMENT 'Ec排放量(相当于BC)',
  `so2_emission` double(20, 10) NULL DEFAULT 0.0000000000 COMMENT 'So2排放量',
  `nox_emission` double(20, 10) NULL DEFAULT 0.0000000000 COMMENT 'nox排放量',
  `co_emission` double(20, 10) NULL DEFAULT 0.0000000000 COMMENT 'co排放量',
  `nh3_emission` double(20, 10) NULL DEFAULT 0.0000000000 COMMENT 'Nh3排放量',
  `vocs_emission` double(20, 10) NULL DEFAULT 0.0000000000 COMMENT 'vocs排放量',
  `flag` int(4) NULL DEFAULT 0 COMMENT '表示scc的排放因子用理论值还是实际值',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `scccode_2`(`scccode`, `county_id`, `year`) USING BTREE,
  INDEX `sss`(`county_id`) USING BTREE,
  INDEX `scccode`(`scccode`) USING BTREE,
  CONSTRAINT `sss` FOREIGN KEY (`county_id`) REFERENCES `county` (`COUNTY_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `xienanxie` FOREIGN KEY (`scccode`) REFERENCES `scc` (`scc`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 37409 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for road_pave
-- ----------------------------
DROP TABLE IF EXISTS `road_pave`;
CREATE TABLE `road_pave`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `year` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '年份',
  `county_id` char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '区县',
  `asphalt` double(20, 10) NULL DEFAULT NULL COMMENT '沥青用量',
  `scccode` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '天津scc编码',
  `pm10_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'pm10_emission',
  `pm25_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'PM25排放量',
  `voc_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'VOC排放量',
  `nh3_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'NH3排放量',
  `so2_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'SO2排放量',
  `co_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'CO排放量',
  `oc_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'OC排放量',
  `bc_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'BC排放量',
  `nox_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'NOX排放量',
  `flagd` tinyint(4) NULL DEFAULT NULL COMMENT '排放因子标志位',
  `source_descrip` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述信息',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `year`(`year`, `county_id`, `scccode`) USING BTREE,
  INDEX `countyid`(`county_id`) USING BTREE,
  INDEX `scccode`(`scccode`) USING BTREE,
  CONSTRAINT `road_pave_ibfk_1` FOREIGN KEY (`county_id`) REFERENCES `county` (`COUNTY_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `road_pave_ibfk_2` FOREIGN KEY (`scccode`) REFERENCES `scc` (`scc`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for role_audit
-- ----------------------------
DROP TABLE IF EXISTS `role_audit`;
CREATE TABLE `role_audit`  (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NULL DEFAULT NULL,
  `status_id` int(4) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu`  (
  `role_id` int(11) NOT NULL,
  `menu_id` int(11) NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for role_operator
-- ----------------------------
DROP TABLE IF EXISTS `role_operator`;
CREATE TABLE `role_operator`  (
  `role_id` int(11) NULL DEFAULT NULL,
  `operator_id` int(11) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色-操作关系表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for rongji_product
-- ----------------------------
DROP TABLE IF EXISTS `rongji_product`;
CREATE TABLE `rongji_product`  (
  `id` int(14) NOT NULL AUTO_INCREMENT,
  `nk_no` int(14) NOT NULL COMMENT '编号',
  `factory_id` int(14) NULL DEFAULT NULL COMMENT '企业ID',
  `activities_category` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '生产活动类别a',
  `name_category` char(3) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '产品名称/类别b',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品备注',
  `drainage_process` char(3) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '生产/排污工艺d',
  `uint` varchar(14) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '计量单位e',
  `annual_output` double(14, 6) NULL DEFAULT NULL COMMENT '年产量',
  `scc_code` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'scc编码',
  `nox` double(8, 2) NULL DEFAULT NULL,
  `co` double(8, 2) NULL DEFAULT NULL,
  `pm10` double(8, 2) NULL DEFAULT NULL,
  `pm25` double(8, 2) NULL DEFAULT NULL,
  `pm` double(8, 2) NULL DEFAULT NULL,
  `so2` double(8, 2) NULL DEFAULT NULL,
  `voc` double(18, 8) NULL DEFAULT NULL,
  `nh3` double(8, 2) NULL DEFAULT NULL,
  `oc` double(8, 2) NULL DEFAULT NULL,
  `bc` double(8, 2) NULL DEFAULT NULL,
  `Jan_useamount` double(15, 4) NULL DEFAULT NULL,
  `Feb_useamount` double(15, 4) NULL DEFAULT NULL,
  `Mar_useamount` double(15, 4) NULL DEFAULT NULL,
  `Apr_useamount` double(15, 4) NULL DEFAULT NULL,
  `May_useamount` double(15, 4) NULL DEFAULT NULL,
  `June_useamount` double(15, 4) NULL DEFAULT NULL,
  `July_useamount` double(15, 4) NULL DEFAULT NULL,
  `aug_useamount` double(15, 4) NULL DEFAULT NULL,
  `sept_useamount` double(15, 4) NULL DEFAULT NULL,
  `oct_use_amount` double(15, 4) NULL DEFAULT NULL,
  `nov_useamount` double(15, 4) NULL DEFAULT NULL,
  `dec_useamount` double(15, 4) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 240 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for rongji_raw
-- ----------------------------
DROP TABLE IF EXISTS `rongji_raw`;
CREATE TABLE `rongji_raw`  (
  `id` int(14) NOT NULL AUTO_INCREMENT,
  `nk_no` int(14) NOT NULL COMMENT '溶剂原料编号',
  `factory_id` int(14) NOT NULL COMMENT '企业ID',
  `mname` varchar(14) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '原辅料名称',
  `musage` double(14, 2) NULL DEFAULT NULL COMMENT '年使用量',
  `unit` varchar(14) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '计量单位',
  `scc2` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '生产活动类别a',
  `scc3` char(3) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '产品名称/类别b',
  `scc4` char(3) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `scc_code` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'scc编码',
  `pm10` double(8, 2) NULL DEFAULT NULL,
  `pm25` double(8, 2) NULL DEFAULT NULL,
  `nox` double(8, 2) NULL DEFAULT NULL,
  `co` double(8, 2) NULL DEFAULT NULL,
  `pm` double(8, 2) NULL DEFAULT NULL,
  `so2` double(8, 2) NULL DEFAULT NULL,
  `voc` double(8, 2) NULL DEFAULT NULL,
  `nh3` double(8, 2) NULL DEFAULT NULL,
  `oc` double(8, 2) NULL DEFAULT NULL,
  `bc` double(8, 2) NULL DEFAULT NULL,
  `gas_no` int(5) NULL DEFAULT NULL COMMENT '集气设施编号',
  `gas_pre` double(5, 2) NULL DEFAULT NULL COMMENT '集气效率',
  `gas_vocs` double(5, 2) NULL DEFAULT NULL COMMENT 'VOCs含量(%)',
  `treat_no` int(5) NULL DEFAULT NULL COMMENT '治理设施编号',
  `treat_pre` double(5, 2) NULL DEFAULT NULL COMMENT '治理设施VOCS去除率%',
  `Jan_useamount` double(15, 4) NULL DEFAULT NULL,
  `Feb_useamount` double(15, 4) NULL DEFAULT NULL,
  `Mar_useamount` double(15, 4) NULL DEFAULT NULL,
  `Apr_useamount` double(15, 4) NULL DEFAULT NULL,
  `May_useamount` double(15, 4) NULL DEFAULT NULL,
  `June_useamount` double(15, 4) NULL DEFAULT NULL,
  `July_useamount` double(15, 4) NULL DEFAULT NULL,
  `aug_useamount` double(15, 4) NULL DEFAULT NULL,
  `sept_useamount` double(15, 4) NULL DEFAULT NULL,
  `oct_use_amount` double(15, 4) NULL DEFAULT NULL,
  `nov_useamount` double(15, 4) NULL DEFAULT NULL,
  `dec_useamount` double(15, 4) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 568 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '工艺过程源和溶剂使用源的设备原料信息' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for scattered_coal
-- ----------------------------
DROP TABLE IF EXISTS `scattered_coal`;
CREATE TABLE `scattered_coal`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `scc_code` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT 'scc编码',
  `year` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '年份',
  `county_id` char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '区县编码',
  `activity_level` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '活动水平',
  `fuel_metering_unit` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '活动水平单位',
  `activity_level_num` double(18, 10) NULL DEFAULT NULL COMMENT '活动水平数量',
  `control_measure` char(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '控制措施',
  `sulfur_content` double(18, 10) NULL DEFAULT NULL COMMENT '燃料硫分（%）',
  `ash_content` double(18, 10) NULL DEFAULT NULL COMMENT '燃料灰分（%）',
  `pm25_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'pm25排放量',
  `pm10_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'pm10排放量',
  `co_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'co排放量',
  `voc_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'voc排放量',
  `so2_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'so2排放量',
  `nox_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'nox排放量',
  `nh3_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'nh3排放量',
  `oc_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'oc排放量',
  `bc_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'bc排放量',
  `source_description` char(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `county_id`(`county_id`) USING BTREE,
  INDEX `scc`(`scc_code`) USING BTREE,
  CONSTRAINT `scattered_coal_ibfk_1` FOREIGN KEY (`county_id`) REFERENCES `county` (`COUNTY_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `scattered_coal_ibfk_2` FOREIGN KEY (`scc_code`) REFERENCES `scc` (`scc`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 230 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for scc
-- ----------------------------
DROP TABLE IF EXISTS `scc`;
CREATE TABLE `scc`  (
  `scc` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `epa_scc` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gridid_9k` char(3) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gridid_3k` char(3) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nox` double(20, 10) NULL DEFAULT 0.0000000000,
  `so2` double(20, 10) NULL DEFAULT 0.0000000000,
  `nh3` double(20, 10) NULL DEFAULT 0.0000000000,
  `vocs` double(20, 10) NULL DEFAULT 0.0000000000,
  `co` double(20, 10) NULL DEFAULT 0.0000000000,
  `pm10` double(20, 10) NULL DEFAULT 0.0000000000,
  `pm25` double(20, 10) NULL DEFAULT 0.0000000000,
  `oc` double(20, 10) NULL DEFAULT 0.0000000000,
  `pm` double(20, 10) UNSIGNED NULL DEFAULT 0.0000000000,
  `bc` double(20, 10) NULL DEFAULT 0.0000000000,
  `monthid` int(11) NULL DEFAULT NULL,
  `nkweekid` int(11) NULL DEFAULT NULL,
  `nkdayid` int(11) NULL DEFAULT NULL,
  `nknoxid` int(11) NULL DEFAULT NULL,
  `nkvocid` int(11) NULL DEFAULT NULL,
  `nkpm25id` int(11) NULL DEFAULT NULL,
  `ec` double(20, 10) NULL DEFAULT 0.0000000000,
  `unit` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nox_real` double(20, 10) NULL DEFAULT 0.0000000000,
  `so2_real` double(20, 10) NULL DEFAULT 0.0000000000,
  `nh3_real` double(20, 10) NULL DEFAULT 0.0000000000,
  `vocs_real` double(20, 10) NULL DEFAULT 0.0000000000,
  `co_real` double(20, 10) NULL DEFAULT 0.0000000000,
  `pm10_real` double(20, 10) NULL DEFAULT 0.0000000000,
  `pm25_real` double(20, 10) NULL DEFAULT 0.0000000000,
  `bc_real` double(20, 10) NULL DEFAULT 0.0000000000,
  `oc_real` double(20, 10) NULL DEFAULT 0.0000000000,
  `flag` bit(1) NULL DEFAULT NULL,
  PRIMARY KEY (`scc`) USING BTREE,
  UNIQUE INDEX `scc`(`scc`) USING BTREE,
  UNIQUE INDEX `scc_2`(`scc`) USING BTREE,
  INDEX `mouthid`(`monthid`) USING BTREE,
  INDEX `nkweekid`(`nkweekid`) USING BTREE,
  INDEX `nkdayid`(`nkdayid`) USING BTREE,
  INDEX `nknoxid`(`nknoxid`) USING BTREE,
  INDEX `nkvocid`(`nkvocid`) USING BTREE,
  INDEX `nkpm25id`(`nkpm25id`) USING BTREE,
  INDEX `gridassign_id`(`gridid_3k`) USING BTREE,
  INDEX `gridid_9k`(`gridid_9k`) USING BTREE,
  CONSTRAINT `scc_ibfk_10` FOREIGN KEY (`nkweekid`) REFERENCES `activity_w` (`week_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `scc_ibfk_11` FOREIGN KEY (`nkdayid`) REFERENCES `activity_d` (`day_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `scc_ibfk_12` FOREIGN KEY (`monthid`) REFERENCES `activity_m` (`month_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `scc_ibfk_4` FOREIGN KEY (`nknoxid`) REFERENCES `profile_nox` (`NOX_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `scc_ibfk_5` FOREIGN KEY (`nkvocid`) REFERENCES `profile_voc` (`VOC_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `scc_ibfk_6` FOREIGN KEY (`nkpm25id`) REFERENCES `profile_pm25` (`PM25_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `scc_ibfk_7` FOREIGN KEY (`gridid_9k`) REFERENCES `gridassignid` (`grid_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `scc_ibfk_8` FOREIGN KEY (`gridid_3k`) REFERENCES `gridassignid` (`grid_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for scc_1
-- ----------------------------
DROP TABLE IF EXISTS `scc_1`;
CREATE TABLE `scc_1`  (
  `scc_1` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `description` char(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`scc_1`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for scc_2
-- ----------------------------
DROP TABLE IF EXISTS `scc_2`;
CREATE TABLE `scc_2`  (
  `scc_1` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `scc_2` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `description` char(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `scc_1`(`scc_1`, `scc_2`) USING BTREE,
  INDEX `id`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1165 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for scc_3
-- ----------------------------
DROP TABLE IF EXISTS `scc_3`;
CREATE TABLE `scc_3`  (
  `scc_1` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `scc_2` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `scc_3` char(3) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `description` char(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `scc_1`(`scc_1`, `scc_2`, `scc_3`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3256 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for scc_4
-- ----------------------------
DROP TABLE IF EXISTS `scc_4`;
CREATE TABLE `scc_4`  (
  `scc_1` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `scc_2` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `scc_3` char(3) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `scc_4` char(3) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `description` char(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19501 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for scc_describe
-- ----------------------------
DROP TABLE IF EXISTS `scc_describe`;
CREATE TABLE `scc_describe`  (
  `scc_code` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `description` varchar(163) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`scc_code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sh_effluentemission
-- ----------------------------
DROP TABLE IF EXISTS `sh_effluentemission`;
CREATE TABLE `sh_effluentemission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `year` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '年份',
  `factory_id` int(11) NOT NULL COMMENT '企业编码',
  `activity_note` char(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '活动水平备注',
  `activity` double(20, 10) NOT NULL COMMENT '活动水平',
  `activity_unit` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '活动水平单位',
  `voc_efficency` double(10, 5) NOT NULL COMMENT 'voc控制效率',
  `pm10_emission` double(20, 10) NULL DEFAULT 0.0000000000 COMMENT 'pm10排放量',
  `pm25_emission` double(20, 10) NULL DEFAULT 0.0000000000 COMMENT 'pm25排放量',
  `so2_emission` double(20, 10) NULL DEFAULT 0.0000000000 COMMENT 'so2排放量',
  `nox_emission` double(20, 10) NULL DEFAULT 0.0000000000 COMMENT 'nox排放量',
  `voc_emission` double(20, 10) NULL DEFAULT 0.0000000000 COMMENT 'voc排放量',
  `nh3_emission` double(20, 10) NULL DEFAULT 0.0000000000 COMMENT 'nh3排放量',
  `co_emission` double(20, 10) NULL DEFAULT 0.0000000000 COMMENT 'co排放量',
  `oc_emission` double(20, 10) NULL DEFAULT 0.0000000000 COMMENT 'oc排放量',
  `bc_emission` double(20, 10) NULL DEFAULT 0.0000000000 COMMENT 'bc排放量',
  `emission_unit` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '排放量单位',
  `scccode` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'scc编码',
  `source_discrip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '污染源描述信息',
  `flag` int(4) NULL DEFAULT 0 COMMENT '表示scc的排放因子用理论值还是实际值',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `factory_id`(`factory_id`) USING BTREE,
  INDEX `scccode`(`scccode`) USING BTREE,
  CONSTRAINT `sh_effluentEmission_ibfk_1` FOREIGN KEY (`factory_id`) REFERENCES `company` (`com_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `sh_effluentEmission_ibfk_2` FOREIGN KEY (`scccode`) REFERENCES `scc` (`scc`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sh_gasemission
-- ----------------------------
DROP TABLE IF EXISTS `sh_gasemission`;
CREATE TABLE `sh_gasemission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `year` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '年份',
  `factory_id` int(11) NOT NULL COMMENT '企业编码',
  `gy_name` char(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '生产工艺名称',
  `activity_note` char(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '活动水平备注',
  `density` double(10, 5) NULL DEFAULT NULL,
  `activity` double(20, 10) NOT NULL COMMENT '活动水平',
  `activity_unit` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '活动水平单位',
  `efficency` double(10, 5) NOT NULL COMMENT '处理装置效率',
  `pm10_emission` double(20, 10) NULL DEFAULT 0.0000000000 COMMENT 'pm10排放量',
  `pm25_emission` double(20, 10) NULL DEFAULT 0.0000000000 COMMENT 'pm25排放量',
  `so2_emission` double(20, 10) NULL DEFAULT 0.0000000000 COMMENT 'so2排放量',
  `nox_emission` double(20, 10) NULL DEFAULT 0.0000000000 COMMENT 'nox排放量',
  `voc_emission` double(20, 10) NULL DEFAULT 0.0000000000 COMMENT 'voc排放量',
  `nh3_emission` double(20, 10) NULL DEFAULT 0.0000000000 COMMENT 'nh3排放量',
  `co_emission` double(20, 10) NULL DEFAULT 0.0000000000 COMMENT 'co排放量',
  `oc_emission` double(20, 10) NULL DEFAULT 0.0000000000 COMMENT 'oc排放量',
  `bc_emission` double(20, 10) NULL DEFAULT 0.0000000000 COMMENT 'bc排放量',
  `emission_unit` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '排放量单位',
  `scccode` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'scc编码',
  `source_discrip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '污染源描述信息',
  `flag` int(4) NULL DEFAULT 0 COMMENT '表示scc的排放因子用理论值还是实际值',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `factory_id`(`factory_id`) USING BTREE,
  INDEX `scccode`(`scccode`) USING BTREE,
  CONSTRAINT `sh_gasEmission_ibfk_1` FOREIGN KEY (`factory_id`) REFERENCES `company` (`com_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `sh_gasEmission_ibfk_2` FOREIGN KEY (`scccode`) REFERENCES `scc` (`scc`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sh_sealpoint
-- ----------------------------
DROP TABLE IF EXISTS `sh_sealpoint`;
CREATE TABLE `sh_sealpoint`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `year` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '年份',
  `factory_id` int(14) NULL DEFAULT NULL COMMENT '企业编码',
  `unit_type` char(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单元类型',
  `activity` double(20, 10) NULL DEFAULT NULL COMMENT '活动水平',
  `activity_unit` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '活动水平单位',
  `scccode` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pm10_emission` double(20, 10) NULL DEFAULT NULL,
  `pm25_emission` double(20, 10) NULL DEFAULT NULL,
  `voc_emission` double(20, 10) NULL DEFAULT 0.0000000000 COMMENT 'voc排放量',
  `so2_emission` double(20, 10) NULL DEFAULT 0.0000000000 COMMENT 'so2排放量',
  `nh3_emission` double(20, 10) NULL DEFAULT 0.0000000000 COMMENT 'nh3排放量',
  `nox_emission` double(20, 10) NULL DEFAULT 0.0000000000 COMMENT 'nox排放量',
  `co_emission` double(20, 10) NULL DEFAULT 0.0000000000 COMMENT 'co排放量',
  `oc_emission` double(20, 10) NULL DEFAULT 0.0000000000 COMMENT 'oc排放量',
  `bc_emission` double(20, 10) NULL DEFAULT 0.0000000000 COMMENT 'bc排放量',
  `flag` int(4) NULL DEFAULT 0 COMMENT '标志计算排放量使用的是理论还是实际排放因子',
  `source_discrip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '污染源信息描述',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `factory_id`(`factory_id`) USING BTREE,
  INDEX `scccode`(`scccode`) USING BTREE,
  CONSTRAINT `sh_sealPoint_ibfk_1` FOREIGN KEY (`factory_id`) REFERENCES `company` (`com_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `sh_sealPoint_ibfk_2` FOREIGN KEY (`scccode`) REFERENCES `scc` (`scc`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sh_vocdeviceeffi
-- ----------------------------
DROP TABLE IF EXISTS `sh_vocdeviceeffi`;
CREATE TABLE `sh_vocdeviceeffi`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `year` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '年份',
  `factory_id` int(11) NOT NULL COMMENT '企业编码',
  `workshop_section` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工段',
  `gy_name` char(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '生产工艺名称',
  `exit_airVolume` double(20, 10) NULL DEFAULT 0.0000000000 COMMENT '出口风量',
  `annual_runtime` double(20, 10) NULL DEFAULT 0.0000000000 COMMENT '年运行小时数',
  `exit_concentration` double(20, 10) NOT NULL DEFAULT 0.0000000000 COMMENT '出口浓度',
  `efficency` double(10, 5) NULL DEFAULT NULL COMMENT '处理装置效率',
  `pm10_emission` double(20, 10) NULL DEFAULT 0.0000000000 COMMENT 'pm10排放量',
  `pm25_emission` double(20, 10) NULL DEFAULT 0.0000000000 COMMENT 'pm25排放量',
  `so2_emission` double(20, 10) NULL DEFAULT 0.0000000000 COMMENT 'so2排放量',
  `nox_emission` double(20, 10) NULL DEFAULT 0.0000000000 COMMENT 'nox排放量',
  `voc_emission` double(20, 10) NULL DEFAULT 0.0000000000 COMMENT 'voc排放量',
  `nh3_emission` double(20, 10) NULL DEFAULT 0.0000000000 COMMENT 'nh3排放量',
  `co_emission` double(20, 10) NULL DEFAULT 0.0000000000 COMMENT 'co排放量',
  `oc_emission` double(20, 10) NULL DEFAULT 0.0000000000 COMMENT 'oc排放量',
  `bc_emission` double(20, 10) NULL DEFAULT 0.0000000000 COMMENT 'bc排放量',
  `emission_unit` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '排放量单位',
  `scccode` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'scc编码',
  `source_discrip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '污染源描述信息',
  `flag` int(4) NULL DEFAULT 0 COMMENT '表示scc的排放因子用理论值还是实际值',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `factory_id`(`factory_id`) USING BTREE,
  INDEX `scccode`(`scccode`) USING BTREE,
  CONSTRAINT `sh_vocDeviceEffi_ibfk_1` FOREIGN KEY (`factory_id`) REFERENCES `company` (`com_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `sh_vocDeviceEffi_ibfk_2` FOREIGN KEY (`scccode`) REFERENCES `scc` (`scc`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for small_machinery
-- ----------------------------
DROP TABLE IF EXISTS `small_machinery`;
CREATE TABLE `small_machinery`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `year` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '年份',
  `county_id` char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '区县编码',
  `scc_code` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'scc编码',
  `source_descrip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'scc描述',
  `type` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型',
  `fuel_type` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '燃料类型',
  `holdings` int(20) NULL DEFAULT NULL COMMENT '保有量',
  `use_hours` double(18, 10) NULL DEFAULT NULL COMMENT '使用小时数',
  `fuel_annual_usage` double(18, 10) NULL DEFAULT NULL COMMENT '燃料年使用量',
  `fuel_sulfur_content` double(18, 10) NULL DEFAULT NULL COMMENT '燃料含硫率',
  `annal_average_mileage` double(18, 10) NULL DEFAULT NULL COMMENT '年平均行驶里程',
  `pm10_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'PM10排放量',
  `pm25_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'pm25排放量',
  `co_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'co排放量',
  `so2_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'so2排放量',
  `nox_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'nox排放量',
  `vocs_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'voc排放量',
  `bc_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'bc排放量',
  `oc_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'oc排放量',
  `nh3_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'nh3排放量',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `year`(`year`, `county_id`, `scc_code`, `type`) USING BTREE,
  INDEX `scc_engine`(`scc_code`) USING BTREE,
  INDEX `countyid_engine`(`county_id`) USING BTREE,
  CONSTRAINT `small_machinery_ibfk_1` FOREIGN KEY (`scc_code`) REFERENCES `scc` (`scc`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `small_machinery_ibfk_2` FOREIGN KEY (`county_id`) REFERENCES `county` (`COUNTY_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for source
-- ----------------------------
DROP TABLE IF EXISTS `source`;
CREATE TABLE `source`  (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `sourcename` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for status
-- ----------------------------
DROP TABLE IF EXISTS `status`;
CREATE TABLE `status`  (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `introduction` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for straw_compost
-- ----------------------------
DROP TABLE IF EXISTS `straw_compost`;
CREATE TABLE `straw_compost`  (
  `id` int(14) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `year` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '年份',
  `county_id` char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '区县编码',
  `scccode` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Scc编码',
  `source_descrip` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述信息',
  `activity_level` double(20, 10) NULL DEFAULT NULL COMMENT '活动水平',
  `pm10_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'Pm10排放量',
  `pm25_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'PM25排放量',
  `voc_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'VOC排放量',
  `nh3_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'NH3排放量',
  `so2_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'SO2排放量',
  `co_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'CO排放量',
  `oc_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'OC排放量',
  `bc_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'BC排放量',
  `nox_emission` double(20, 10) NULL DEFAULT NULL COMMENT 'NOX排放量',
  `flag` tinyint(4) NULL DEFAULT NULL COMMENT '排放因子标志位',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `year`(`year`, `county_id`, `scccode`) USING BTREE,
  INDEX `scccode`(`scccode`) USING BTREE,
  INDEX `county_id`(`county_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '农牧源-秸秆堆肥' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sulphurremove
-- ----------------------------
DROP TABLE IF EXISTS `sulphurremove`;
CREATE TABLE `sulphurremove`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `sulphur_remove_id` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sulphur_classify` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sulphur_method` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sulphur_remove_effi` double(7, 0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `operation` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作',
  `time` int(11) NULL DEFAULT NULL COMMENT '响应时间/耗时',
  `method` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求方法',
  `params` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求参数',
  `ip` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'IP',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 452 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '操作日志表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `modify_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tank_source
-- ----------------------------
DROP TABLE IF EXISTS `tank_source`;
CREATE TABLE `tank_source`  (
  `id` int(14) NOT NULL AUTO_INCREMENT COMMENT '储罐源信息id号',
  `year` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `scccode` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'SCCCODE',
  `source_discrip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `company_id` int(14) NULL DEFAULT NULL COMMENT '储罐所在的企业的id号，关联企业的信息',
  `t_id` int(14) NOT NULL DEFAULT 1 COMMENT '储罐的id号,储罐的编号,添加的时候检索企业目前有几个储罐，在原来的基础上加1',
  `tank_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '储罐名称',
  `tank_type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '储罐类型（固定罐0，浮顶罐1）',
  `material_type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '储罐的物料种类（石油0，有机物1）',
  `material_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '储罐具体的存储物料类型（原油，柴油，乙醇等,在另外一张表中存储，新增时需要查询表，给出对应的编号）',
  `emission` double(20, 10) NULL DEFAULT NULL,
  `flag` int(4) NOT NULL DEFAULT 0 COMMENT '标识scc因子用实际值还是理论值',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `year`(`year`, `scccode`, `company_id`, `t_id`) USING BTREE,
  INDEX `scccode`(`scccode`) USING BTREE,
  INDEX `company_id`(`company_id`) USING BTREE,
  CONSTRAINT `tank_source_ibfk_1` FOREIGN KEY (`scccode`) REFERENCES `scc` (`scc`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `tank_source_ibfk_2` FOREIGN KEY (`company_id`) REFERENCES `company` (`com_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 390 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for total_boiler
-- ----------------------------
DROP TABLE IF EXISTS `total_boiler`;
CREATE TABLE `total_boiler`  (
  `TBOILER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `FACTORY_ID` int(11) NOT NULL,
  `TBOILER_NUM` int(11) NULL DEFAULT NULL,
  `TBOILER_TONS` double(10, 4) NULL DEFAULT NULL,
  `TBOILER_FUNCTION_DEC` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `TBOILER_FUNCTION` char(3) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `TBOILER_STATUS` tinyint(2) NULL DEFAULT NULL,
  `CHIMNEY_NUM` int(5) NULL DEFAULT NULL,
  `TBOILER_FUELTYPE` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `TBOILER_FUELAUSAGE` double(18, 4) NULL DEFAULT NULL,
  `TBOILER_FUELUNIT` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `last_changed_time` datetime(6) NULL DEFAULT NULL,
  `last_checked_time` datetime(6) NULL DEFAULT NULL,
  `note` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Jan_useamount` double(15, 4) NULL DEFAULT NULL,
  `Feb_useamount` double(15, 4) NULL DEFAULT NULL,
  `Mar_useamount` double(15, 4) NULL DEFAULT NULL,
  `Apr_useamount` double(15, 4) NULL DEFAULT NULL,
  `May_useamount` double(15, 4) NULL DEFAULT NULL,
  `June_useamount` double(15, 4) NULL DEFAULT NULL,
  `July_useamount` double(15, 4) NULL DEFAULT NULL,
  `aug_useamount` double(15, 4) NULL DEFAULT NULL,
  `sept_useamount` double(15, 4) NULL DEFAULT NULL,
  `oct_use_amount` double(15, 4) NULL DEFAULT NULL,
  `nov_useamount` double(15, 4) NULL DEFAULT NULL,
  `dec_useamount` double(15, 4) NULL DEFAULT NULL,
  PRIMARY KEY (`TBOILER_ID`) USING BTREE,
  INDEX `FACTORY_ID`(`FACTORY_ID`) USING BTREE,
  INDEX `TBOILER_ID`(`TBOILER_ID`) USING BTREE,
  CONSTRAINT `total_boiler_ibfk_1` FOREIGN KEY (`FACTORY_ID`) REFERENCES `factory` (`factory_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1194 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = '固定燃烧源-锅炉总信息表，' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for total_grid_emission
-- ----------------------------
DROP TABLE IF EXISTS `total_grid_emission`;
CREATE TABLE `total_grid_emission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gridid` int(11) NULL DEFAULT NULL,
  `year` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `row` int(11) NULL DEFAULT NULL,
  `col` int(11) NULL DEFAULT NULL,
  `sourcetype` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pm` double(20, 8) NULL DEFAULT NULL,
  `pm25` double(20, 8) NULL DEFAULT NULL,
  `pm10` double(20, 8) NULL DEFAULT NULL,
  `so2` double(20, 8) NULL DEFAULT NULL,
  `nox` double(20, 8) NULL DEFAULT NULL,
  `nh3` double(20, 8) NULL DEFAULT NULL,
  `oc` double(20, 8) NULL DEFAULT NULL,
  `bc` double(20, 8) NULL DEFAULT NULL,
  `co` double(20, 8) NULL DEFAULT NULL,
  `hc` double(20, 8) NULL DEFAULT NULL,
  `voc` double(20, 8) NULL DEFAULT NULL,
  `no` double(20, 8) NULL DEFAULT NULL,
  `ec` double(20, 8) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 94455 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for total_kiln
-- ----------------------------
DROP TABLE IF EXISTS `total_kiln`;
CREATE TABLE `total_kiln`  (
  `fkilntotal_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增，生产工艺编号，工艺过程源生产过程总表',
  `factory_id` int(14) NULL DEFAULT NULL COMMENT '外键，工厂id号',
  `fuel_type` char(3) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '窑炉所用燃料类型对应SCC三级',
  `fkiln_num` int(5) NULL DEFAULT NULL COMMENT '设备的数目',
  `fkiln_unit` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '燃料年使用量单位',
  `fkiln_usage` double(10, 0) NULL DEFAULT NULL COMMENT '燃料年使用量',
  `fkiln_useful_dec` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `fkiln_useful` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '窑炉用途,对应SCC二级',
  `note` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '备注信息',
  `Jan_useamount` double(15, 4) NULL DEFAULT NULL,
  `Feb_useamount` double(15, 4) NULL DEFAULT NULL,
  `Mar_useamount` double(15, 4) NULL DEFAULT NULL,
  `Apr_useamount` double(15, 4) NULL DEFAULT NULL,
  `May_useamount` double(15, 4) NULL DEFAULT NULL,
  `June_useamount` double(15, 4) NULL DEFAULT NULL,
  `July_useamount` double(15, 4) NULL DEFAULT NULL,
  `aug_useamount` double(15, 4) NULL DEFAULT NULL,
  `sept_useamount` double(15, 4) NULL DEFAULT NULL,
  `oct_use_amount` double(15, 4) NULL DEFAULT NULL,
  `nov_useamount` double(15, 4) NULL DEFAULT NULL,
  `dec_useamount` double(15, 4) NULL DEFAULT NULL,
  PRIMARY KEY (`fkilntotal_id`) USING BTREE,
  INDEX `factory_id`(`factory_id`) USING BTREE,
  CONSTRAINT `total_kiln_ibfk_1` FOREIGN KEY (`factory_id`) REFERENCES `factory` (`factory_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 497 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = '窑炉总信息表；工艺过程源\r\n' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for total_productraw
-- ----------------------------
DROP TABLE IF EXISTS `total_productraw`;
CREATE TABLE `total_productraw`  (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `device_num` int(8) UNSIGNED ZEROFILL NOT NULL,
  `product_num` int(8) UNSIGNED ZEROFILL NOT NULL,
  `raw_num` int(8) UNSIGNED ZEROFILL NOT NULL,
  `factory_id` int(14) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `factory_id`(`factory_id`) USING BTREE,
  CONSTRAINT `total_productraw_ibfk_1` FOREIGN KEY (`factory_id`) REFERENCES `factory` (`factory_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1528 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '部分工艺过程源和溶剂使用源总信息表，使用scc1码进行区分' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for total_rongji
-- ----------------------------
DROP TABLE IF EXISTS `total_rongji`;
CREATE TABLE `total_rongji`  (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `product_num` int(8) UNSIGNED ZEROFILL NOT NULL,
  `raw_num` int(8) UNSIGNED ZEROFILL NOT NULL,
  `factory_id` int(14) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `factory_id`(`factory_id`) USING BTREE,
  CONSTRAINT `total_rongji_ibfk_1` FOREIGN KEY (`factory_id`) REFERENCES `factory` (`factory_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 805 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '部分工艺过程源和溶剂使用源总信息表，使用scc1码进行区分' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NULL DEFAULT NULL,
  `nickname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `real_name` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `work_phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone_number` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `notes` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `identity_file` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `fac_no` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `fac_no_2`(`fac_no`) USING BTREE,
  INDEX `role_id`(`role_id`) USING BTREE,
  INDEX `fac_no`(`fac_no`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24402 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = '前台填报用户信息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for xjconstructdust
-- ----------------------------
DROP TABLE IF EXISTS `xjconstructdust`;
CREATE TABLE `xjconstructdust`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '施工扬尘源编码',
  `year` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '年份',
  `com_id` int(14) NOT NULL COMMENT '企业id外键',
  `xjconstructid` int(11) NULL DEFAULT NULL COMMENT '施工工地编号',
  `scccode` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Scc编码',
  `construct_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '施工类型',
  `construct_stage` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '建筑施工阶段',
  `finish_area` double(20, 10) NULL DEFAULT NULL COMMENT '竣工面积',
  `thisyear_area` double(20, 10) NULL DEFAULT NULL COMMENT '当年施工面积',
  `plan_constructarea` double(20, 10) NULL DEFAULT NULL COMMENT '规划施工面积',
  `months` int(6) NULL DEFAULT 0 COMMENT '施工活跃月份数',
  `ec10factor` double(18, 10) NULL DEFAULT NULL COMMENT 'pm10的排放速率',
  `controlname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '控制名称',
  `longitude` double(20, 8) NULL DEFAULT NULL COMMENT '经度',
  `latitude` double(20, 8) NULL DEFAULT NULL COMMENT '纬度',
  `pm25_emission` double(20, 10) NULL DEFAULT 0.0000000000 COMMENT 'pm2.5排放量',
  `pm10_emission` double(20, 10) NULL DEFAULT 0.0000000000 COMMENT 'pm10排放量',
  `voc_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'voc排放量',
  `nh3_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'nh3排放量',
  `so2_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'so2排放量',
  `co_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'co排放量',
  `oc_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'oc排放量',
  `bc_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'bc排放量',
  `nox_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'nox排放量',
  `pm25_max` double(18, 10) NULL DEFAULT NULL COMMENT 'pm2.5的最大控制措施',
  `pm10_max` double(18, 10) NULL DEFAULT NULL COMMENT 'pm10的最大控制措施',
  `voc_max` double(18, 10) NULL DEFAULT NULL COMMENT 'voc的最大控制措施',
  `nh3_max` double(18, 10) NULL DEFAULT NULL COMMENT 'nh3的最大控制措施',
  `so2_max` double(18, 10) NULL DEFAULT NULL COMMENT 'so2的最大控制措施',
  `co_max` double(18, 10) NULL DEFAULT NULL COMMENT 'co的最大控制措施',
  `oc_max` double(18, 10) NULL DEFAULT NULL COMMENT 'oc的最大控制措施',
  `bc_max` double(18, 10) NULL DEFAULT NULL COMMENT 'bc的最大控制措施',
  `nox_max` double(18, 10) NULL DEFAULT NULL COMMENT 'nox的最大控制措施',
  `pm25_unit` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'pm2.5的单位',
  `pm10_unit` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'pm10单位',
  `voc_unit` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'voc的单位',
  `nh3_unit` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'nh3的单位',
  `so2_unit` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'so2的单位',
  `co_unit` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'co的单位',
  `oc_unit` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'oc的单位',
  `bc_unit` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'bc的单位',
  `nox_unit` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'nox的单位',
  `scc_describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'scc拼接描述',
  `flag` int(11) NULL DEFAULT 0 COMMENT 'scc描述',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `year`(`year`, `com_id`, `scccode`, `xjconstructid`) USING BTREE,
  INDEX `com_id`(`com_id`) USING BTREE,
  INDEX `scccode`(`scccode`) USING BTREE,
  CONSTRAINT `xjconstructdust_ibfk_1` FOREIGN KEY (`com_id`) REFERENCES `company` (`com_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `xjconstructdust_ibfk_2` FOREIGN KEY (`scccode`) REFERENCES `scc` (`scc`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1163 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '扬尘源-施工扬尘源' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for xjcydust_load
-- ----------------------------
DROP TABLE IF EXISTS `xjcydust_load`;
CREATE TABLE `xjcydust_load`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `load_id` int(11) NOT NULL COMMENT '装卸堆场的编号',
  `year` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `com_id` int(11) NOT NULL,
  `material_water` double(20, 10) NULL DEFAULT NULL COMMENT '物料含水率',
  `material_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '物料种类，用于物料含水率查询',
  `material_load` int(10) NULL DEFAULT NULL COMMENT '物料装卸量',
  `load_num` int(10) NULL DEFAULT 1 COMMENT '年装卸次数',
  `mload_unit` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '物料装卸量单位',
  `uwind_value` double(10, 6) NULL DEFAULT NULL COMMENT '地表平均风速，季节性',
  `controlname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `scccode` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pm25_emission` double(20, 10) NULL DEFAULT 0.0000000000 COMMENT 'pm2.5排放量',
  `pm10_emission` double(20, 10) NULL DEFAULT 0.0000000000 COMMENT 'pm10排放量',
  `voc_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'voc排放量',
  `nh3_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'nh3排放量',
  `so2_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'so2排放量',
  `co_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'co排放量',
  `oc_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'oc排放量',
  `bc_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'bc排放量',
  `nox_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'nox排放量',
  `pm25_max` double(18, 10) NULL DEFAULT NULL COMMENT 'pm2.5的最大控制措施',
  `pm10_max` double(18, 10) NULL DEFAULT NULL COMMENT 'pm10的最大控制措施',
  `voc_max` double(18, 10) NULL DEFAULT NULL COMMENT 'voc的最大控制措施',
  `nh3_max` double(18, 10) NULL DEFAULT NULL COMMENT 'nh3的最大控制措施',
  `so2_max` double(18, 10) NULL DEFAULT NULL COMMENT 'so2的最大控制措施',
  `co_max` double(18, 10) NULL DEFAULT NULL COMMENT 'co的最大控制措施',
  `oc_max` double(18, 10) NULL DEFAULT NULL COMMENT 'oc的最大控制措施',
  `bc_max` double(18, 10) NULL DEFAULT NULL COMMENT 'bc的最大控制措施',
  `nox_max` double(18, 10) NULL DEFAULT NULL COMMENT 'nox的最大控制措施',
  `pm25_unit` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'pm2.5的单位',
  `pm10_unit` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'pm10单位',
  `voc_unit` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'voc的单位',
  `nh3_unit` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'nh3的单位',
  `so2_unit` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'so2的单位',
  `co_unit` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'co的单位',
  `oc_unit` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'oc的单位',
  `bc_unit` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'bc的单位',
  `nox_unit` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'nox的单位',
  `scc_describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'scc拼接描述',
  `flag` int(11) NULL DEFAULT 0 COMMENT 'scc描述',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `load_id`(`load_id`, `year`, `com_id`, `scccode`) USING BTREE,
  INDEX `scccode`(`scccode`) USING BTREE,
  INDEX `com_id`(`com_id`) USING BTREE,
  CONSTRAINT `xjcydust_load_ibfk_2` FOREIGN KEY (`scccode`) REFERENCES `scc` (`scc`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `xjcydust_load_ibfk_3` FOREIGN KEY (`com_id`) REFERENCES `company` (`com_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 450 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '扬尘源-堆场扬尘源-装卸' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for xjcydust_stack
-- ----------------------------
DROP TABLE IF EXISTS `xjcydust_stack`;
CREATE TABLE `xjcydust_stack`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `com_id` int(11) NULL DEFAULT NULL,
  `stack_id` int(11) NOT NULL COMMENT '风蚀堆场编号',
  `year` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '年份',
  `sarea` int(11) NULL DEFAULT NULL COMMENT '料堆表面积，默认平方米',
  `material_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '物料种类',
  `windf_thresh` double(20, 10) NULL DEFAULT NULL COMMENT '阈值摩擦风速',
  `wind_friction` double(20, 10) NULL DEFAULT NULL COMMENT '摩擦风速',
  `ground_rough` double(20, 10) NULL DEFAULT NULL COMMENT '地面粗糙度',
  `material_rough` double(20, 10) NULL DEFAULT NULL COMMENT '堆场表面粗糙度，默认单位米',
  `ground_windhigh` double(20, 10) NULL DEFAULT NULL COMMENT '地表风速检测高度',
  `m_windnum` int(10) NULL DEFAULT 1 COMMENT '堆料每年受扰动次数',
  `ground_wind` double(20, 10) NULL DEFAULT NULL COMMENT '地表平均风速，季节性',
  `controlname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `scccode` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `flag` int(11) NULL DEFAULT 0 COMMENT '使用的是理论因子还是实测因子',
  `pm25_emission` double(20, 10) NULL DEFAULT 0.0000000000 COMMENT 'pm2.5排放量',
  `pm10_emission` double(20, 10) NULL DEFAULT 0.0000000000 COMMENT 'pm10排放量',
  `voc_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'voc排放量',
  `nh3_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'nh3排放量',
  `so2_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'so2排放量',
  `co_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'co排放量',
  `oc_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'oc排放量',
  `bc_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'bc排放量',
  `nox_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'nox排放量',
  `pm25_max` double(18, 10) NULL DEFAULT NULL COMMENT 'pm2.5的最大控制措施',
  `pm10_max` double(18, 10) NULL DEFAULT NULL COMMENT 'pm10的最大控制措施',
  `voc_max` double(18, 10) NULL DEFAULT NULL COMMENT 'voc的最大控制措施',
  `nh3_max` double(18, 10) NULL DEFAULT NULL COMMENT 'nh3的最大控制措施',
  `so2_max` double(18, 10) NULL DEFAULT NULL COMMENT 'so2的最大控制措施',
  `co_max` double(18, 10) NULL DEFAULT NULL COMMENT 'co的最大控制措施',
  `oc_max` double(18, 10) NULL DEFAULT NULL COMMENT 'oc的最大控制措施',
  `bc_max` double(18, 10) NULL DEFAULT NULL COMMENT 'bc的最大控制措施',
  `nox_max` double(18, 10) NULL DEFAULT NULL COMMENT 'nox的最大控制措施',
  `pm25_unit` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'pm2.5的单位',
  `pm10_unit` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'pm10单位',
  `voc_unit` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'voc的单位',
  `nh3_unit` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'nh3的单位',
  `so2_unit` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'so2的单位',
  `co_unit` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'co的单位',
  `oc_unit` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'oc的单位',
  `bc_unit` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'bc的单位',
  `nox_unit` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'nox的单位',
  `scc_describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'scc拼接描述',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `com_id`(`com_id`, `stack_id`, `year`, `scccode`) USING BTREE,
  INDEX `scccode`(`scccode`) USING BTREE,
  CONSTRAINT `xjcydust_stack_ibfk_1` FOREIGN KEY (`com_id`) REFERENCES `company` (`com_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `xjcydust_stack_ibfk_2` FOREIGN KEY (`scccode`) REFERENCES `scc` (`scc`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 450 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '扬尘源-堆场扬尘源-堆放\r\n' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for xjroaddust
-- ----------------------------
DROP TABLE IF EXISTS `xjroaddust`;
CREATE TABLE `xjroaddust`  (
  `rd_id` int(11) NOT NULL AUTO_INCREMENT,
  `year` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '年份',
  `county_id` char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '区县编号',
  `pathname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '道路名称',
  `scccode` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'Scc编码',
  `ispave` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '道路是否铺装',
  `roadtype` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '道路类型',
  `pathlength` double(20, 10) NULL DEFAULT NULL COMMENT '道路长度',
  `averwidth` double(20, 10) NULL DEFAULT NULL COMMENT '道路宽度',
  `averweight` double(20, 10) NULL DEFAULT NULL COMMENT '平均车重',
  `carflow` double(20, 10) NULL DEFAULT NULL COMMENT '车流量',
  `averspeed` double(20, 10) NULL DEFAULT NULL COMMENT '平均车速',
  `dirtratio` double(12, 6) NULL DEFAULT NULL COMMENT '道路表面有效积尘率',
  `waterratio` double(12, 6) NULL DEFAULT NULL COMMENT '道路积尘含水率',
  `roadload` double(12, 6) NULL DEFAULT NULL COMMENT '道路积尘负荷',
  `controlname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '控制措施',
  `pm25_emission` double(20, 5) NULL DEFAULT 0.00000 COMMENT 'pm2.5排放量',
  `pm10_emission` double(20, 5) NULL DEFAULT 0.00000 COMMENT 'pm10排放量',
  `voc_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'voc排放量',
  `nh3_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'nh3排放量',
  `so2_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'so2排放量',
  `co_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'co排放量',
  `oc_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'oc排放量',
  `bc_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'bc排放量',
  `nox_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'nox排放量',
  `pm25_max` double(18, 10) NULL DEFAULT NULL COMMENT 'pm2.5的最大控制措施',
  `pm10_max` double(18, 10) NULL DEFAULT NULL COMMENT 'pm10的最大控制措施',
  `voc_max` double(18, 10) NULL DEFAULT NULL COMMENT 'voc的最大控制措施',
  `nh3_max` double(18, 10) NULL DEFAULT NULL COMMENT 'nh3的最大控制措施',
  `so2_max` double(18, 10) NULL DEFAULT NULL COMMENT 'so2的最大控制措施',
  `co_max` double(18, 10) NULL DEFAULT NULL COMMENT 'co的最大控制措施',
  `oc_max` double(18, 10) NULL DEFAULT NULL COMMENT 'oc的最大控制措施',
  `bc_max` double(18, 10) NULL DEFAULT NULL COMMENT 'bc的最大控制措施',
  `nox_max` double(18, 10) NULL DEFAULT NULL COMMENT 'nox的最大控制措施',
  `pm25_unit` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'pm2.5的单位',
  `pm10_unit` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'pm10单位',
  `voc_unit` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'voc的单位',
  `nh3_unit` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'nh3的单位',
  `so2_unit` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'so2的单位',
  `co_unit` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'co的单位',
  `oc_unit` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'oc的单位',
  `bc_unit` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'bc的单位',
  `nox_unit` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'nox的单位',
  `nodustday` int(11) NULL DEFAULT NULL COMMENT '不起尘天数',
  `scc_describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'scc拼接描述',
  `flag` int(11) NULL DEFAULT 0 COMMENT '默认为0 ，实际值为1',
  PRIMARY KEY (`rd_id`) USING BTREE,
  UNIQUE INDEX `year`(`year`, `county_id`, `scccode`) USING BTREE,
  INDEX `county_id`(`county_id`) USING BTREE,
  INDEX `scccode`(`scccode`) USING BTREE,
  CONSTRAINT `xjroaddust_ibfk_1` FOREIGN KEY (`county_id`) REFERENCES `county` (`COUNTY_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `xjroaddust_ibfk_2` FOREIGN KEY (`scccode`) REFERENCES `scc` (`scc`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 195 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for xjsoildust
-- ----------------------------
DROP TABLE IF EXISTS `xjsoildust`;
CREATE TABLE `xjsoildust`  (
  `sd_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '土壤扬尘id',
  `scccode` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'SCC编码',
  `county_id` char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '区县编号',
  `sd_year` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '年份',
  `sd_takemeasures` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '采取的控制措施',
  `sd_utype` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '土地利用类型',
  `sd_soiltype` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '土质类型',
  `sd_area` double(30, 5) NULL DEFAULT NULL COMMENT '土壤扬尘源面积',
  `soilindexpm25` double(18, 10) NULL DEFAULT NULL COMMENT 'pm2.5土壤风蚀指数',
  `soilindexpm10` double(18, 10) NULL DEFAULT NULL COMMENT 'pm10土壤风蚀指数',
  `surindex` double(18, 10) NULL DEFAULT NULL COMMENT '地表粗糙因子',
  `noindex` double(18, 10) NULL DEFAULT NULL COMMENT '无屏蔽宽度因子',
  `pindex` double(10, 4) NULL DEFAULT NULL COMMENT '植被覆盖因子',
  `pm25_emission` double(20, 5) NULL DEFAULT 0.00000 COMMENT 'pm2.5排放量',
  `pm10_emission` double(20, 5) NULL DEFAULT 0.00000 COMMENT 'pm10排放量',
  `voc_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'voc排放量',
  `nh3_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'nh3排放量',
  `so2_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'so2排放量',
  `co_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'co排放量',
  `oc_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'oc排放量',
  `bc_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'bc排放量',
  `nox_emission` double(18, 10) NULL DEFAULT 0.0000000000 COMMENT 'nox排放量',
  `pm25_max` double(18, 10) NULL DEFAULT NULL COMMENT 'pm2.5的最大控制措施',
  `pm10_max` double(18, 10) NULL DEFAULT NULL COMMENT 'pm10的最大控制措施',
  `voc_max` double(18, 10) NULL DEFAULT NULL COMMENT 'voc的最大控制措施',
  `nh3_max` double(18, 10) NULL DEFAULT NULL COMMENT 'nh3的最大控制措施',
  `so2_max` double(18, 10) NULL DEFAULT NULL COMMENT 'so2的最大控制措施',
  `co_max` double(18, 10) NULL DEFAULT NULL COMMENT 'co的最大控制措施',
  `oc_max` double(18, 10) NULL DEFAULT NULL COMMENT 'oc的最大控制措施',
  `bc_max` double(18, 10) NULL DEFAULT NULL COMMENT 'bc的最大控制措施',
  `nox_max` double(18, 10) NULL DEFAULT NULL COMMENT 'nox的最大控制措施',
  `scc_describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'scc拼接描述',
  `flag` int(11) NULL DEFAULT 0 COMMENT '使用计算因子置1，使用理论值为0',
  PRIMARY KEY (`sd_id`) USING BTREE,
  UNIQUE INDEX `scccode`(`scccode`, `county_id`, `sd_year`) USING BTREE,
  INDEX `county_id`(`county_id`) USING BTREE,
  CONSTRAINT `xjsoildust_ibfk_1` FOREIGN KEY (`scccode`) REFERENCES `scc` (`scc`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `xjsoildust_ibfk_2` FOREIGN KEY (`county_id`) REFERENCES `county` (`COUNTY_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 943 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '扬尘源-土壤扬尘' ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
