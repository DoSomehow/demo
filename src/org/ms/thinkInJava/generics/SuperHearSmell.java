package org.ms.thinkInJava.generics;

/**
 * Created by Ryan on 2017/10/23.
 */
public class SuperHearSmell implements SuperHearing, SuperSmell {
    @Override
    public void trackBySmell() {
        System.out.println("smell");
    }

    @Override
    public void hearSubtleNoises() {
        System.out.println("hear");
    }
}
