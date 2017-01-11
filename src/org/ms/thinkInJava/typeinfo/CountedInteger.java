package org.ms.thinkInJava.typeinfo;

/**
 * Created by Administrator on 2017/1/10.
 */
public class CountedInteger {
    private static long counter;
    private final long id = counter++;
    public String toString(){
        return Long.toString(id);
    }
}
