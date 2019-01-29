package org.ms.javaTest;

import org.ms.javaTest.entity.Human;
import org.ms.javaTest.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class TestGeneric {

    public static void main(String[] args) {


    }

    public static void putObjToSpecify(){

        // List<String> list = new ArrayList<>();
        // list.add(new Object());   // error

        // List<? extends Human> list = new ArrayList<>();
        // list.add(new Object());  //error

        // List<? super Human> list = new ArrayList<>();
        // list.add(new Object());  //error  //这为什么还报错???
    }

    public static void putChildClass(){
        List<Human> list = new ArrayList<>();
        list.add(new Student());
    }

    static <T> T test(List<? extends T> list, T arg){
        // list.add(arg);  //error
        //这里之所以会报错，可以这样理解：
        //当真正调用该方法时，T将会是一个具体的类型，比如Human，此时对于 ? extends T 来说，就变成了 ? extends Human，可以相当于是Student。
        //然而第二个参数虽然指定泛型也为T，但由于多态，其具体类型可以为其子类，如 Worker 。对于一个List<Student>，向里边放Worker对象，是类型不正确的。
        return arg;
    }

}
