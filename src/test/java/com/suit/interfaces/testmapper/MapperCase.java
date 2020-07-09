package com.suit.interfaces.testmapper;

import com.suit.interfaces.InterfaceSuitApplication;
import com.suit.interfaces.dao.ParamsMapper;
import com.suit.interfaces.entity.InterfaceParams;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;

import static io.restassured.RestAssured.given;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = InterfaceSuitApplication.class)
@WebAppConfiguration
public class MapperCase {

    @Resource
    private ParamsMapper paramsMapper ;
    @Test
    public void queryPramsInfo(){
        List<InterfaceParams> paramsList = paramsMapper.selectByParamsList(0);
        for(Iterator it = paramsList.iterator();it.hasNext();){
            System.out.println(it.next());
        }
    }

    @Test
    public void testone(){
        given()
                .when().log().all()
                .get("http://127.0.0.1:8089/interface/query?suitId=6")
                .then().log().all().extract().response()
                .toString();
    }
}
