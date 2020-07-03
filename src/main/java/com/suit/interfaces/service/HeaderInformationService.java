package com.suit.interfaces.service;

import com.suit.interfaces.entity.HeaderInformation;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * <p>
 *
 * </p>
 *
 * @author gongxc
 * @date 2020/7/3
 */
@Service
public interface HeaderInformationService {
    long getCount();

    List<HeaderInformation> findAll();

    HeaderInformation save(HeaderInformation headerInformation);

    Optional<HeaderInformation> findHeaderInformationById(Long id);

    void change(Long id,String headerName,String headerInfo);

    void deleteById(Long id);
}
