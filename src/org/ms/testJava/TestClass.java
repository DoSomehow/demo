package org.ms.testJava;

import org.ms.testJava.entity.Wang;

/**
 * Created by Administrator on 2017/1/8.
 */
public class TestClass {

    public static void main(String[] args) {
        testGetClass();
    }

    public static void testGetClass(){
        Class wc = null;
        try {
            wc = Class.forName("org.ms.testJava.entity.Wang");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Wang w = new Wang();
        Class wc2 = w.getClass();

        System.out.println(wc == wc2);  //true
    }

}
