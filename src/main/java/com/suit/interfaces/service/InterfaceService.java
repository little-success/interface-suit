package com.suit.interfaces.service;

import com.suit.interfaces.entity.InterfaceDetails;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface InterfaceService {
    Boolean addInterface(InterfaceDetails interfaceDetails);

    Boolean updateInterface(InterfaceDetails interfaceDetails);

    InterfaceDetails queryInterfaceName(String InterfaceName);

    List<InterfaceDetails> queryInsterList(Integer suitId);

    Boolean deleleInterface(Integer id);

}
