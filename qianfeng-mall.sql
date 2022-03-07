/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80011
Source Host           : localhost:3306
Source Database       : mall

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2020-09-29 10:15:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for good
-- ----------------------------
DROP TABLE IF EXISTS `good`;
CREATE TABLE `good` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `price` double(10,2) DEFAULT NULL,
  `brand` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `img_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `proceeds` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of good
-- ----------------------------
INSERT INTO `good` VALUES ('1', '小米10至尊纪念版', '5599.00', '小米', 'api/xiaomi10U.jpg', '120X 超远变焦 / 120W 秒充科技 / 120Hz刷新率 + 240Hz采样率 / 骁龙865旗舰处理器 / 双模5G / 10倍混合光学变焦 / OIS光学防抖+EIS数字防抖 / 2000万超清前置相机 / 双串蝶式石墨烯基锂离子电池 / 等效4500mAh大电量 / 120W 有线秒充+50W无线秒充+10W无线反充 / WiFi 6 / 多功能NFC / 红外遥控', '1', '1', '100', '手机通讯');
INSERT INTO `good` VALUES ('2', '小米10', '3799.00', '小米', 'api/xiaomi10.jpg', '骁龙865处理器 / 1亿像素8K电影相机 / 双模5G / 新一代LPDDR5内存 / 对称式立体声 / 90Hz刷新率+180Hz采样率 / UFS 3.0高速存储 / 全面适配Wi-Fi 6 / 超强VC液冷散热 / 30W极速闪充+30W无线闪充+10W无线反充 / 4780mAh大电量 / 多功能NFC', '1', '1', '100', '手机通讯');
INSERT INTO `good` VALUES ('3', '小米10Pro', '4999.00', '小米', 'api/xiaomi10Pro.jpg', '向往的生活同款 / 骁龙865处理器 / 1亿像素8K电影相机，50倍数字变焦，10倍混合光学变焦 / 双模5G / 新一代LPDDR5内存 / 50W极速闪充+30W无线闪充+10W无线反充 / 对称式立体声 / 90Hz刷新率+180Hz采样率 / UFS 3.0高速存储 / 全面适配WiFi 6 / 超强VC液冷散热 / 4500mAh大电量 / 多功能NFC', '1', '1', '100', '手机通讯');
INSERT INTO `good` VALUES ('4', '小米10/小米10Pro轻薄极简保护壳', '49.00', '小米', 'api/mi10baohuke.jpg', null, '1', '1', '100', '手机配件');
INSERT INTO `good` VALUES ('5', '米家直流变频落地扇1X', '298.80', '小米', 'api/luodifengshan.png', null, '2', '1', '100', '智能设备');
INSERT INTO `good` VALUES ('6', 'Redmi K30 至尊纪念版', '1999.00', '小米', 'api/redmik30.jpg', null, '1', '1', '100', '手机通讯');
INSERT INTO `good` VALUES ('7', '小米九号平衡车', '1999.00', '小米', 'api/pinghengche.jpg', '年轻人的酷玩具 / 骑行遥控两种玩法 / 22公里超长续航 / 轻、小、便携 / 重心驱动 / 15重安全保障', '1', '1', '100', '智能设备');
INSERT INTO `good` VALUES ('8', 'Redmi智能电视MAX98``', '19999.00', '小米', 'api/tv98.jpg', '客厅里的巨幕影院 大视野带来超震撼的沉浸感/4K HDR超高清画质 逼真画面栩栩如生/杜比+DTS双解码 清澈立体的声音环绕整个客厅/MEMC运动补偿 无拖尾无重影/4G+64G大存储 畅快不卡顿/海量片源 观影更爽/智能家居控制中心', '1', '1', '100', '智能设备');
INSERT INTO `good` VALUES ('9', '小米透明电视', '49999.00', '小米', 'api/xiaomiMasterTV.jpg', '55″透明OLED | 悬浮影像 ｜杜比全景声 ｜四核A73 旗舰处理器', '1', '1', '100', '智能设备');
INSERT INTO `good` VALUES ('10', 'apple20', '20.00', '苹果', 'api/1601293735466.jpg', '没有描述', '5', '1', '5', '手机配件');
INSERT INTO `good` VALUES ('11', 'iPhone Mate 12 Pro Max Plus S至尊纪念版 贵族金', '9999.00', '苹果', 'api/1601294590017.jpg', 'iPhone 12 将延续刘海全面屏设计，标配OLED屏幕，并采用类似iPhone 4的纯平中框，搭载基于5纳米工艺制程打造的A14处理器，支持5G网络，是iPhone系列推出的第一款支持5G网络配置的智能手机，配备后置双摄像头，支持中国的北斗导航定位系统。', '99999', '1', '1', '手机配件');

-- ----------------------------
-- Table structure for good_image
-- ----------------------------
DROP TABLE IF EXISTS `good_image`;
CREATE TABLE `good_image` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `good_id` int(11) NOT NULL,
  `img_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of good_image
