package org.ms.thinkInJava.generics;

/**
 * Created by Ryan on 2017/10/19.
 */
public class ClassAsFactory<T> {

    T x;

    public ClassAsFactory(Class<T> kind){
        try{
            x = kind.newInstance();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}
