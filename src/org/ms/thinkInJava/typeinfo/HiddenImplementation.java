package org.ms.thinkInJava.typeinfo;

import org.ms.thinkInJava.typeinfo.interfacea.A;
import org.ms.thinkInJava.typeinfo.packageaccess.HiddenC;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/1/15.
 */
public class HiddenImplementation {
    static void callHiddenMethod(Object a, String methodName) throws Exception{
        Method g = a.getClass().getDeclaredMethod(methodName);
        g.setAccessible(true);
        g.invoke(a);
    }

    public static void main(String[] args) {
        A a = HiddenC.makeA();
        a.f();
        System.out.println(a.getClass().getName());
        //Compile error: cannot find symbol 'C'
        // if(a instanceof C){
        //     C c = (C)a;
        //     c.g();
        // }

        try {
            //Reflection still allows us to call g()
            callHiddenMethod(a,"g");
            //And even methods that are less accessible!
            callHiddenMethod(a, "u");
            callHiddenMethod(a, "v");
            callHiddenMethod(a, "w");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