-- ----------------------------
INSERT INTO `good_image` VALUES ('1', '1', 'api/Mi10U1.jpg');
INSERT INTO `good_image` VALUES ('2', '1', 'api/Mi10U2.jpg');
INSERT INTO `good_image` VALUES ('3', '1', 'api/Mi10U3.jpg');
INSERT INTO `good_image` VALUES ('4', '1', 'api/Mi10U4.jpg');
INSERT INTO `good_image` VALUES ('5', '1', 'api/Mi10U5.jpg');
INSERT INTO `good_image` VALUES ('6', '2', 'api/Mi101.jpg');
INSERT INTO `good_image` VALUES ('7', '2', 'api/Mi102.jpg');
INSERT INTO `good_image` VALUES ('8', '2', 'api/Mi103.jpg');
INSERT INTO `good_image` VALUES ('9', '2', 'api/Mi104.jpg');
INSERT INTO `good_image` VALUES ('10', '2', 'api/Mi105.jpg');
INSERT INTO `good_image` VALUES ('11', '3', 'api/Mi10P1.jpg');
INSERT INTO `good_image` VALUES ('12', '3', 'api/Mi10P2.jpg');
INSERT INTO `good_image` VALUES ('13', '3', 'api/Mi10P3.jpg');
INSERT INTO `good_image` VALUES ('14', '3', 'api/Mi10P4.jpg');
INSERT INTO `good_image` VALUES ('15', '3', 'api/Mi10P5.jpg');
INSERT INTO `good_image` VALUES ('16', '8', 'api/TV981.jpg');
INSERT INTO `good_image` VALUES ('17', '8', 'api/TV982.jpg');
INSERT INTO `good_image` VALUES ('18', '8', 'api/TV983.jpg');
INSERT INTO `good_image` VALUES ('19', '8', 'api/TV984.jpg');
INSERT INTO `good_image` VALUES ('20', '8', 'api/TV985.jpg');
INSERT INTO `good_image` VALUES ('21', '9', 'api/TVMaster1.jpg');
INSERT INTO `good_image` VALUES ('22', '9', 'api/TVMaster2.jpg');
INSERT INTO `good_image` VALUES ('23', '9', 'api/TVMaster3.jpg');
INSERT INTO `good_image` VALUES ('24', '9', 'api/TVMaster4.jpg');
INSERT INTO `good_image` VALUES ('25', '9', 'api/TVMaster5.jpg');
INSERT INTO `good_image` VALUES ('26', '7', 'api/BalanceCar1.jpg');
INSERT INTO `good_image` VALUES ('27', '7', 'api/BalanceCar2.jpg');
INSERT INTO `good_image` VALUES ('28', '7', 'api/BalanceCar3.jpg');
INSERT INTO `good_image` VALUES ('29', '7', 'api/BalanceCar4.jpg');
INSERT INTO `good_image` VALUES ('30', '7', 'api/BalanceCar5.jpg');
INSERT INTO `good_image` VALUES ('31', '5', 'api/1601291826363.jpg');
INSERT INTO `good_image` VALUES ('34', '11', 'api/1601294655893.jpg');
INSERT INTO `good_image` VALUES ('35', '11', 'api/1601294658690.jpg');
INSERT INTO `good_image` VALUES ('36', '11', 'api/1601294661304.jpg');
INSERT INTO `good_image` VALUES ('37', '11', 'api/1601294664165.jpg');
INSERT INTO `good_image` VALUES ('38', '11', 'api/1601294666718.jpg');

