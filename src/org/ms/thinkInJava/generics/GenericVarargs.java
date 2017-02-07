package org.ms.thinkInJava.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/19.
 */
public class GenericVarargs {
    public static <T> List<T> makeList(T... args){
        List<T> result = new ArrayList<>();
        for (T item:args){
            result.add(item);
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> ls = makeList("A","B","C");
        System.out.println(ls);

        List<Integer> li = makeList(1,2,3);
        System.out.println(li);
    }
}
