package org.ms.thinkInJava.generics;

/**
 * Created by Ryan on 2017/10/23.
 */
//Multiple bounds
public class ColoredDimension<T extends Dimension & HasColor> {
    //This won't work  --  class must be first, then interfaces:  //以前还真没见过这种形式
    //class ColoredDimension<T extends HasColor & Dimension> { }

    T item;

    ColoredDimension(T item){
        this.item = item;
    }

    T getItem(){
        return item;
    }

    java.awt.Color color(){
        return item.getColor();
    }

    int getX(){
        return item.x;
    }
    int getY(){
        return item.y;
    }
    int getZ(){
        return item.z;
    }


}
