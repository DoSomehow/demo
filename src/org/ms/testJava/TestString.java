package org.ms.testJava;

/**
 * Created by Administrator on 2017/2/4 0004.
 */
public class TestString {

    public static void main(String[] args) {
        String a = "Hello";
        String b = a;
        System.out.println(a == b);
        a = a.toLowerCase();  //String是final的，这些操作肯定会重新生成一个字符串
        System.out.println(a);
        System.out.println(b);
    }
}
