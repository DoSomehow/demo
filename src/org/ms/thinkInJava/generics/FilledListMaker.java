package org.ms.thinkInJava.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ryan on 2017/5/31.
 */
public class FilledListMaker<T> {

    List<T> create(T t, int n){
        List<T> result = new ArrayList<T>();
        for(int i = 0; i < n; i++)
            result.add(t);
        return result;
    }

    public static void main(String[] args) {
        FilledListMaker<String> stringMaker = new FilledListMaker<>();
        List<String> stringList = stringMaker.create("hello", 5);
        System.out.println(stringList);
    }

}
