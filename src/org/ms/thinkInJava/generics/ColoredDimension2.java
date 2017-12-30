package org.ms.thinkInJava.generics;

/**
 * Created by Ryan on 2017/10/23.
 */
public class ColoredDimension2<T extends Dimension & HasColor> extends Colored2<T> {
    ColoredDimension2(T item){
        super(item);
    }

    int getX(){ return item.x; }
    int getY(){ return item.y; }
    int getZ(){ return item.z; }

}
