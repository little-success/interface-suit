package com.suit.interfaces.dao;

import com.suit.interfaces.entity.TestSuit;

public interface TestSuitMapper {

    int insertSelective(TestSuit record);

    TestSuit selectBySuitName(String suitName);
}
