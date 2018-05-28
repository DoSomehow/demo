package org.ms.javaTest;

import java.util.HashMap;
import java.util.Map;

public class TestClassCast {

    public static void main(String[] args) {
        nullMapValueCast2String();
    }

    //map空值转换为String
    private static void  nullMapValueCast2String(){
        Map<String, Object> map = new HashMap<>();
        map.put("test", "test");
        String num = (String) map.get("RANDON_NUM");  //不报错
        // String num = map.get("RANDON_NUM").toString();  //报错
        System.out.println("num: " + num);
    }

}
