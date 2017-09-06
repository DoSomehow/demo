package org.ms.thinkInJava.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ryan on 2017/5/31.
 */
public class ListMaker<T> {
    List<T> create(){
        return new ArrayList<T>();
    }

    public static void main(String[] args) {
        ListMaker<String> stringMaker = new ListMaker<>();
        List<String> stringList = stringMaker.create();
    }
}
