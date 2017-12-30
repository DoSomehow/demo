package org.ms.thinkInJava.generics;

import org.ms.thinkInJava.util.Generator;

/**
 * Created by Administrator on 2017/3/29.
 */
public class Customer {
    private static long counter = 1;
    private final long id = counter++;
    private Customer(){}  //私有构造函数
    public String toString(){
        return "Customer " + id;
    }

    //A method to produce Generator "objects"
    public static Generator<Customer> generator(){
        return new Generator<Customer>() {
            @Override
            public Customer next() {
                return new Customer();
            }
        };
    }

}
