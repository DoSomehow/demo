package org.ms.thinkInJava.generics;

/**
 * Created by Ryan on 2017/10/19.
 */
public class IntegerFactory implements FactoryI<Integer> {

    @Override
    public Integer create() {
        return new Integer(0);
    }
}
