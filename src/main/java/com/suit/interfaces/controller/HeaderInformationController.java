package com.suit.interfaces.controller;

import com.suit.interfaces.common.ResponseResult;
import com.suit.interfaces.entity.HeaderInformation;
import com.suit.interfaces.service.HeaderInformationService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * <p>
 * 控制层
 * </p>
 *
 * @author gongxc
 * @date 2020/7/3
 */
@RestController
@RequestMapping(value = "/header",produces = "application/json")
@Api(value="header",tags = {"信息头"}, description = "信息头")
public class HeaderInformationController {
    @Autowired
    private HeaderInformationService headerInformationService;

    @GetMapping("/findHeaderById/{id}")
    @ApiOperation(value = "使用id查询信息头")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "ID",name = "id",dataType = "long",paramType = "path",required = true,defaultValue = "1")
    })
    @ApiResponses({
            @ApiResponse(code = 200,message = "成功！"),
            @ApiResponse(code = 401,message = "未授权"),
            @ApiResponse(code = 404,message = "请求路径不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    public ResponseResult<Optional<HeaderInformation>> findHeaderById(@PathVariable("id") Long id){

        Optional<HeaderInformation> headerInformation= headerInformationService.findHeaderInformationById(id);
        return ResponseResult.successWithData(headerInformation);
    }


    @GetMapping("/getCount")
    @ApiOperation(value = "查询信息头总数")
    @ApiResponses({
            @ApiResponse(code = 200,message = "成功！"),
            @ApiResponse(code = 401,message = "未授权"),
            @ApiResponse(code = 404,message = "请求路径不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    public ResponseResult getCount(){
        Long count = headerInformationService.getCount();
        return ResponseResult.successWithData(count);
    }


    @GetMapping("/delete")
    @ApiOperation(value = "删除用例")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "ID",name = "id",dataType = "int",required = true,defaultValue = "1")
    })
    @ApiResponses({
            @ApiResponse(code = 200,message = "成功！"),
            @ApiResponse(code = 401,message = "未授权"),
            @ApiResponse(code = 404,message = "请求路径不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    public ResponseResult<List<HeaderInformation>> deleteById(Long id){
        headerInformationService.deleteById(id);
        List<HeaderInformation> headers = headerInformationService.findAll();
        return ResponseResult.successWithData(headers);
    }


    @PostMapping("/saveHeader")
    @ApiOperation(value = "新增信息头")
    @ApiResponses({
            @ApiResponse(code = 200,message = "成功！"),
            @ApiResponse(code = 401,message = "未授权"),
            @ApiResponse(code = 404,message = "请求路径不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    public ResponseResult<HeaderInformation> saveHeader(@Validated @RequestBody HeaderInformation headerInformation){
        HeaderInformation headerInformation1 = headerInformationService.save(headerInformation);
        return ResponseResult.successWithData(headerInformation1);
    }



    @PostMapping("/changeHeader")
    @ApiOperation(value = "更新信息头")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "ID",name = "id",dataType = "int",required = true,defaultValue = "1"),
            @ApiImplicitParam(value = "header_name",name = "headerName",dataType = "String",required = true,defaultValue = ""),
            @ApiImplicitParam(value = "header_info",name = "headerInfo",dataType = "String",required = true,defaultValue = "{\"Content-Type\":\"application/json;charset=UTF-8\"}")
    })
    @ApiResponses({
            @ApiResponse(code = 200,message = "成功！"),
            @ApiResponse(code = 401,message = "未授权"),
            @ApiResponse(code = 404,message = "请求路径不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    public ResponseResult<Optional<HeaderInformation>> changeHeader(Long id,String headerName,String headerInfo){
        headerInformationService.change(id,headerName,headerInfo);
        Optional<HeaderInformation> header = headerInformationService.findHeaderInformationById(id);
        return ResponseResult.successWithData(header);
    }


    @PostMapping("/findAll")
    @ApiOperation(value = "查询所有信息头")
    @ApiResponses({
            @ApiResponse(code = 200,message = "成功！"),
            @ApiResponse(code = 401,message = "未授权"),
            @ApiResponse(code = 404,message = "请求路径不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    public ResponseResult<List<HeaderInformation>> findAll(){
        List<HeaderInformation> headers = headerInformationService.findAll();
        return ResponseResult.successWithData(headers);
    }
}
