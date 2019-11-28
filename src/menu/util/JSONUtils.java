package menu.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class JSONUtils {
    public String main(String json, String string){
        JSONObject jsonObject = JSON.parseObject(String.valueOf(json));
        String string1 = jsonObject.getString(string);
        return string1;
    }
}
