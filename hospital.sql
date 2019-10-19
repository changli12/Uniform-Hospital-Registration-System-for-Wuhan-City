/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50631
Source Host           : localhost:3306
Source Database       : hospital

Target Server Type    : MYSQL
Target Server Version : 50631
File Encoding         : 65001

Date: 2017-05-25 23:39:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `department`
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `depart_id` int(11) NOT NULL,
  `hospital_id` int(11) DEFAULT NULL,
  `depart_name` varchar(20) DEFAULT NULL,
  `sub_depart` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`depart_id`),
  KEY `hospital_id` (`hospital_id`),
  KEY `depart_name` (`depart_name`),
  CONSTRAINT `department_ibfk_1` FOREIGN KEY (`hospital_id`) REFERENCES `hospital` (`hos_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('200101', '80001', '卫生中心', null);
INSERT INTO `department` VALUES ('200201', '80002', '保健中心', null);
INSERT INTO `department` VALUES ('8000101', '80001', '呼吸科', null);
INSERT INTO `department` VALUES ('8000102', '80001', '老年科', null);
INSERT INTO `department` VALUES ('8000201', '80002', '皮肤科', null);
INSERT INTO `department` VALUES ('8000202', '80002', '牙体牙髓科', null);
INSERT INTO `department` VALUES ('8000203', '80002', null, null);
INSERT INTO `department` VALUES ('8000303', '80003', '骨科', null);
INSERT INTO `department` VALUES ('8000401', '80004', '急诊', null);
INSERT INTO `department` VALUES ('8000402', '80004', '呼吸科', null);
INSERT INTO `department` VALUES ('8000403', '80004', '肛肠科', null);
INSERT INTO `department` VALUES ('8000404', '80004', '心脏科', null);
INSERT INTO `department` VALUES ('8000504', '80005', '胸外科', null);
INSERT INTO `department` VALUES ('8000606', '80006', '精神内科', null);
INSERT INTO `department` VALUES ('8000707', '80007', '新生儿科', null);

-- ----------------------------
-- Table structure for `doctor`
-- ----------------------------
DROP TABLE IF EXISTS `doctor`;
CREATE TABLE `doctor` (
  `doctor_id` int(11) NOT NULL,
  `doctor_name` varchar(20) DEFAULT NULL,
  `doctor_post` varchar(45) DEFAULT NULL,
  `doctor_specialty` varchar(45) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `depart_id` int(11) DEFAULT NULL,
  `sex` char(4) DEFAULT NULL,
  `tel` char(11) DEFAULT NULL,
  PRIMARY KEY (`doctor_id`),
  KEY `doctor_name` (`doctor_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of doctor
-- ----------------------------
INSERT INTO `doctor` VALUES ('12', '12333', '122', '122', '122', '200201', 'on', '12333');
INSERT INTO `doctor` VALUES ('111', '张华', '专家医生', '卫生保健', '122222223@qq.com', '200101', '男', '12423417885');
INSERT INTO `doctor` VALUES ('123', '刘晓萌', '普通医生', '骨折', '23456788@sina.com', '8000303', '女', '1335233123');
INSERT INTO `doctor` VALUES ('201', '胡歌', '副主任医师', '骨裂', '123746@qq.com', '8000303', '女', '16237482671');
INSERT INTO `doctor` VALUES ('202', '张艺兴', '主任医师', '心脏病', '23444@qq.com', '8000404', '男', '19283728162');
INSERT INTO `doctor` VALUES ('203', '李畅畅', '主任医师', '妇产', '2276453627@sina.com', '8000707', '女', '15836253222');
INSERT INTO `doctor` VALUES ('204', '何欢', '专家医生', '精神分裂症', '142637445@qq.com', '8000606', '男', '13425364723');
INSERT INTO `doctor` VALUES ('400', '李花花', '普通医生', '心梗', '22@22.com', '8000401', '女', '13333333333');

-- ----------------------------
-- Table structure for `hospital`
-- ----------------------------
DROP TABLE IF EXISTS `hospital`;
CREATE TABLE `hospital` (
  `hos_id` int(11) NOT NULL,
  `hos_addr` varchar(48) DEFAULT NULL,
  `tel` char(16) DEFAULT NULL,
  `hos_name` varchar(20) DEFAULT NULL,
  `region` varchar(16) DEFAULT NULL,
  `hos_class` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`hos_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hospital
-- ----------------------------
INSERT INTO `hospital` VALUES ('80001', '湖北武汉武昌区张之洞路(原紫阳路)99号解放路238号', '027-88999120', '武汉大学人民医院', '武昌区', '三级甲等');
INSERT INTO `hospital` VALUES ('80002', '珞喻路237号', '027-87686110', '武汉大学口腔医院', '武昌区', '三级乙等');
INSERT INTO `hospital` VALUES ('80003', '湖北省武汉市武珞路627号', '027-50773333', '广州军区武汉总医院', '武昌区', '二级甲等');
INSERT INTO `hospital` VALUES ('80004', '湖北省武汉市硚口区中山大道215号(总院)', '027-85860666', '武汉市中西医结合医院', '硚口区', '二级乙等');
INSERT INTO `hospital` VALUES ('80005', '湖北省武汉市江汉区解放大道1277号', '027-85726114', '武汉协和医院', '江汉区', '一级甲等');
INSERT INTO `hospital` VALUES ('80006', '武汉市江岸区香港路100号', '027-82433350', '武汉市妇女儿童医疗保健中心', '江岸区', '一级乙等');
INSERT INTO `hospital` VALUES ('80007', '中国湖北省武汉市洪山区武珞路745号', '027-86709165', '湖北省妇幼保健院', '洪山区', '三级甲等');

-- ----------------------------
-- Table structure for `patient`
-- ----------------------------
DROP TABLE IF EXISTS `patient`;
CREATE TABLE `patient` (
  `patient_id` int(11) NOT NULL,
  `patient_name` varchar(16) DEFAULT NULL,
  `id_number` varchar(20) DEFAULT NULL,
  `sex` char(4) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `phone_number` char(16) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `patient_addr` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`patient_id`),
  KEY `patient_name` (`patient_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of patient
-- ----------------------------
INSERT INTO `patient` VALUES ('301', '张娜', '1627383', '女', '16', '13472638199', '2673373@qq.com', '中南财经政法大学南湖校区');
INSERT INTO `patient` VALUES ('302', '何晓洁', '2737289', '男', '23', '18237283744', '233341@qq.com', '中南财经政法大学首义校区');
INSERT INTO `patient` VALUES ('304', '林华华', '235768999', '女', '24', '13456789034', '23465667@qq.com', '湖北省武汉市南湖大道123号');
INSERT INTO `patient` VALUES ('305', '周小杰', '2436128899', '男', '28', '13526378899', '1263748293@qq.com', '湖北省武汉市民族大道25号');
INSERT INTO `patient` VALUES ('317', '马大哈', '13578345678', '男', '22', '13423563457', '2134688@qq.com', '湖北省武汉市雄楚大道18号');
INSERT INTO `patient` VALUES ('318', '陈希希', '23464547', '女', null, '13524356789', '13456787@qq.com', '湖北省武汉市武汉纺织大学');
INSERT INTO `patient` VALUES ('319', '刘洋', '23467889', '男', '35', '12453882362', '25678@qq.com', '中山大道28号');
INSERT INTO `patient` VALUES ('320', '哈哈', '2333333333333', '男', '18', '12345678901', '1', '红红火火哈哈');

-- ----------------------------
-- Table structure for `reserveinfo`
-- ----------------------------
DROP TABLE IF EXISTS `reserveinfo`;
CREATE TABLE `reserveinfo` (
  `reserve_id` int(11) NOT NULL,
  `patient_id` int(11) NOT NULL,
  `reserve_time` datetime(6) DEFAULT NULL,
  `hospital_id` int(11) DEFAULT NULL,
  `depart_id` int(11) DEFAULT NULL,
  `patient_name` varchar(20) DEFAULT NULL,
  `doctor_id` int(11) DEFAULT NULL,
  `textinfo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`reserve_id`),
  KEY `patient_id` (`patient_id`),
  KEY `hospital_id` (`hospital_id`),
  KEY `patient_name` (`patient_name`),
  KEY `department` (`depart_id`),
  KEY `doctor_id` (`doctor_id`),
  CONSTRAINT `reserveinfo_ibfk_1` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`patient_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `reserveinfo_ibfk_2` FOREIGN KEY (`hospital_id`) REFERENCES `hospital` (`hos_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `reserveinfo_ibfk_4` FOREIGN KEY (`patient_name`) REFERENCES `patient` (`patient_name`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `reserveinfo_ibfk_5` FOREIGN KEY (`depart_id`) REFERENCES `department` (`depart_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `reserveinfo_ibfk_6` FOREIGN KEY (`doctor_id`) REFERENCES `doctor` (`doctor_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reserveinfo
-- ----------------------------
INSERT INTO `reserveinfo` VALUES ('123455', '301', '2017-01-15 08:30:30.000000', '80002', '200201', '张娜', '111', '哈哈哈哈哈');
INSERT INTO `reserveinfo` VALUES ('133543', '304', '2017-05-10 15:12:20.000000', '80004', '8000404', '林华华', '202', '2222');
INSERT INTO `reserveinfo` VALUES ('133544', '317', '2017-05-20 08:30:00.000000', '80001', '200101', '马大哈', '111', '');
INSERT INTO `reserveinfo` VALUES ('133545', '317', '2017-06-01 08:30:00.000000', '80004', '8000401', '马大哈', '400', '');
INSERT INTO `reserveinfo` VALUES ('133546', '317', '2017-05-26 08:30:00.000000', '80004', '8000404', '马大哈', '202', '');
INSERT INTO `reserveinfo` VALUES ('133547', '318', '2017-05-30 08:30:00.000000', '80004', '8000401', '陈希希', '400', '');
INSERT INTO `reserveinfo` VALUES ('133548', '318', '2017-05-26 13:30:00.000000', '80001', '200101', '陈希希', '111', '');
INSERT INTO `reserveinfo` VALUES ('133549', '319', '2017-05-26 08:30:00.000000', '80004', '8000401', '刘洋', '400', '');
INSERT INTO `reserveinfo` VALUES ('133550', '301', '2017-05-26 08:30:00.000000', '80004', '8000404', '张娜', '202', '');

-- ----------------------------
-- Table structure for `schedule`
-- ----------------------------
DROP TABLE IF EXISTS `schedule`;
CREATE TABLE `schedule` (
  `doctor_id` int(11) NOT NULL,
  `doctor_name` varchar(20) DEFAULT NULL,
  `Mon1` int(11) DEFAULT NULL,
  `Mon2` int(11) DEFAULT NULL,
  `Tues1` int(11) DEFAULT NULL,
  `Tues2` int(11) DEFAULT NULL,
  `Wed1` int(11) DEFAULT NULL,
  `Wed2` int(11) DEFAULT NULL,
  `Thur1` int(11) DEFAULT NULL,
  `Thur2` int(11) DEFAULT NULL,
  `Fri1` int(11) DEFAULT NULL,
  `Fri2` int(11) DEFAULT NULL,
  `Sat1` int(11) DEFAULT NULL,
  `Sat2` int(11) DEFAULT NULL,
  `Sun1` int(11) DEFAULT NULL,
  `Sun2` int(11) DEFAULT NULL,
  PRIMARY KEY (`doctor_id`),
  KEY `doctor_name` (`doctor_name`),
  CONSTRAINT `schedule_ibfk_1` FOREIGN KEY (`doctor_id`) REFERENCES `doctor` (`doctor_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `schedule_ibfk_2` FOREIGN KEY (`doctor_name`) REFERENCES `doctor` (`doctor_name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of schedule
-- ----------------------------
INSERT INTO `schedule` VALUES ('111', '张华', '50', '2', '25', '50', '25', '2', '2', '25', '50', '24', '24', '50', '50', '25');
INSERT INTO `schedule` VALUES ('123', '刘晓萌', '25', '2', '30', '21', '34', '50', '23', '50', '34', '2', '14', '23', '2', '1');
INSERT INTO `schedule` VALUES ('201', '胡歌', '23', '23', '2', '12', '43', '21', '33', '2', '1', '2', '33', '21', '22', '33');
INSERT INTO `schedule` VALUES ('202', '张艺兴', '22', '11', '23', '1', '3', '33', '22', '12', '20', '12', '11', '35', '25', '22');
INSERT INTO `schedule` VALUES ('203', '李畅畅', '21', '12', '1', '23', '23', '33', '17', '16', '33', '25', '24', '22', '23', '2');
INSERT INTO `schedule` VALUES ('204', '何欢', '2', '11', '2', '40', '26', '16', '25', '34', '22', '2', '12', '12', '33', '3');
INSERT INTO `schedule` VALUES ('400', '李花花', '9', '9', '8', '9', '9', '9', '8', '9', '8', '9', '4', '0', '9', null);

-- ----------------------------
-- Table structure for `user_regist`
-- ----------------------------
DROP TABLE IF EXISTS `user_regist`;
CREATE TABLE `user_regist` (
  `user_id` int(11) NOT NULL,
  `user_name` varchar(20) DEFAULT NULL,
  `password` varchar(10) DEFAULT NULL,
  `sort` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_regist
-- ----------------------------
INSERT INTO `user_regist` VALUES ('101', '241626', '123456', '管理员用户');
INSERT INTO `user_regist` VALUES ('102', '143465', '123456', '管理员用户');
INSERT INTO `user_regist` VALUES ('201', '111', '123456', '医生用户');
INSERT INTO `user_regist` VALUES ('202', '123', '123456', '医生用户');
INSERT INTO `user_regist` VALUES ('203', '201', '123456', '医生用户');
INSERT INTO `user_regist` VALUES ('301', '13472638199', '123456', '病人用户');
INSERT INTO `user_regist` VALUES ('302', '18237283744', '123456', '病人用户');
INSERT INTO `user_regist` VALUES ('303', '13456789034', '123456', '病人用户');
INSERT INTO `user_regist` VALUES ('304', '13526378899', '123', '病人用户');
INSERT INTO `user_regist` VALUES ('307', '202', '123', '医生 用户');
INSERT INTO `user_regist` VALUES ('308', '203', '123', '医生 用户');
INSERT INTO `user_regist` VALUES ('309', '204', '123', '医生 用户');
INSERT INTO `user_regist` VALUES ('310', '13423563457', '123', '病人用户');
INSERT INTO `user_regist` VALUES ('311', '13524356789', '123', '病人用户');
INSERT INTO `user_regist` VALUES ('312', '12453882362', '123', '病人用户');
INSERT INTO `user_regist` VALUES ('313', '12', '12333', '医生用户');
INSERT INTO `user_regist` VALUES ('314', '12333', '12333', '医生 用户');
INSERT INTO `user_regist` VALUES ('315', '400', '123456', '医生用户');
