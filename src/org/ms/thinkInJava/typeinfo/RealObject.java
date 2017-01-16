package org.ms.thinkInJava.typeinfo;

/**
 * Created by Administrator on 2017/1/13.
 */
public class RealObject implements Interface {
    @Override
    public void doSomething() {
        System.out.println("doSomething");
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("somethingElse " + arg);
    }
}
