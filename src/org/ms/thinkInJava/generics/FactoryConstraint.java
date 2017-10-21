package org.ms.thinkInJava.generics;

/**
 * Created by Ryan on 2017/10/19.
 */
public class FactoryConstraint {
    public static void main(String[] args) {
        new Foo2<Integer>(new IntegerFactory());
        new Foo2<Widget>(new Widget.Factory());
    }
}
