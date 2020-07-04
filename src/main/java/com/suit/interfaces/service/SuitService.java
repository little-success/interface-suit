package com.suit.interfaces.service;

import com.suit.interfaces.entity.TestSuit;
import com.suit.interfaces.entity.TestSuitSave;

import java.util.List;

public interface SuitService {
    boolean saveSuit(TestSuit ts );

    boolean updataTestSuit(TestSuit testSuit);

    List<TestSuit> querySuitItem(TestSuit testSuit);

    TestSuit querySuitName(String suitName);

    List<TestSuit> queryBusinessType(Integer businessType);
}
