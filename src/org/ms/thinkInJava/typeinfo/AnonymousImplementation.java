package org.ms.thinkInJava.typeinfo;

import org.ms.thinkInJava.typeinfo.interfacea.A;

/**
 * Created by Administrator on 2017/1/15.
 */
public class AnonymousImplementation {
    public static void main(String[] args) {
        A a = AnonymousA.makeA();
        a.f();
        System.out.println(a.getClass().getName());
        //Reflection still gets into the anonymous class;
        try {
            HiddenImplementation.callHiddenMethod(a, "g");
            HiddenImplementation.callHiddenMethod(a, "u");
            HiddenImplementation.callHiddenMethod(a, "v");
            HiddenImplementation.callHiddenMethod(a, "w");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
