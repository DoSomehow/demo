package org.ms.thinkInJava.typeinfo;

import org.ms.thinkInJava.typeinfo.interfacea.A;

/**
 * Created by Administrator on 2017/1/15.
 */
public class InterfaceViolation {
    public static void main(String[] args) {
        A a = new B();
        a.f();
        // a.g();  //Compile error
        System.out.println(a.getClass().getName());
        if(a instanceof B){
            B b = (B)a;
            b.g();
        }
    }
}
