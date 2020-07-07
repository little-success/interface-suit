package com.suit.interfaces.controller;

import com.suit.interfaces.common.ResponseResult;
import com.suit.interfaces.entity.TestSuit;
import com.suit.interfaces.service.SuitService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/suit")
@Api(value = "用例集相关接口", tags = { "用例集相关接口" })
public class SuitController {

    @Autowired
    private SuitService suitService;

    @PostMapping(value = "/add")
    @ApiOperation(value = "新增套件")
    @ApiResponses({
            @ApiResponse(code = 200,message = "成功！"),
            @ApiResponse(code = 401,message = "未授权"),
            @ApiResponse(code = 404,message = "请求路径不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    public ResponseResult addSuit(@Validated @RequestBody TestSuit testSuit){
            return ResponseResult.successWithData(suitService.saveSuit(testSuit));
    }

    @PostMapping("/update")
    @ApiResponses({
            @ApiResponse(code = 200,message = "成功！"),
            @ApiResponse(code = 401,message = "未授权"),
            @ApiResponse(code = 404,message = "请求路径不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    public ResponseResult updateSuit(@Validated @RequestBody TestSuit testSuit){
            return ResponseResult.successWithData(suitService.updateTestSuit(testSuit));
    }

    @PostMapping("/find")
    public ResponseResult querySuit(@Validated @RequestBody TestSuit testSuit){
        return ResponseResult.successWithData(suitService.querySuitItem(testSuit));
    }

    @PostMapping("/findName")
    public ResponseResult querySuitName(@Validated @RequestBody TestSuit testSuit){
        return ResponseResult.successWithData(suitService.querySuitName(testSuit.getSuitName()));
    }

    @PostMapping("/findBusinessType")
    public ResponseResult queryBussnessType(@Validated @RequestBody TestSuit testSuit){
        return ResponseResult.successWithData(suitService.queryBusinessType(testSuit.getBusinessType()));
    }

    @GetMapping("/findList")
    @ApiOperation(value = "查询列表")
    public ResponseResult findList(){
        return ResponseResult.successWithData(suitService.findByList());
    }

    @PostMapping("/findId")
    @ApiOperation(value = "查询套件id")
    public ResponseResult queryId(@RequestParam Integer id){
        return ResponseResult.successWithData(suitService.queryInsterfaceId(id));
    }
}
