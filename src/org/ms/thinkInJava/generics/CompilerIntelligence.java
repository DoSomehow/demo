package org.ms.thinkInJava.generics;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Ryan on 2017/10/26.
 */
public class CompilerIntelligence {
    public static void main(String[] args) {
        List<? extends Fruit> flist = Arrays.asList(new Apple());
        Apple a = (Apple)flist.get(0);
        flist.contains(new Apple());
        flist.indexOf(new Apple());
        System.out.println(flist.size());
    }
}