-- ----------------------------
-- Table structure for oms_order
-- ----------------------------
DROP TABLE IF EXISTS `oms_order`;
CREATE TABLE `oms_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `create_time` datetime DEFAULT NULL COMMENT '提交时间',
  `user_id` int(11) DEFAULT NULL COMMENT '用户帐号',
  `pay_amount` decimal(10,2) DEFAULT NULL COMMENT '应付金额（实际支付金额）',
  `pay_type` int(11) DEFAULT NULL COMMENT '支付方式：0->未支付；1->支付宝；2->微信',
  `status` int(11) DEFAULT NULL COMMENT '订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；',
  `source_type` int(11) DEFAULT NULL,
  `receiver_name` varchar(100) NOT NULL COMMENT '收货人姓名',
  `receiver_phone` varchar(32) NOT NULL COMMENT '收货人电话',
  `receiver_post_code` varchar(32) DEFAULT NULL COMMENT '收货人邮编',
  `receiver_province` varchar(32) DEFAULT NULL COMMENT '省份/直辖市',
  `receiver_city` varchar(32) DEFAULT NULL COMMENT '城市',
  `receiver_region` varchar(32) DEFAULT NULL COMMENT '区',
  `receiver_detail_address` varchar(200) DEFAULT NULL COMMENT '详细地址',
  `note` varchar(500) DEFAULT NULL COMMENT '订单备注',
  `payment_time` datetime DEFAULT NULL COMMENT '支付时间',
  `receive_time` datetime DEFAULT NULL COMMENT '确认收货时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oms_order
-- ----------------------------
INSERT INTO `oms_order` VALUES ('30', '2020-09-28 21:57:01', '1', '63588.00', '1', '1', '2', '张三', '13589541268', '400000', '重庆市', '万州区', '陈家坝街道', '478号', '', '2020-09-29 06:18:46', null);
INSERT INTO `oms_order` VALUES ('31', '2020-09-28 21:57:39', '1', '7996.00', '0', '0', '1', '李四', '15489631564', '401450', '青海省', '西宁市', '石峡清风', '', '', null, null);
INSERT INTO `oms_order` VALUES ('32', '2020-09-15 01:09:43', '1', '59994.00', '2', '3', '1', '王五', '15964523541', '005982', '重庆市', '重庆市', '巴南区', '巴南区红光大道69号', '', '2020-09-28 06:19:24', '2020-09-30 06:19:29');
INSERT INTO `oms_order` VALUES ('37', '2020-09-29 06:24:36', '1', '39992.00', '0', '0', '1', '胡适', '18958962478', '400000', '重庆市', '重庆市', '两江校区', '普福大道509号', '', null, null);
INSERT INTO `oms_order` VALUES ('38', '2020-09-29 06:24:45', '1', '499990.00', '0', '0', '1', '胡适', '18958962478', '400000', '重庆市', '重庆市', '两江校区', '普福大道509号', '', null, null);
INSERT INTO `oms_order` VALUES ('39', '2020-09-29 06:24:59', '1', '100.00', '0', '0', '1', '胡适', '18958962478', '400000', '重庆市', '重庆市', '两江校区', '普福大道509号', '', null, null);
INSERT INTO `oms_order` VALUES ('40', '2020-09-29 06:26:11', '1', '196.00', '0', '0', '1', '胡适', '18958962478', '400000', '重庆市', '重庆市', '两江校区', '普福大道509号', '', null, null);
INSERT INTO `oms_order` VALUES ('41', '2020-09-29 06:26:19', '1', '11994.00', '0', '0', '1', '胡适', '18958962478', '400000', '重庆市', '重庆市', '两江校区', '普福大道509号', '', null, null);
INSERT INTO `oms_order` VALUES ('42', '2020-09-29 06:26:46', '1', '343.00', '0', '0', '1', '胡适', '18958962478', '400000', '重庆市', '重庆市', '两江校区', '普福大道509号', '', null, null);
INSERT INTO `oms_order` VALUES ('43', '2020-09-29 06:26:52', '1', '3799.00', '0', '0', '1', '胡适', '18958962478', '400000', '重庆市', '重庆市', '两江校区', '普福大道509号', '', null, null);
INSERT INTO `oms_order` VALUES ('44', '2020-09-29 06:26:59', '1', '20.00', '0', '0', '1', '胡适', '18958962478', '400000', '重庆市', '重庆市', '两江校区', '普福大道509号', '', null, null);
INSERT INTO `oms_order` VALUES ('45', '2020-09-29 09:14:19', '1', '10598.00', '0', '0', '1', '胡适', '18958962478', '400000', '重庆市', '万州区', '五桥', '85号', '', null, null);
INSERT INTO `oms_order` VALUES ('46', '2020-09-29 09:26:20', '2', '32844.00', '0', '0', '1', '胡适', '18958962478', '400000', '重庆市', '万州区', '五桥', '85号', '', null, null);
INSERT INTO `oms_order` VALUES ('47', '2020-09-29 09:35:10', '2', '499990.00', '0', '0', '1', '胡适', '18958962478', '400000', '重庆市', '万州区', '五桥', '85号', '', null, null);
INSERT INTO `oms_order` VALUES ('48', '2020-09-29 09:35:23', '2', '55990.00', '0', '0', '1', '胡适', '18958962478', '400000', '重庆市', '万州区', '五桥', '85号', '', null, null);

-- ----------------------------
-- Table structure for oms_order_item
-- ----------------------------
DROP TABLE IF EXISTS `oms_order_item`;
CREATE TABLE `oms_order_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(20) DEFAULT NULL COMMENT '订单id',
  `product_id` bigint(20) DEFAULT NULL COMMENT '商品id',
  `product_pic` varchar(500) DEFAULT NULL COMMENT '商品图片',
  `product_name` varchar(200) DEFAULT NULL COMMENT '商品名称',
  `product_price` decimal(10,2) DEFAULT NULL COMMENT '销售价格',
  `product_count` int(11) DEFAULT NULL COMMENT '购买数量',
  `pay_amount` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oms_order_item
