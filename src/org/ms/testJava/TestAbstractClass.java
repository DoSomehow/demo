package org.ms.testJava;

/**
 * Created by Administrator on 2016/12/31.
 */
public abstract class TestAbstractClass {

    abstract String f();   //抽象方法，没有实现，但该类中其他已实现的方法可以调用该方法

    public void g(){
        String str = f();
        System.out.println(str);
    }

}
