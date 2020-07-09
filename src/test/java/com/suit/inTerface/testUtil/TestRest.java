package com.suit.inTerface.testUtil;

import com.suit.interfaces.service.RunCaseService;
import com.suit.interfaces.service.impl.RunCaseServiceImpl;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

/**
 * <p>
 *
 * </p>
 *
 * @author gongxc
 * @date 2020/7/9
 */

public class TestRest {
    Map<String,Object> map = new HashMap<>();
    @Test
    public void testRest(){
        RequestSpecification request = given();
        request.header("Content-type", "application/json;charset=UTF-8");
        request
                .when().log().all().request("post","http://111.229.65.252:8801/cases/case/getCount")
                .then().log().all().extract().response();
    }

    
    @Test
    public void testAssured(){
        RunCaseService r = new RunCaseServiceImpl();
        Response response = r.runCasePost("http://111.229.65.252:8801/cases/case/getCount", map, map);
    }


    @Test
    public void testRequest(){
        given().when().log().all().post("http://111.229.65.252:8801/cases/case/getCount")
                .then().log().all().extract().response();

    }


    @Test
    public void testtwentynine(){
        given().post("http://111.229.65.252:8801/cases/case/getCount");
    }
}
