package com.suit.interfaces.testUtil;



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
    public void parseJson(){
        object.put("111","222");
        System.out.println(object);
        String string = object.toString();
        System.out.println(string);
    }

    @Test
    public void parseString(){
        object.put("111","222");
        String string = JsonParseUtil.parseJson(object);
        System.out.println(string);

    }

}
