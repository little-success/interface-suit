package com.suit.interfaces.controller;

import com.suit.interfaces.common.ResponseResult;
import com.suit.interfaces.entity.Querys;
import com.suit.interfaces.service.RunCaseService;
import io.restassured.response.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>
 * 执行用例
 * </p>
 *
 * @author gongxc
 * @date 2020/7/8
 */
@RestController
@RequestMapping(value = "/run",produces = "application/json")
@Api(value="run",tags = {"执行用例"}, description = "执行用例")
public class RunCaseController {
    @Autowired
    private RunCaseService runCaseService;

    @PostMapping("/runCase")
    @ApiOperation(value = "跑用例")
    public ResponseResult runInterface(@Validated @RequestBody Querys query){

        Response response = runCaseService.runCase(query.getMethod(), query.getUrl(), query.getHeaders(), query.getQuery(), query.getPostBody());
        System.out.println(response);
        return ResponseResult.success();
    }

    @PostMapping("/runPostCase")
    @ApiOperation(value = "跑用例")
    public ResponseResult runPostCase(String url, Map<String,Object> headers, Map postBody){

        Response response = runCaseService.runCasePost(url, headers, postBody);
        System.out.println(response);
        return ResponseResult.success();
    }




}