-- ----------------------------
INSERT INTO `oms_order_item` VALUES ('7', '30', '1', 'api/xiaomi10U.jpg', '小米10至尊纪念版', '5599.00', '10', '55990');
INSERT INTO `oms_order_item` VALUES ('8', '31', '7', 'api/pinghengche.jpg', '小米九号平衡车', '1999.00', '4', '7996');
INSERT INTO `oms_order_item` VALUES ('9', '32', '11', 'api/1601294590017.jpg', 'iPhone Mate 12 Pro Max Plus S至尊纪念版 贵族金', '9999.00', '6', '59994');
INSERT INTO `oms_order_item` VALUES ('10', '33', '2', 'api/xiaomi10.jpg', '小米10', '3799.00', '5', '18995');
INSERT INTO `oms_order_item` VALUES ('11', '30', '2', 'api/xiaomi10.jpg', '小米10', '3799.00', '2', '7598');
INSERT INTO `oms_order_item` VALUES ('12', '34', '6', 'api/redmik30.jpg', 'Redmi K30 至尊纪念版', '1999.00', '7', '13993');
INSERT INTO `oms_order_item` VALUES ('13', '35', '5', 'api/luodifengshan.png', '米家直流变频落地扇1X', '298.80', '3', '896');
INSERT INTO `oms_order_item` VALUES ('14', '36', '7', 'api/pinghengche.jpg', '小米九号平衡车', '1999.00', '7', '13993');
INSERT INTO `oms_order_item` VALUES ('15', '37', '3', 'api/xiaomi10Pro.jpg', '小米10Pro', '4999.00', '8', '39992');
INSERT INTO `oms_order_item` VALUES ('16', '38', '9', 'api/xiaomiMasterTV.jpg', '小米透明电视', '49999.00', '10', '499990');
INSERT INTO `oms_order_item` VALUES ('17', '39', '10', 'api/1601293735466.jpg', 'apple20', '20.00', '5', '100');
INSERT INTO `oms_order_item` VALUES ('18', '40', '4', 'api/mi10baohuke.jpg', '小米10/小米10Pro轻薄极简保护壳', '49.00', '4', '196');
INSERT INTO `oms_order_item` VALUES ('19', '41', '6', 'api/redmik30.jpg', 'Redmi K30 至尊纪念版', '1999.00', '6', '11994');
INSERT INTO `oms_order_item` VALUES ('20', '42', '4', 'api/mi10baohuke.jpg', '小米10/小米10Pro轻薄极简保护壳', '49.00', '7', '343');
INSERT INTO `oms_order_item` VALUES ('21', '43', '2', 'api/xiaomi10.jpg', '小米10', '3799.00', '1', '3799');
INSERT INTO `oms_order_item` VALUES ('22', '44', '10', 'api/1601293735466.jpg', 'apple20', '20.00', '1', '20');
INSERT INTO `oms_order_item` VALUES ('23', '45', '3', 'api/xiaomi10Pro.jpg', '小米10Pro', '4999.00', '1', '4999');
INSERT INTO `oms_order_item` VALUES ('24', '45', '1', 'api/xiaomi10U.jpg', '小米10至尊纪念版', '5599.00', '1', '5599');
INSERT INTO `oms_order_item` VALUES ('25', '46', '2', 'api/xiaomi10.jpg', '小米10', '3799.00', '1', '3799');
INSERT INTO `oms_order_item` VALUES ('26', '46', '3', 'api/xiaomi10Pro.jpg', '小米10Pro', '4999.00', '1', '4999');
INSERT INTO `oms_order_item` VALUES ('27', '46', '4', 'api/mi10baohuke.jpg', '小米10/小米10Pro轻薄极简保护壳', '49.00', '1', '49');
INSERT INTO `oms_order_item` VALUES ('28', '46', '6', 'api/redmik30.jpg', 'Redmi K30 至尊纪念版', '1999.00', '1', '1999');
INSERT INTO `oms_order_item` VALUES ('29', '46', '7', 'api/pinghengche.jpg', '小米九号平衡车', '1999.00', '1', '1999');
INSERT INTO `oms_order_item` VALUES ('30', '46', '8', 'api/tv98.jpg', 'Redmi智能电视MAX98``', '19999.00', '1', '19999');
INSERT INTO `oms_order_item` VALUES ('31', '47', '9', 'api/xiaomiMasterTV.jpg', '小米透明电视', '49999.00', '10', '499990');
INSERT INTO `oms_order_item` VALUES ('32', '48', '1', 'api/xiaomi10U.jpg', '小米10至尊纪念版', '5599.00', '10', '55990');

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` int(10) NOT NULL,
  `url` varchar(255) DEFAULT NULL COMMENT 'url地址',
  `name` varchar(100) DEFAULT NULL COMMENT 'url描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------

-- ----------------------------
-- Table structure for poster
-- ----------------------------
DROP TABLE IF EXISTS `poster`;
CREATE TABLE `poster` (
  `id` int(11) NOT NULL,
  `good_id` int(11) NOT NULL,
  `img_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of poster
