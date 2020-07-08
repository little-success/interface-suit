package com.suit.interfaces.testUtil;

import com.suit.interfaces.service.HeaderInformationService;
import org.junit.Test;

import java.util.Optional;

/**
 * <p>
 *
 * </p>
 *
 * @author gongxc
 * @date 2020/7/4
 */

public class TestHeaderInformationService {
    public HeaderInformationService headerInformationService;
    @Test
    public void testOptional(){
        Optional optional = headerInformationService.findByName("string1");
        System.out.println(optional.hashCode());
    }
}
