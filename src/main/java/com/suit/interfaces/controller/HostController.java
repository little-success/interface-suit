package com.suit.interfaces.controller;

import com.suit.interfaces.common.ResponseResult;
import com.suit.interfaces.entity.HeaderInformation;
import com.suit.interfaces.entity.Hosts;
import com.suit.interfaces.service.HostsService;
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
 * @date 2020/7/7
 */
@RestController
@RequestMapping(value = "/host",produces = "application/json")
@Api(value="hosts",tags = {"域名信息"}, description = "域名信息")
public class HostController {
    @Autowired
    private HostsService hostsService;


    @GetMapping("/findHost")
    @ApiOperation(value = "使用id查询域名信息")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "ID",name = "id",dataType = "long",required = true,defaultValue = "1")
    })
    @ApiResponses({
            @ApiResponse(code = 200,message = "成功！"),
            @ApiResponse(code = 401,message = "未授权"),
            @ApiResponse(code = 404,message = "请求路径不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    public ResponseResult<Optional<Hosts>> findHost(Long id){

        Optional<Hosts> host= hostsService.findById(id);
        return ResponseResult.successWithData(host);
    }

    @GetMapping("/findHosts")
    @ApiOperation(value = "查询所有域名信息")
    @ApiResponses({
            @ApiResponse(code = 200,message = "成功！"),
            @ApiResponse(code = 401,message = "未授权"),
            @ApiResponse(code = 404,message = "请求路径不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    public ResponseResult<List<Hosts>> findAllHosts(){
        List<Hosts> hosts = hostsService.findAll();
        return ResponseResult.successWithData(hosts);
    }

    @PostMapping("/saveHost")
    @ApiOperation(value = "保存域名信息")
    @ApiResponses({
            @ApiResponse(code = 200,message = "成功！"),
            @ApiResponse(code = 401,message = "未授权"),
            @ApiResponse(code = 404,message = "请求路径不存在"),
            @ApiResponse(code = 5000, message = "保存失败"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    public ResponseResult saveHost(@Validated @RequestBody Hosts host){
        Boolean bool = hostsService.saveHost(host);
        if(bool){
            return ResponseResult.successWithData(hostsService.findById(host.getId()));
        }else {
            return ResponseResult.failWithCodeAndMsg(5000,"保存失败");
        }
    }

    @PostMapping("/changeHost")
    @ApiOperation(value = "修改域名信息")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "ID",name = "id",dataType = "long",required = true,defaultValue = "1"),
            @ApiImplicitParam(value = "host",name = "host",dataType = "String",required = true,defaultValue = "http://www.example.com")
    })
    @ApiResponses({
            @ApiResponse(code = 200,message = "成功！"),
            @ApiResponse(code = 401,message = "未授权"),
            @ApiResponse(code = 404,message = "请求路径不存在"),
            @ApiResponse(code = 5000, message = "未查到该域名"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    public ResponseResult changeHost(Long id,String host){
        Boolean bool = hostsService.changeHost(id,host);
        if(bool){
            return ResponseResult.successWithData(hostsService.findById(id));
        }else {
            return ResponseResult.failWithCodeAndMsg(5000,"未查到该域名");
        }
    }

    @GetMapping("/delete")
    @ApiOperation(value = "删除域名")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "ID",name = "id",dataType = "int",required = true,defaultValue = "1")
    })
    @ApiResponses({
            @ApiResponse(code = 200,message = "成功！"),
            @ApiResponse(code = 401,message = "未授权"),
            @ApiResponse(code = 404,message = "请求路径不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    public ResponseResult delHost(Long id){
        if (hostsService.deleteById(id)){
            List<Hosts> hosts =hostsService.findAll();
            return ResponseResult.successWithData(hosts);
        }else {
            return ResponseResult.failWithCodeAndMsg(50000,"未查到该域名");
        }


    }
}
