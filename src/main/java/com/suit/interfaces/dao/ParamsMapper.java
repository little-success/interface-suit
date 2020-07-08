package com.suit.interfaces.dao;

import com.suit.interfaces.entity.InterfaceParams;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ParamsMapper {
    Boolean updateByParams(InterfaceParams interfaceParams);

    Boolean insertByParams(InterfaceParams interfaceParams);

    Boolean deleteByParams(Integer id);

    List<InterfaceParams> selectByParamsList(Integer interfaceId);
}
