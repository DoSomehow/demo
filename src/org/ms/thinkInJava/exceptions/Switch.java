package org.ms.thinkInJava.exceptions;

/**
 * Created by Administrator on 2017/1/2.
 */
public class Switch {
    private boolean state = false;
    public boolean read() { return state; }
    public void on(){
        state = true;
        System.out.println(this);
    }
    public void off(String str){
        state = false;
        System.out.println(str + "   " + this);
    }
    public String toString(){
        return state ? "on" : "off";
    }

}
