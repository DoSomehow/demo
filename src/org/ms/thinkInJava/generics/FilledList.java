package org.ms.thinkInJava.generics;

import java.util.ArrayList;

public class FilledList<T> extends ArrayList<T> {

    public FilledList(Class<? extends T> type, int size){
        try{
            for (int i = 0; i < size; i++) {
                //Assumes the type has default constructor:
                add(type.newInstance());
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }

}
