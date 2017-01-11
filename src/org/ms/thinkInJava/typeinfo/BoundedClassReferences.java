package org.ms.thinkInJava.typeinfo;

/**
 * Created by Administrator on 2017/1/10.
 */
public class BoundedClassReferences {
    public static void main(String[] args) {
        Class<? extends  Number> bounded = int.class;
        bounded = double.class;
        bounded = Number.class;
    }
}
