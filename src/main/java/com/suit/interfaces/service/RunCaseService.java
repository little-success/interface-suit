package com.suit.interfaces.service;


import io.restassured.response.Response;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @author gongxc
 * @date 2020/7/8
 */
@Service
public interface RunCaseService {
    Response runCase();

    Response runCasePost(String url,Map<String,Object> headers,Map postBody);

    Response runCase(String method,String url,Map<String,Object> headers,Map<String,Object> query,Map postBody);

}
