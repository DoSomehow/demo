package org.ms.thinkInJava.generics;

/**
 * Created by Ryan on 2017/10/23.
 */
public class Colored2<T extends HasColor> extends HoldItem<T> {

    Colored2(T item){
        super(item);
    }

    java.awt.Color color(){
        return item.getColor();
    }

}
