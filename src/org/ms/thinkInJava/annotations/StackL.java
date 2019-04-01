package org.ms.thinkInJava.annotations;

import java.util.LinkedList;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/3/31 23:14
 */
public class StackL<T> {

    private LinkedList<T> list = new LinkedList<>();
    public void push(T v) {
        list.addFirst(v);
    }
    public T top() {
        return list.getFirst();
    }
    public T pop() {
        return list.removeFirst();
    }

}
