package com.suit.interfaces.service;

import com.suit.interfaces.entity.BusinessType;
import org.springframework.stereotype.Service;

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
public interface BusinessTypeService {
    boolean saveBusinessType(BusinessType businessType);

    boolean changeBusinessType(Long id, String typeName);

    List<BusinessType> findAll();

    Optional<BusinessType> findById(Long id);

    boolean deleteById(Long id);
}
