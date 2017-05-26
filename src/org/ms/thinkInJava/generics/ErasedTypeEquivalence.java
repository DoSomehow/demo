package org.ms.thinkInJava.generics;

import java.util.ArrayList;

/**
 * Created by Ryan on 2017/5/26.
 */
public class ErasedTypeEquivalence {

    public static void main(String[] args) {
        Class c1 = new ArrayList<String>().getClass();
        Class c2 = new ArrayList<Integer>().getClass();
        System.out.println(c1 == c2);
    }

}
