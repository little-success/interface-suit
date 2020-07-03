CREATE TABLE `header_information` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `header_name` varchar(20) NOT NULL COMMENT 'header标题',
  `header_info` varchar(1000) NOT NULL COMMENT 'header内容',
  `business_type` varchar(20) DEFAULT NULL COMMENT '业务类型（）',
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8 COMMENT='请求头信息表';


CREATE TABLE `test_suit` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `suit_name` varchar(20) NOT NULL COMMENT '套件名称',
  `business_type` varchar(20) DEFAULT NULL COMMENT '业务类型（）',
	`describe` varchar(300) DEFAULT NULL COMMENT '用例集描述',
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8 COMMENT='用例集表';



CREATE TABLE `hosts` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `hosts` varchar(20) NOT NULL COMMENT '域名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='域名表';


CREATE TABLE `interface_datails` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
	`suit_id` bigint(20) NOT NULL,
	`host_id` bigint(20) NOT NULL,
  `interface_name` varchar(20) NOT NULL COMMENT '接口名称名称',
  `request_mode` int(2) DEFAULT NULL COMMENT '请求方式（1：get 2：post）',
	`describe` varchar(300) DEFAULT NULL COMMENT '接口描述',
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='接口详情表';

CREATE TABLE `interface_params` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `interface_id` bigint(20) NOT NULL,
	`describe` varchar(300) DEFAULT NULL COMMENT '接口描述',
  `parame_info` varchar(2000) DEFAULT NULL COMMENT '接口请求参数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='接口对应参数表';

CREATE TABLE `business_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
	`type_name` varchar(300) DEFAULT NULL COMMENT '业务名称',
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='业务类型表';




