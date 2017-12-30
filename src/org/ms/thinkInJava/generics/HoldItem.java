package org.ms.thinkInJava.generics;

/**
 * Created by Ryan on 2017/10/23.
 */
public class HoldItem<T> {

    T item;
    HoldItem(T item){
        this.item = item;
    }
    T getItem(){
        return item;
    }

}
