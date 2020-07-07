package com.suit.interfaces.service;

import com.suit.interfaces.entity.TestSuit;

import java.util.List;

public interface SuitService {
    Boolean saveSuit(TestSuit ts );

    Boolean updateTestSuit(TestSuit testSuit);

    List<TestSuit> querySuitItem(TestSuit testSuit);

    TestSuit querySuitName(String suitName);

    List<TestSuit> queryBusinessType(Integer businessType);

    List<TestSuit> findByList();

    TestSuit queryInsterfaceId(Integer id);

}
