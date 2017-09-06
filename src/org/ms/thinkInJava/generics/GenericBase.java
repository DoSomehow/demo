package org.ms.thinkInJava.generics;

/**
 * Created by Ryan on 2017/5/31.
 */
public class GenericBase<T> {
    private T element;
    public void set(T arg){
        this.element = arg;
    }
    public T get(){
        return this.element;
    }
}
