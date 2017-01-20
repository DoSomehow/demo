package org.ms.thinkInJava.generics.coffee;

/**
 * Created by Administrator on 2017/1/16.
 */
public class Coffee {
    private static long counter = 0;
    private final long id = counter++;
    public String toString(){
        return getClass().getSimpleName() + " " + id;
    }
}
