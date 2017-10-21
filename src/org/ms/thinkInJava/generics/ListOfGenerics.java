package org.ms.thinkInJava.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ryan on 2017/10/20.
 */
public class ListOfGenerics<T> {
    private List<T> array = new ArrayList<T>();

    public void add(T item){
        array.add(item);
    }

    public T get(int index){
        return array.get(index);
    }

}
