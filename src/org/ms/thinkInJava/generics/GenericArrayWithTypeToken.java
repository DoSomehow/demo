package org.ms.thinkInJava.generics;

import java.lang.reflect.Array;

/**
 * Created by Ryan on 2017/10/23.
 */
public class GenericArrayWithTypeToken<T> {

    private T[] array;

    @SuppressWarnings("unchecked")
    public GenericArrayWithTypeToken(Class<T> type, int size){
        array = (T[]) Array.newInstance(type, size);
    }

    public void put(int index, T item){
        array[index] = item;
    }

    public T get(int index){
        return array[index];
    }

    //Expose the underlying representation:
    public T[] rep(){
        return array;
    }

    public static void main(String[] args) {
        GenericArrayWithTypeToken<Integer> gai = new GenericArrayWithTypeToken<>(Integer.class, 10);
        //This now works:
        Integer[] ia = gai.rep();
    }

}
