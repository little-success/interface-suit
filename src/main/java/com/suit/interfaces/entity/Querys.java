package com.suit.interfaces.entity;

import lombok.Data;

import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @author gongxc
 * @date 2020/7/8
 */
@Data
public class Querys {
    private String method;
    private String url;
    private Map<String,Object> headers;
    private Map<String,Object> query;
    private Map postBody;
}
