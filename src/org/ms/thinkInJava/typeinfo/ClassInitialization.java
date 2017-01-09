package org.ms.thinkInJava.typeinfo;

import java.util.Random;

/**
 * Created by Administrator on 2017/1/9.
 */
public class ClassInitialization {
    public static Random rand = new Random(47);

    public static void main(String[] args) throws ClassNotFoundException {
        Class initable = Initable.class;
        System.out.println("After creating Initable ref");
        System.out.println(Initable.staticFinal);  //不触发初始化
        System.out.println(Initable.staticFinal2);  //不触发初始化
        System.out.println(Initable2.staticNonFinal);  //不触发初始化
        Class initable3 = Class.forName("org.ms.thinkInJava.typeinfo.Initable3");
        System.out.println("After creating Initable3 ref");
        System.out.println(Initable3.staticNonFinal);
    }
}
