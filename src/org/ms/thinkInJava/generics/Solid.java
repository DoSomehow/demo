package org.ms.thinkInJava.generics;

/**
 * Created by Ryan on 2017/10/23.
 */
//As with inheritance, you can have only one concrete class but multiple interfaces  //concrete: 混凝土的；实在的，具体的；有形的
public class Solid<T extends Dimension & HasColor & Weight> {  //只能一个类，可以多个接口

    T item;

    Solid(T item){
        this.item = item;
    }

    T getItem(){
        return item;
    }

    java.awt.Color color(){
        return item.getColor();
    }

    int getX(){ return item.x; }
    int getY(){ return item.y; }
    int getZ(){ return item.z; }

    int weight(){
        return item.weight();
    }

}
