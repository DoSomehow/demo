package org.ms.javaTest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/4 0004.
 */
public class TestString {

    public static void main(String[] args) {
        // test();
        // testValueOf();
        getLengthWithChinese();
    }

    //获取带中文的字符串的长度
    public static void getLengthWithChinese(){
        String str = "abc, 哈哈哈， 123";
        int length = 0;
        String chinese = "[\u0391-\uFFE5]";
        /* 获取字段值的长度，如果含中文字符，则每个中文字符长度为2，否则为1 */
        for (int i = 0; i < str.length(); i++) {
            /* 获取一个字符 */
            String temp = str.substring(i, i + 1);
            /* 判断是否为中文字符 */
            if (temp.matches(chinese)) {
                /* 中文字符长度为2 */
                length += 2;
            } else {
                /* 其他字符长度为1 */
                length += 1;
            }
        }
        System.out.println("Length: " + length);
    }

    public static void testValueOf(){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("key", "");
        String value = String.valueOf(map.get("key"));
        System.out.println("value: " + value);
    }

    public static void test(){
        String a = "Hello";
        String b = a;
        System.out.println(a == b);
        a = a.toLowerCase();  //String是final的，这些操作肯定会重新生成一个字符串
        System.out.println(a);
        System.out.println(b);
    }
}
