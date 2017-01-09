package org.ms.thinkInJava.typeinfo;

/**
 * Created by Administrator on 2017/1/9.
 */
public class Initable3 {
    public static int staticNonFinal = 74;
    static {
        System.out.println("Initializing Initable3");
    }
}
