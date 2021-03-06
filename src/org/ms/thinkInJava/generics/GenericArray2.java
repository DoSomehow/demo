package org.ms.thinkInJava.generics;

/**
 * Created by Ryan on 2017/10/20.
 */
public class GenericArray2<T> {
    private Object[] array;
    public GenericArray2(int size){
        array = new Object[size];
    }

    public void put(int index, T item){
        array[index] = item;
    }

    @SuppressWarnings("unchecked")
    public T get(int index){
        return (T)array[index];
    }

    @SuppressWarnings("unchecked")
    public T[] rep(){
        return (T[])array;
    }

    public static void main(String[] args) {
        GenericArray2<Integer> gai = new GenericArray2<>(10);
        for (int i = 0; i < 10; i++) {
            gai.put(i, i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.print(gai.get(i) + " ");
        }
        System.out.println();
        try{
            Integer[] ia = gai.rep();  //创建泛型数组的唯一方式就是创建一个被擦除类型的新数组
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
