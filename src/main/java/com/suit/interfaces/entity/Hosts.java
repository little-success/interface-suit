package com.suit.interfaces.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;

/**
 * <p>
 * host实体类
 * </p>
 *
 * @author gongxc
 * @date 2020/7/7
 */
@Data
@Entity(name = "hosts")
@Table(name = "hosts",uniqueConstraints = @UniqueConstraint(columnNames = "hosts"))

@ApiModel(description = "域名信息")
public class Hosts {
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Null(message = "id必须为空")
    @Column(name = "id")
    private Long id;

    @Column(name = "hosts" ,unique=true)
    @NotBlank(message = "域名不能为空")
    @ApiModelProperty(value = "host域名", name = "hosts", required = true, example = "http://example.com")
    private String hosts;
}
