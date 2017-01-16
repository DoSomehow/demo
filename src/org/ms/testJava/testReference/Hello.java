package org.ms.testJava.testReference;

/**
 * Created by Administrator on 2017/1/16.
 */
public class Hello {
    private String name;
    public Hello(String name){
        this.name = name;
    }

    public void say(){
        System.out.println("Hello! My name is " + name);
    }
}
