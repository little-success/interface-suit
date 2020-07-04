package com.suit.interfaces.service.impl;

import com.suit.interfaces.dao.TestSuitMapper;
import com.suit.interfaces.entity.TestSuit;
import com.suit.interfaces.service.SuitService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Objects;


@Service
public class SuitServiceImpl implements SuitService {


    @Resource
    private TestSuitMapper testSuitMapper ;

    @Override
    public boolean updataTestSuit(TestSuit ts) {
        //查询用例集是否存在
        TestSuit testSuit = new TestSuit();
        if(!Objects.isNull(testSuitMapper.selectBySuitName(testSuit.getSuitName()))){
            return false;
        }
        testSuit.setSuitName(ts.getSuitName());
        testSuit.setBusinessType(ts.getBusinessType());
        testSuit.setDescribes(ts.getDescribes());
        testSuit.setUpdateTime(new Date());
        return testSuitMapper.updateByPrimaryKeySelective(testSuit)>0;
    }
    @Override
    public boolean saveSuit(TestSuit ts) {
        //查询用例集是否存在
        TestSuit testSuit = new TestSuit();
        if(!Objects.isNull(testSuitMapper.selectBySuitName(ts.getSuitName()) )){
            return false;
//            throw new RuntimeException("名称已存在，请重新输入");
        }
        testSuit.setSuitName(ts.getSuitName());
        testSuit.setBusinessType(ts.getBusinessType());
        testSuit.setDescribes(ts.getDescribes());
        testSuit.setCreateTime(new Date());
        return testSuitMapper.insertSelective(testSuit)>0;
    }

    @Override
    public List<TestSuit> querySuitItem(TestSuit testSuit) {
        List<TestSuit> ts = testSuitMapper.querySuitItem(testSuit);
        return ts;
    }

    @Override
    public List<TestSuit> queryBusinessType(Integer businessType) {
        List<TestSuit> list = testSuitMapper.selectByBusinessType(businessType);
        return list;
    }

    @Override
    public TestSuit querySuitName(String suitName) {
        TestSuit list = testSuitMapper.selectBySuitName(suitName);
        return list;
    }
}
