package com.suit.interfaces.service.impl;

import com.suit.interfaces.dao.InterfaceMapper;
import com.suit.interfaces.entity.InterfaceDetails;
import com.suit.interfaces.service.InterfaceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class InterfaceServiceIml implements InterfaceService {
    @Resource
    private InterfaceMapper interfaceMapper;
    @Override
    public Boolean addInterface(InterfaceDetails interfaceDetails) {
        if(!Objects.isNull(interfaceMapper.selectByInterfaceName(interfaceDetails.getInterfaceName()))){
            return false;
        }
        interfaceDetails.setCreateTime(new Date());
        return interfaceMapper.addByInterface(interfaceDetails);
    }

    @Override
    public Boolean updateInterface(InterfaceDetails interfaceDetails) {
        if(Objects.isNull(interfaceMapper.selectById(interfaceDetails.getId()))){
            throw new RuntimeException("要修改的接口不存在");
        }
        if(!Objects.isNull(interfaceMapper.selectByInterfaceBesidesName(interfaceDetails.getId(),interfaceDetails.getInterfaceName()))){
            throw new RuntimeException("名称已存在,请重新修改");
        }
        interfaceDetails.setUpdateTime(new Date());
        return interfaceMapper.updateByInterface(interfaceDetails);
    }

    @Override
    public InterfaceDetails queryInterfaceName(String InterfaceName) {
        return interfaceMapper.selectByInterfaceName(InterfaceName);
    }

    @Override
    public List<InterfaceDetails> queryInsterList(Integer suitId) {
        return interfaceMapper.selectByInterface(suitId);
    }

    @Override
    public Boolean deleleInterface(Integer id) {
        return interfaceMapper.delByInterface(id);
    }

}
