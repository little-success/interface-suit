package com.suit.interfaces.controller;

import com.suit.interfaces.common.ResponseResult;
import com.suit.interfaces.entity.BusinessType;
import com.suit.interfaces.service.BusinessTypeService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * <p>
 *
 * </p>
 *
 * @author gongxc
 * @date 2020/7/8
 */
@RestController
@RequestMapping(value = "/business",produces = "application/json")
@Api(value="businessType",tags = {"业务类型"}, description = "业务类型")
public class BusinessTypeController {
    @Autowired
    private BusinessTypeService businessTypeService;

    @GetMapping("/findBusinessType")
    @ApiOperation(value = "使用id查询业务类型")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "ID",name = "id",dataType = "long",required = true,defaultValue = "1")
    })
    @ApiResponses({
            @ApiResponse(code = 200,message = "成功！"),
            @ApiResponse(code = 401,message = "未授权"),
            @ApiResponse(code = 404,message = "请求路径不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    public ResponseResult<Optional<BusinessType>> findBusinessType(Long id){

        Optional<BusinessType> businessType= businessTypeService.findById(id);
        return ResponseResult.successWithData(businessType);
    }


    @GetMapping("/findAllBusinessTypes")
    @ApiOperation(value = "查询所有业务类型")
    @ApiResponses({
            @ApiResponse(code = 200,message = "成功！"),
            @ApiResponse(code = 401,message = "未授权"),
            @ApiResponse(code = 404,message = "请求路径不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    public ResponseResult<List<BusinessType>> findAllBusinessTypes(){
        List<BusinessType> all = businessTypeService.findAll();
        return ResponseResult.successWithData(all);
    }

    @PostMapping("/saveBusinessType")
    @ApiOperation(value = "保存业务类型")
    @ApiResponses({
            @ApiResponse(code = 200,message = "成功！"),
            @ApiResponse(code = 401,message = "未授权"),
            @ApiResponse(code = 404,message = "请求路径不存在"),
            @ApiResponse(code = 5000, message = "保存失败"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    public ResponseResult saveBusinessType(@Validated @RequestBody BusinessType businessType){
        boolean bool = businessTypeService.saveBusinessType(businessType);
        if(bool){
            Optional<BusinessType> one = businessTypeService.findById(businessType.getId());
            return ResponseResult.successWithData(one);
        }
        return ResponseResult.failWithCodeAndMsg(5000,"保存失败");
    }


    @PostMapping("/changeBusinessType")
    @ApiOperation(value = "修改业务类型")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "ID",name = "id",dataType = "int",required = true,defaultValue = "1"),
            @ApiImplicitParam(value = "type_name",name = "typeName",dataType = "String",required = true,defaultValue = "功能类型"),
    })
    @ApiResponses({
            @ApiResponse(code = 200,message = "成功！"),
            @ApiResponse(code = 401,message = "未授权"),
            @ApiResponse(code = 404,message = "请求路径不存在"),
            @ApiResponse(code = 5000, message = "未查到该类型"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    public ResponseResult changeBusinessType(Long id,String typeName){
        boolean bool = businessTypeService.changeBusinessType(id,typeName);
        if(bool){
            Optional<BusinessType> one = businessTypeService.findById(id);
            return ResponseResult.successWithData(one);
        }
        return ResponseResult.failWithCodeAndMsg(5000,"未查到该类型");
    }


    @PostMapping("/delBusinessType")
    @ApiOperation(value = "删除业务类型")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "ID",name = "id",dataType = "long",required = true,defaultValue = "1")
    })
    @ApiResponses({
            @ApiResponse(code = 200,message = "成功！"),
            @ApiResponse(code = 401,message = "未授权"),
            @ApiResponse(code = 404,message = "请求路径不存在"),
            @ApiResponse(code = 5000, message = "未查到该类型"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    public ResponseResult delBusinessType(Long id){
        boolean bool = businessTypeService.deleteById(id);
        if(bool){
            return ResponseResult.successWithData(bool);
        }
        return ResponseResult.failWithCodeAndMsg(5000,"未查到该类型");
    }

}
