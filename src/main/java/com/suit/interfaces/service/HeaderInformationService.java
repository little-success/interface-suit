package com.suit.interfaces.service;

import com.suit.interfaces.entity.HeaderInformation;
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
 * @date 2020/7/3
 */
@Service
public interface HeaderInformationService {
    long getCount();

    List<HeaderInformation> findAll();

    List<HeaderInformation> findByType(String headerType);

    HeaderInformation save(HeaderInformation headerInformation);

    Optional<HeaderInformation> findHeaderInformationById(Long id);

    Optional<HeaderInformation> findByName(String headerName);

    void change(Long id, HeaderInformation headerInformation);

    void deleteById(Long id);
}
