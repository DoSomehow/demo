package org.ms.thinkInJava.typeinfo;

import org.ms.thinkInJava.typeinfo.interfacea.A;

/**
 * Created by Administrator on 2017/1/15.
 */
class AnonymousA {
    public static A makeA(){
        return new A(){
            @Override
            public void f() {
                System.out.println("C.f()");
            }
            public void g(){
                System.out.println("C.g()");
            }
            void u(){
                System.out.println("package C.u()");
            }
            protected void v(){
                System.out.println("protected C.v()");
            }
            private void w(){
                System.out.println("private C.w()");
            }
        };
    }
}