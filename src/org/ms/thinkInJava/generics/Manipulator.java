package org.ms.thinkInJava.generics;

/**
 * Created by Ryan on 2017/5/26.
 */
public class Manipulator<T> {

    private T obj;
    public Manipulator(T x){
        obj = x;
    }

    public void manipulate(){
        //Error: cannot find symbol : method f()
        // obj.f();
    }

}
