package org.ms.thinkInJava.generics;

/**
 * Created by Ryan on 2017/10/23.
 */
public class Colored<T extends HasColor> {

    T item;

    Colored(T item){
        this.item = item;
    }

    T getItem(){
        return item;
    }

    //The bound allows you to call a method:
    java.awt.Color color(){
        return item.getColor();
    }

}
