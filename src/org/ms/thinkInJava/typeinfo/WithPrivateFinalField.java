package org.ms.thinkInJava.typeinfo;

/**
 * Created by Administrator on 2017/1/15.
 */
class WithPrivateFinalField {
    private int i = 1;
    private final String s = "I'm totally safe";
    private String s2 = "Am i safe?";
    public String toString(){
        return "i = " + i + ", " + s + ", " + s2;
    }
}
