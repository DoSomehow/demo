package org.ms.thinkInJava.generics;

/**
 * Created by Ryan on 2017/10/19.
 */
public class InstantiateGenericType {

    public static void main(String[] args) {
        ClassAsFactory<Employee> fe = new ClassAsFactory<>(Employee.class);
        System.out.println("ClassAsFactory<Employee> succeeded");

        try {
            ClassAsFactory<Integer> fi = new ClassAsFactory<>(Integer.class);  //Integer没有默认的构造函数
            System.out.println("ClassAsFactory<Integer> succeeded");
        }catch (Exception e){
            System.out.println("ClassAsFactory<Integer> failed");
        }

    }

}
