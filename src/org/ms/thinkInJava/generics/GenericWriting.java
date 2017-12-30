package org.ms.thinkInJava.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ryan on 2017/10/27.
 */
public class GenericWriting {
    static <T> void writeExact(List<T> list, T item){
        list.add(item);
    }

    static List<Apple> apples = new ArrayList<>();
    static List<Fruit> fruit = new ArrayList<>();

    static void f1(){
        writeExact(apples, new Apple());
        writeExact(fruit, new Apple());  //书上写的是会报错，但为什么没报错？版本问题？在1.5中测试也没问题啊
    }

    static <T> void writeWithWildcard(List<? super T> list, T item){
        list.add(item);
    }

    static void f2(){
        writeWithWildcard(apples, new Apple());
        writeWithWildcard(fruit, new Apple());
    }

    public static void main(String[] args) {
        f1();
        f2();
    }
}
