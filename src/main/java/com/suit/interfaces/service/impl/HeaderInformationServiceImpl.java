package com.suit.interfaces.service.impl;

import com.suit.interfaces.dao.HeaderInformationRepository;
import com.suit.interfaces.entity.HeaderInformation;
import com.suit.interfaces.service.HeaderInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    public HeaderInformation save(HeaderInformation headerInformation) {
        return headerInformationRepository.save(headerInformation);
    }

    @Override
    public Optional<HeaderInformation> findHeaderInformationById(Long id) {
        return headerInformationRepository.findById(id);
    }

    @Override
    public void change(Long id, String headerName, String headerInfo) {
        headerInformationRepository.change(id,headerName,headerInfo);
    }

    @Override
    public void deleteById(Long id) {
        headerInformationRepository.deleteById(id);
    }
}
