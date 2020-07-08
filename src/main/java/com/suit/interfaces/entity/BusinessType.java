package com.suit.interfaces.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author gongxc
 * @date 2020/7/8
 */
@Data
@Entity
@Table(name = "business_type", uniqueConstraints = @UniqueConstraint(columnNames = "type_name"))
@ApiModel(description = "业务类型")
public class BusinessType {
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Null(message = "id必须为空")
    @Column(name = "id")
    private Long id;


    @Column(name = "type_name" ,unique=true)
    @NotBlank(message = "类型不能为空")
    @ApiModelProperty(value = "业务类型", name = "type_name", required = true, example = "功能")
    private String typeName;


    @Column(name = "create_time")
    @JsonIgnore
    private Date createTime;

    @Column(name = "update_time")
    @JsonIgnore
    private Date  updateTime;
}
