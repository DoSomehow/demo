package org.ms.thinkInJava.generics;

/**
 * Created by Ryan on 2017/10/19.
 */
abstract class GenericWithCreate<T> {
    final T element;

    GenericWithCreate(){
        element = create();
    }

    abstract T create();
}
