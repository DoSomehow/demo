package org.ms.thinkInJava.generics;

/**
 * Created by Ryan on 2017/10/19.
 */
public class Creator extends GenericWithCreate<X> {
    @Override
    X create() {
        return new X();
    }

    void f(){
        System.out.println(element.getClass().getSimpleName());
    }
}
