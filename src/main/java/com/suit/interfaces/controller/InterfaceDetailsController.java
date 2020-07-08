package com.suit.interfaces.controller;

import com.suit.interfaces.common.ResponseResult;
import com.suit.interfaces.entity.InterfaceDetails;
import com.suit.interfaces.service.InterfaceService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/interface")
@Api(value="hosts",tags = {"接口信息"}, description = "接口信息")
public class InterfaceDetailsController {

    @Autowired
    private InterfaceService interfaceService;

    @PostMapping("/add")
    public ResponseResult addInterface(@RequestBody InterfaceDetails interfaceDetails){
        return interfaceService.addInterface(interfaceDetails)?ResponseResult.success():ResponseResult.failWithCodeAndMsg(5001,"名称已存在");
    }

    @PostMapping("/updata")
    public ResponseResult uodataInterface(@RequestBody InterfaceDetails interfaceDetails){
        return  ResponseResult.successWithData(interfaceService.updateInterface(interfaceDetails));
    }

    @PostMapping("/del")
    public ResponseResult delInterface(@RequestParam Integer id){
        return ResponseResult.successWithData(interfaceService.deleleInterface(id));
    }

    @GetMapping("/query")
    public ResponseResult queryInterface(@RequestParam Integer suitId){
        return ResponseResult.successWithData(interfaceService.queryInsterList(suitId));
    }

}
