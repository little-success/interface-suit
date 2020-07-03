package com.suit.inTerface.testUtil;



import com.alibaba.fastjson.JSONObject;
import com.suit.interfaces.util.JsonParseUtil;
import org.junit.Test;


/**
 * <p>
 *
 * </p>
 *
 * @author gongxc
 * @date 2020/7/3
 */

public class TestJsonParseUtil {
    JSONObject object = new JSONObject();
    @Test
    void parseJson(){
        object.put("111","222");
        System.out.println(object);
    }


}
