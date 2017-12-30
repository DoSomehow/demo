package org.ms.thinkInJava.generics;

/**
 * Created by Ryan on 2017/10/26.
 */
public class CovariantArrays {
    public static void main(String[] args) {
        Fruit[] fruit = new Apple[10];
        fruit[0] = new Apple();  //ok
        fruit[1] = new Jonathan();  //子类型也可以

        //Runtime type is Apple[], not Fruit[] or Orange[]
        try {
            //Complier allows you to add Fruit
            fruit[2] = new Fruit();  //编译期可以，因为是Fruit[]引用
        }catch (Exception e){
            System.out.println(e);
        }

        try{
            //Complier allows you to add Orange
            fruit[3] = new Orange();  //编译期可以
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
