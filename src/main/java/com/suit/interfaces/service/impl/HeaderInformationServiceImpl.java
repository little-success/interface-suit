package com.suit.interfaces.service.impl;

import com.suit.interfaces.dao.HeaderInformationRepository;
import com.suit.interfaces.entity.HeaderInformation;
import com.suit.interfaces.service.HeaderInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * <p>
 * 实现类
 * </p>
 *
 * @author gongxc
 * @date 2020/7/3
 */
@Service
public class HeaderInformationServiceImpl implements HeaderInformationService {

    @Autowired
    private HeaderInformationRepository headerInformationRepository;

    @Override
    public long getCount() {
        return headerInformationRepository.count();
    }

    @Override
    public List<HeaderInformation> findAll() {
        return headerInformationRepository.findAll();
    }

    @Override
    public List<HeaderInformation> findByType(String headerType) {
        return headerInformationRepository.findByType(headerType);
    }

    @Override
    public HeaderInformation save(HeaderInformation headerInformation) {
        headerInformation.setCreateTime(new Date());
        headerInformation.setUpdateTime(new Date());
        return headerInformationRepository.save(headerInformation);
    }

    @Override
    public Optional<HeaderInformation> findHeaderInformationById(Long id) {
        return headerInformationRepository.findById(id);
    }

    @Override
    public Optional<HeaderInformation> findByName(String headerName) {
        return Optional.ofNullable(headerInformationRepository.findByName(headerName));
    }

    @Override
    public void change(Long id,HeaderInformation headerInformation) {
        headerInformationRepository.change(id, headerInformation.getHeaderName(), headerInformation.getHeaderInfo(), headerInformation.getBusinessType(), new Date());

    }

    @Override
    public void deleteById(Long id) {
        headerInformationRepository.deleteById(id);
    }
}
