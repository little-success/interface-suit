package com.suit.interfaces.util;
import com.alibaba.fastjson.JSON;
import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;

import java.io.*;
public class JsonParseUtil {
    /**

     */
//    public static String jsonToString(JSON entity) throws IOException {
//        HttpEntity httpEntity = entity.toJSONString();
//        EntityUtils.toString(entity, "UTF-8");
//       return content;
//    }



    public static String parseJson(JSON json){
        return json.toString();
    }


}
