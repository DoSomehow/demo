package org.ms.thinkInJava.arrays;

public class ArrayOfGenericType<T> {

    T[] array;  //OK

    public ArrayOfGenericType(int size){
        // array = new T[size];  //Illegal
        array = (T[])new Object[size];  //unchecked warning
    }

    //Illegal
    // public <U> U[] makeArray(){
    //     return new U[10];
    // }


}
