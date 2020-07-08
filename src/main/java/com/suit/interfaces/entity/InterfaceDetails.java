package com.suit.interfaces.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import java.util.Date;
@Data
public class InterfaceDetails {
    @ApiModelProperty(value = "接口id", name = "id")
    @Column(name = "id")
    private Integer id;

    @ApiModelProperty(value = "套件ID", name = "suitId")
    private Integer suitId;

    @ApiModelProperty(value = "域名", name = "hostId")
    private Integer hostId;

    @ApiModelProperty(value = "头信息", name = "headerId")
    private Long headerId;

    @ApiModelProperty(value = "接口名称", name = "interfaceName")
    private String interfaceName;
    @ApiModelProperty(value = "请求方式", name = "requestMode")
    private Integer requestMode;
    @ApiModelProperty(value = "请求路径", name = "requestPath")
    private String requestPath;
    @ApiModelProperty(value = "接口描述", name = "describes")
    private String describes;
    @JsonIgnore
    @Column(name = "create_time")
    private Date createTime;
    @JsonIgnore
    @Column(name = "update_time")
    private Date updateTime;
}