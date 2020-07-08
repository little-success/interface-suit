package com.suit.interfaces.controller;

import com.suit.interfaces.common.ResponseResult;
import com.suit.interfaces.entity.InterfaceParams;
import com.suit.interfaces.service.ParamsService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(("/params"))
@Api(value="hosts",tags = {"接口参数"}, description = "接口参数")
public class InterfaceParamsController {
    @Autowired
    private ParamsService paramsService;

    @PostMapping("/add")
    public ResponseResult addParams(@RequestBody InterfaceParams interfaceParams){
        paramsService.addByParams(interfaceParams);
        return ResponseResult.success();
    }

    @PostMapping("/del")
    public ResponseResult delParams(@RequestParam Integer id){
        paramsService.delByParams(id);
        return ResponseResult.success();
    }

    @PostMapping("update")
    public ResponseResult updateParames(@RequestBody InterfaceParams interfaceParams){
        paramsService.updateByParams(interfaceParams);
        return ResponseResult.success();
    }
    @PostMapping("/queryList")
    public ResponseResult<List<InterfaceParams>> queryParames(@RequestParam Integer interfaceId){
        List<InterfaceParams> paramesList = paramsService.queryByParams(interfaceId);
        return ResponseResult.successWithData(paramesList);
    }
}
