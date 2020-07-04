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
    @ApiOperation(value = "删除信息头")
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

    @GetMapping("/findByName")
    @ApiOperation(value = "通过header标题查找")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "header_name",name = "headerName",dataType = "String",defaultValue = "String")
    })
    @ApiResponses({
            @ApiResponse(code = 200,message = "成功！"),
            @ApiResponse(code = 401,message = "未授权"),
            @ApiResponse(code = 404,message = "请求路径不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    public ResponseResult<Optional<HeaderInformation>> findByName(String headerName){
        Optional<HeaderInformation> headerInformation = headerInformationService.findByName(headerName);
        return ResponseResult.successWithData(headerInformation);
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
        try {
            HeaderInformation headerInformation1 = headerInformationService.save(headerInformation);
            return ResponseResult.successWithData(headerInformation1);

        }catch (Exception e){
            return ResponseResult.failWithCodeAndMsg(500,"新增失败");
        }

    }



    @PostMapping("/changeHeader")
    @ApiOperation(value = "更新信息头")
    @ApiResponses({
            @ApiResponse(code = 200,message = "成功！"),
            @ApiResponse(code = 401,message = "未授权"),
            @ApiResponse(code = 404,message = "请求路径不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    public ResponseResult<Optional<HeaderInformation>> changeHeader(Long id,@Validated @RequestBody HeaderInformation headerInformation){
        headerInformationService.change(id,headerInformation);
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


    @PostMapping("/findByType")
    @ApiOperation(value = "通过类型查询信息头")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "header_type", name = "headerType", dataType = "String", required = true, defaultValue = "String")
    })
    @ApiResponses({
            @ApiResponse(code = 200,message = "成功！"),
            @ApiResponse(code = 401,message = "未授权"),
            @ApiResponse(code = 404,message = "请求路径不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    public ResponseResult<List<HeaderInformation>> findByType(String headerType){
        List<HeaderInformation> headers = headerInformationService.findByType(headerType);
        return ResponseResult.successWithData(headers);
    }
}
