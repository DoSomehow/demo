package org.ms.thinkInJava.generics;

/**
 * Created by Ryan on 2017/5/26.
 */
public class Manipulator2<T extends HasF> {

    private T obj;
    public Manipulator2(T x){
        obj = x;
    }
    public void manipulate(){
        obj.f();
    }
}
