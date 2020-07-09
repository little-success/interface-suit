package com.suit.interfaces.testmapper;

import com.suit.interfaces.dao.ParamsMapper;
import com.suit.interfaces.entity.InterfaceParams;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;

public class MapperCase {

    private ParamsMapper paramsMapper ;
    @Test
    public void queryPramsInfo(){
        List<InterfaceParams> paramsList = paramsMapper.selectByParamsList(0);
        for(Iterator it = paramsList.iterator();it.hasNext();){
            System.out.println(it.next());
        }
    }
}
