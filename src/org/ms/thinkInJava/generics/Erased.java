package org.ms.thinkInJava.generics;

/**
 * Created by Ryan on 2017/10/19.
 */
public class Erased<T> {

    private final int SIZE = 100;

    public void f(Object arg){
        // if(arg instanceof T){ }  //error

        // T var = new T();  //error

        // T[] array = new T[SIZE];  //error

        //T[] array = (T)new Object[SIZE];  //Unchecked warning

        //自己的尝试
        T[] array2 = (T[])new Object[SIZE];  //这样是可以的
        T obj = (T)(new Object());  //这样也是可以的

    }

}
