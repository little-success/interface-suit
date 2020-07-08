package com.suit.interfaces.dao;

import com.suit.interfaces.entity.InterfaceDetails;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InterfaceMapper {
    Boolean addByInterface(InterfaceDetails interfaceDetails);

    Boolean updateByInterface(InterfaceDetails interfaceDetails);

    Boolean delByInterface(Integer id);

    List<InterfaceDetails> selectByInterface(Integer suit_id);

    InterfaceDetails selectByInterfaceName(String name);

    InterfaceDetails selectById(Integer id);

}
