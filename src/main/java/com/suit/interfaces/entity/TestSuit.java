package com.suit.interfaces.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import java.util.Date;

@Data
public class TestSuit {
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Null(message = "id必须为空")
    @Column(name = "id")
    @ApiModelProperty(value = "套件ID", name = "id")
    private int id;

    @Column(name = "suit_name")
    @NotBlank(message = "套件名称不能为空")
    @ApiModelProperty(value = "套件名称", name = "suitName", required = true, example = "")
    private String suitName;

    @Column(name = "business_type")
    @ApiModelProperty(value = "业务类型", name = "businessType", required = true, example = "")
    private Integer businessType;

    @Column(name = "describes")
    @ApiModelProperty(value = "套件描述", name = "describe", required = true, example = "")
    private String describes;

    @JsonIgnore
    @Column(name = "create_time")
    private Date createTime;

    @JsonIgnore
    @Column(name = "update_time")
    private Date updateTime;

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
