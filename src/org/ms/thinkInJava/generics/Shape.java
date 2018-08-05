package org.ms.thinkInJava.generics;

public class Shape {

    public void rotate(){
        System.out.println(this + " rotate");
    }

    public void resize(int newSize){
        System.out.println(this + " resize " + newSize);
    }

}
