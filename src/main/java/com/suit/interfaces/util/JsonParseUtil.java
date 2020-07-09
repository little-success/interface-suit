package com.suit.interfaces.util;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;

public class JsonParseUtil {

    public static String parseJson(JSONObject json){
        return json.toString();
    }

    public static Map parseToMap(String string){
        return (Map)JSONObject.parseObject(string);
    }

}
