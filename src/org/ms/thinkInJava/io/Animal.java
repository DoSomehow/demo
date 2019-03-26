package org.ms.thinkInJava.io;

import java.io.Serializable;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/3/25 22:46
 */
public class Animal implements Serializable {

    private String name;
    private House preferredHouse;

    Animal(String nm, House h) {
        name = nm;
        preferredHouse = h;
    }

    @Override
    public String toString() {
        return name + "[" + super.toString() + "], " + preferredHouse + "\n" ;
    }
}
