package org.ms.thinkInJava.typeinfo;

import org.ms.thinkInJava.typeinfo.interfacea.A;

/**
 * Created by Administrator on 2017/1/15.
 */
public class B implements A {
    @Override
    public void f() {
        System.out.println("B.f()");
    }

    public void g(){
        System.out.println("B.g()");
    }
}
