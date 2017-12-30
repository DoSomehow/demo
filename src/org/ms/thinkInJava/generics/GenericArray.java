package org.ms.thinkInJava.generics;

/**
 * Created by Ryan on 2017/10/20.
 */
public class GenericArray<T> {
    private T[] array;

    @SuppressWarnings("unchecked")
    public GenericArray(int size){
        array = (T[])new Object[size];
    }

    public void put(int index, T item){
        array[index] = item;
    }

    public T get(int index){
        return array[index];
    }

    public T[] rep(){
        return array;
    }

    public static void main(String[] args) {
        GenericArray<Integer> gai = new GenericArray<>(10);
        //This causes a ClassCastException  // 书上是这个注释，但目前在该代码中，并没有报错，是版本问题吗？  //编译时没有错，但是运行时就报错了
        // Integer[] ia = gai.rep();

        //This is OK
        Object[] oa = gai.rep();

        //自己测试
        //如果没有指定具体类型，像如下这样，放入不同类型数据，这该怎么理解？
        GenericArray gai2 = new GenericArray(10);
        gai2.put(0, "string");
        gai2.put(1, 12345);
        System.out.println(gai2.get(0));
        System.out.println(gai2.get(1));

    }


}
