package com.suit.interfaces.service.impl;

import com.suit.interfaces.dao.BusinessTypeRepository;
import com.suit.interfaces.entity.BusinessType;
import com.suit.interfaces.service.BusinessTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * <p>
 *
 * </p>
 *
 * @author gongxc
 * @date 2020/7/8
 */
@Service
public class BusinessTypeServiceImpl implements BusinessTypeService {
    @Autowired
    private BusinessTypeRepository businessTypeRepository;

    @Override
    public boolean saveBusinessType(BusinessType businessType) {
        try{
            businessType.setCreateTime(new Date());
            businessType.setUpdateTime(new Date());
            businessTypeRepository.save(businessType);
            return true;
        }catch (Exception e){

            return false;
        }

    }

    @Override
    public boolean changeBusinessType(Long id, String typeName) {
        if(businessTypeRepository.existsById(id)){
            Date updateTime = new Date();
            businessTypeRepository.change(id,typeName,updateTime);
            return true;
        }
        return false;
    }

    @Override
    public List<BusinessType> findAll() {
        List<BusinessType> businessTypes = businessTypeRepository.findAll();
        return businessTypes;
    }

    @Override
    public Optional<BusinessType> findById(Long id) {
        Optional<BusinessType> businessType = businessTypeRepository.findById(id);
        return businessType;
    }

    @Override
    public boolean deleteById(Long id) {
        if(businessTypeRepository.existsById(id)){
            businessTypeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