-- ----------------------------
INSERT INTO `poster` VALUES ('1', '1', 'api/mi10Uposter.jpg');
INSERT INTO `poster` VALUES ('2', '7', 'api/pinghengchePoster.jpg');
INSERT INTO `poster` VALUES ('3', '8', 'api/TV98Poster.jpg');
INSERT INTO `poster` VALUES ('4', '9', 'api/masterTVPoster.jpg');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `memo` varchar(100) DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'admin', '管理员');
INSERT INTO `role` VALUES ('2', 'customer', '顾客');

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `rid` int(10) DEFAULT NULL COMMENT '角色id',
  `pid` int(10) DEFAULT NULL COMMENT '权限id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_permission
-- ----------------------------

-- ----------------------------
-- Table structure for shopping_car
-- ----------------------------
DROP TABLE IF EXISTS `shopping_car`;
CREATE TABLE `shopping_car` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `good_id` int(11) NOT NULL,
  `number` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=112 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shopping_car
-- ----------------------------
INSERT INTO `shopping_car` VALUES ('108', '1', '1', '1');

-- ----------------------------
-- Table structure for type_brand
-- ----------------------------
DROP TABLE IF EXISTS `type_brand`;
CREATE TABLE `type_brand` (
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '商品大类',
  `brand` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '品牌'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of type_brand
-- ----------------------------
INSERT INTO `type_brand` VALUES ('手机配件', '苹果');
INSERT INTO `type_brand` VALUES ('手机通讯', '华为');
INSERT INTO `type_brand` VALUES ('手机通讯', '小米');
INSERT INTO `type_brand` VALUES ('手机通讯', 'OPPO');
INSERT INTO `type_brand` VALUES ('手机通讯', 'vivo');
INSERT INTO `type_brand` VALUES ('手机通讯', '苹果');
INSERT INTO `type_brand` VALUES ('手机配件', '小米');
INSERT INTO `type_brand` VALUES ('数码配件', '苹果');
INSERT INTO `type_brand` VALUES ('数码配件', '华为');
INSERT INTO `type_brand` VALUES ('智能设备', '小米');
INSERT INTO `type_brand` VALUES ('智能设备', '华为');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号',
  `password` char(32) NOT NULL COMMENT '密码',
  `email` varchar(50) NOT NULL COMMENT '邮箱',
  `status` tinyint(1) DEFAULT '0' COMMENT '状态 1-正常，0-禁用，-1-删除',
  `create_time` date DEFAULT NULL COMMENT '添加时间',
  `last_login_time` int(11) unsigned DEFAULT '0' COMMENT '上次登陆时间',
  `last_login_ip` varchar(40) DEFAULT NULL COMMENT '上次登录IP',
  `login_count` mediumint(8) unsigned DEFAULT '0' COMMENT '登陆次数',
  PRIMARY KEY (`id`),
  UNIQUE KEY `account` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'haruna', 'password', '123', '1', null, '0', null, '0');
INSERT INTO `user` VALUES ('2', 'li', 'password', '123', '1', null, '0', null, '0');
INSERT INTO `user` VALUES ('3', 'wang', 'password', '15@qq.com', '1', '2020-09-29', '0', null, '0');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `uid` int(10) DEFAULT NULL COMMENT '用户id',
  `rid` int(10) DEFAULT NULL COMMENT '角色id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1');
INSERT INTO `user_role` VALUES ('2', '2');
INSERT INTO `user_role` VALUES ('3', '2');
