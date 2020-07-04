package com.suit.interfaces.dao;

import com.suit.interfaces.entity.TestSuit;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestSuitMapper {

    int insertSelective(TestSuit record);

    TestSuit selectBySuitName(String suitName);

    int updateByPrimaryKeySelective(TestSuit testSuit);

    List<TestSuit> querySuitItem(TestSuit testSuit);

    List<TestSuit> selectByBusinessType(Integer type);
}
