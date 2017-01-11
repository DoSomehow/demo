package org.ms.thinkInJava.typeinfo;

/**
 * Created by Administrator on 2017/1/10.
 */
public class GenericClassReferences {
    public static void main(String[] args) {
        Class intClass = int.class;
        Class<Integer> genericIntClass = int.class;
        genericIntClass = Integer.class;  //same thing
        intClass = double.class;
        // genericIntClass = double.class;
    }
}
