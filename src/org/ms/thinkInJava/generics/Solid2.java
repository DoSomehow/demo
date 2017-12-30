package org.ms.thinkInJava.generics;

/**
 * Created by Ryan on 2017/10/23.
 */
public class Solid2<T extends Dimension & HasColor & Weight> extends ColoredDimension2<T> {
    Solid2(T item){
        super(item);
    }

    int weight(){
        return item.weight();
    }

}
