package org.ms.thinkInJava.generics;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by Ryan on 2017/5/31.
 */
public class ArrayMaker<T> {

    private Class<T> kind;
    public ArrayMaker(Class<T> kind){
        this.kind = kind;
    }

    @SuppressWarnings("unchecked")
    T[] create(int size){
        //Array.newInstance实际上并未拥有kind所蕴含的类型信息，因此这不会产生具体的结果，所以必须转型
        return (T[])Array.newInstance(kind, size);  //对于在泛型中创建数组，使用Array.newInstance()是推荐的方式
    }

    public static void main(String[] args) {
        ArrayMaker<String> stringMaker = new ArrayMaker<>(String.class);
        String[] stringArray = stringMaker.create(10);
        System.out.println(Arrays.toString(stringArray));
    }

}
