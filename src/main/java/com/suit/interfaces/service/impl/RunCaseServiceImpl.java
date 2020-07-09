package com.suit.interfaces.service.impl;

import com.suit.interfaces.dao.HeaderInformationRepository;
import com.suit.interfaces.dao.HostRepository;
import com.suit.interfaces.dao.InterfaceMapper;
import com.suit.interfaces.dao.ParamsMapper;
import com.suit.interfaces.entity.HeaderInformation;
import com.suit.interfaces.entity.InterfaceDetails;
import com.suit.interfaces.entity.InterfaceParams;
import com.suit.interfaces.service.HeaderInformationService;
import com.suit.interfaces.service.HostsService;
import com.suit.interfaces.service.InterfaceService;
import com.suit.interfaces.service.RunCaseService;
import com.suit.interfaces.util.JsonParseUtil;
import com.suit.interfaces.util.MockUtil;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static io.restassured.RestAssured.given;

/**
 * <p>
 *
 * </p>
 *
 * @author gongxc
 * @date 2020/7/8
 */
@Service
public class RunCaseServiceImpl implements RunCaseService {
    @Autowired
    private HeaderInformationRepository headerInformationRepository;

    @Resource
    private  InterfaceMapper interfaceMapper;

    @Autowired
    private HostRepository hostRepository;

    @Resource
    private ParamsMapper paramsMapper;



    public Response runCase(Integer id){
        RequestSpecification request = given();
        InterfaceDetails inter = interfaceMapper.selectById(id);
        Long hostId = (long)inter.getHostId();
        Long headerId = (long)1;
        String host = hostRepository.findById(hostId).get().getHosts();
        String path = inter.getRequestPath();
        String url = "http://"+""+"";

        String headerInfo = headerInformationRepository.findById(inter.getHeaderId()).get().getHeaderInfo();

        //paramsMapper.selectByParamsList(id).
        String paramInfo = " ";

        if(headerInfo!=null){
            request.headers(JsonParseUtil.parseToMap(headerInfo));
        }

        if(paramInfo!=null){
            request.params(JsonParseUtil.parseToMap(headerInfo));
        }

        if(inter.getRequestMode()==1){
            return request
                    .when().log().all().get(url)
                    .then().log().all().extract().response();
        }else if(inter.getRequestMode()==2){
            return request
                    .when().log().all().post(url)
                    .then().log().all().extract().response();
        }
        return null;

    }


    @Override
    public Response runCase() {
        return null;
    }


    public Resource runCase(String method, String url, Map headers, Map params) {
        return null;
    }

    @Override
    public Response runCase(String method,String url,Map<String,Object> headers,Map<String,Object> query,Map postBody){
        RequestSpecification request = given();
        if(headers!=null){
            request.headers(headers);
        }
        if (method.equals("get")){
            if(query!=null){
                request.queryParams(query);
            }
            return request
                    .when().log().all().get(url)
                    .then().log().all().extract().response();
        }else {
            if(postBody!=null){
                request.body(postBody);
            }
            return request
                    .when().log().all().post(url)
                    .then().log().all().extract().response();
        }

    }

    @Override
    public Response runCasePost(String url,Map<String,Object> headers,Map postBody){
        RequestSpecification request = given();
        if(headers!=null){
            request.headers(headers);
        }

        if(postBody!=null){
            request.body(postBody);
            }
        return request
                .when().log().all().post(url)
                .then().log().all().extract().response();
        }


}
