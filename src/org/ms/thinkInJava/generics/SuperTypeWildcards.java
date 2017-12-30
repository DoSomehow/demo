package org.ms.thinkInJava.generics;

import java.util.List;

/**
 * Created by Ryan on 2017/10/27.
 */
public class SuperTypeWildcards {
    static void writeTo(List<? super Apple> apples){
        apples.add(new Apple());
        apples.add(new Jonathan());
        // apples.add(new Fruit());  //Error
    }
}
