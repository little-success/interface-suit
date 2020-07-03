package com.suit.interfaces.entity;
import lombok.Data;

import java.util.Date;

@Data
public class TestSuit {
    private int id;
    private String suitName;
    private Integer businessType;
    private String describe;
    private Date createTime;
    private Date updataTime;

}


/*

    CREATE TABLE `test_suit` (
        `id` bigint(20) NOT NULL AUTO_INCREMENT,
        `suit_name` varchar(20) NOT NULL COMMENT '套件名称',
        `business_type` varchar(20) DEFAULT NULL COMMENT '业务类型（）',
        `describe` varchar(300) DEFAULT NULL COMMENT '用例集描述',
        `create_time` timestamp NULL DEFAULT NULL,
        `update_time` timestamp NULL DEFAULT NULL,
        PRIMARY KEY (`id`) USING BTREE
        ) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8 COMMENT='用例集表';
*/
