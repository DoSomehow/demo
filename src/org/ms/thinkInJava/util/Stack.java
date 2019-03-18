package org.ms.thinkInJava.util;

import java.util.LinkedList;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/3/18 23:56
 */
public class Stack<T> {

    private LinkedList<T> storage = new LinkedList<>();
    public void push(T v){
        storage.addFirst(v);
    }
    public T peek(){
        return storage.getFirst();
    }
    public T pop(){
        return storage.removeFirst();
    }
    public boolean empty(){
        return storage.isEmpty();
    }
    public String toString(){
        return storage.toString();
    }

}
