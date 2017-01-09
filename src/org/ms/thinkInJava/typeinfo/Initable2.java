package org.ms.thinkInJava.typeinfo;

/**
 * Created by Administrator on 2017/1/9.
 */
public class Initable2 {
    public static int staticNonFinal = 147;

    static {
        System.out.println("Initializing Initable2");
    }
}
