package com.suit.interfaces.entity;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.suit.interfaces.util.JsonParseUtil;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import java.util.Date;

/**
 * <p>
 * 消息头信息
 * </p>
 *
 * @author gongxc
 * @date 2020/7/3
 */
@Data
@Entity(name = "header_information")
@Table(name = "header_information",
        uniqueConstraints = @UniqueConstraint(columnNames = "header_name")

)
@ApiModel(description = "消息头信息")
public class HeaderInformation {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Null(message = "id必须为空")
    @Column(name = "id")
    private Long id;


    @Column(name = "header_name" ,unique=true)
    @NotBlank(message = "header标题不能为空")

    @ApiModelProperty(value = "header标题", name = "headerName", required = true, example = "")
    private String headerName;

    public void setHeaderInfo(JSONObject headerInfo) {
        this.headerInfo = JsonParseUtil.parseJson(headerInfo);
    }

    @Column(name = "header_info")
    @NotBlank(message = "header内容不能为空")
    @ApiModelProperty(value = "header内容", name = "headerInfo", required = true, example = "{\"Content-Type\":\"application/json;charset=UTF-8\"}")
    private String headerInfo;

    @Column(name = "business_type")
    @NotBlank(message = "Type不能为空")
    @ApiModelProperty(value = "业务类型", name = "businessType", required = true, example = "")
    private String businessType;

    @Column(name = "create_time")
    @JsonIgnore
    private Date createTime;

    @Column(name = "update_time")
    @JsonIgnore
    private Date  updateTime;




}
