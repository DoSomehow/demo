package org.ms.thinkInJava.generics;

/**
 * Created by Ryan on 2017/5/31.
 */
public class ErasureAndInheritance {

    @SuppressWarnings("unchecked")   //通过注解来关闭警告
    public static void main(String[] args) {
        Derived2 d2 = new Derived2();
        Object obj = d2.get();
        d2.set(obj);  //Warning here!
    }

}
