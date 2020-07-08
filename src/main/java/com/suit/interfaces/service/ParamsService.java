package com.suit.interfaces.service;

import com.suit.interfaces.entity.InterfaceParams;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ParamsService {

    List<InterfaceParams> queryByParams(Integer interfaceId);

    Boolean addByParams(InterfaceParams interfaceParams);

    Boolean delByParams(Integer id);

    Boolean updateByParams(InterfaceParams interfaceParams);
}
