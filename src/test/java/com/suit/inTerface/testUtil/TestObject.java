package com.suit.inTerface.testUtil;

import com.suit.interfaces.dao.HostRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * <p>
 *
 * </p>
 *
 * @author gongxc
 * @date 2020/7/7
 */

public class TestObject {


    private HostRepository hostRepository;
    @Test
    public void testObject(){
        class Dog{
            String name;

            public String getName() {
                return name;
            }
        }

        Optional<Dog> optional = null;

        if(Objects.isNull(optional)){
            System.out.println("aaa");
        }else {
            System.out.println("bbb");
        }
    }

}
