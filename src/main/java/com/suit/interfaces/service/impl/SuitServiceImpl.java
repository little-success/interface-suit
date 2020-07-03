package com.suit.interfaces.service.impl;

import com.suit.interfaces.dao.TestSuitMapper;
import com.suit.interfaces.entity.TestSuit;
import com.suit.interfaces.service.SuitService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


public class SuitServiceImpl implements SuitService {
    @Autowired
    private TestSuitMapper testSuitMapper ;

    @Override
    public boolean saveSuit(TestSuit ts) {
        //查询用例集是否存在
        TestSuit testSuit = testSuitMapper.selectBySuitName(ts.getSuitName());
        List<TestSuit> testSuits = Collections.singletonList(testSuit);
        if(testSuit != null ){
            throw new RuntimeException("用例集已存在，请重新输入");
        }
        testSuit.setSuitName(ts.getSuitName());
        testSuit.setBusinessType(ts.getBusinessType());
        testSuit.setDescribe(ts.getDescribe());
        testSuit.setCreateTime(new Date());
        return testSuitMapper.insertSelective(testSuit)>0;

    }
}
