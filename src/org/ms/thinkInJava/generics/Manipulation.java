package org.ms.thinkInJava.generics;

/**
 * Created by Ryan on 2017/5/26.
 */
public class Manipulation {

    public static void main(String[] args) {
        HasF hf = new HasF();

        Manipulator<HasF> manipulator = new Manipulator<>(hf);
        manipulator.manipulate();

        Manipulator2<HasF> manipulator2 = new Manipulator2<>(hf);
        manipulator2.manipulate();

    }

}
