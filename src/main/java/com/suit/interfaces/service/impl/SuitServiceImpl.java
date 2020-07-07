package com.suit.interfaces.service.impl;

import com.suit.interfaces.dao.TestSuitMapper;
import com.suit.interfaces.entity.TestSuit;
import com.suit.interfaces.service.SuitService;
import net.bytebuddy.implementation.bytecode.Throw;
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
    public Boolean updateTestSuit(TestSuit testSuit) {
        //查询用例集是否存在
        if(Objects.isNull(testSuitMapper.selectById(testSuit.getId()))){
            throw new RuntimeException("要修改套件不存在");
        }
        testSuit.setUpdateTime(new Date());
        return testSuitMapper.updateByPrimaryKeySelective(testSuit);
    }
    @Override
    public Boolean saveSuit(TestSuit testSuit) {
        //查询用例集是否存在
        if(!Objects.isNull(testSuitMapper.selectBySuitName(testSuit.getSuitName()) )){
            return false;
        }
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
    @Override
    public List<TestSuit> findByList() {
        return testSuitMapper.selectSuitList();
    }

    @Override
    public TestSuit queryInsterfaceId(Integer id) {
        return testSuitMapper.selectById(id);
    }
}
