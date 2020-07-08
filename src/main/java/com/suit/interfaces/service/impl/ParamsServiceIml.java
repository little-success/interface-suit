package com.suit.interfaces.service.impl;

import com.suit.interfaces.dao.ParamsMapper;
import com.suit.interfaces.entity.InterfaceParams;
import com.suit.interfaces.service.ParamsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ParamsServiceIml implements ParamsService {
    @Resource
    private ParamsMapper paramsMapper;
    @Override
    public Boolean addByParams(InterfaceParams interfaceParams) {
        return paramsMapper.insertByParams(interfaceParams);
    }

    @Override
    public Boolean delByParams(Integer id) {
        return paramsMapper.deleteByParams(id);
    }

    @Override
    public Boolean updateByParams(InterfaceParams interfaceParams) {
        return paramsMapper.updateByParams(interfaceParams);
    }

    @Override
    public List<InterfaceParams> queryByParams(Integer interfaceId) {
        List<InterfaceParams> paramsList = paramsMapper.selectByParamsList(interfaceId);
        return paramsList;
    }
}
