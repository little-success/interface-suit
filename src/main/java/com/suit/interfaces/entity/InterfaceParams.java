package com.suit.interfaces.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;

@Data
public class InterfaceParams {
    @Id
    @Column(name = "id")
    @ApiModelProperty(value = "参数组id", name = "id")
    private Integer id;
    @ApiModelProperty(value = "对应接口id", name = "id")
    private Integer interfaceId;
    @ApiModelProperty(value = "参数描述", name = "describes")
    private String describes;
    @Column(name = "paramsInfo")
    @ApiModelProperty(value = "请求参数", name = "paramsInfo")
    private String paramsInfo;
    @Column(name = "intendedResult")
    @ApiModelProperty(value = "预期结果", name = "intendedResult")
    private String intendedResult;
}

/*
*
* CREATE TABLE `interface_params` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `interface_id` bigint(20) NOT NULL,
	`describe` varchar(300) DEFAULT NULL COMMENT '接口描述',
  `parame_info` varchar(2000) DEFAULT NULL COMMENT '接口请求参数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='接口对应参数表';*/