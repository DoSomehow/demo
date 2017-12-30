package org.ms.thinkInJava.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/14.
 */
public class ExplicitTypeSpecification {

    public <T> List<T> f(){
        return new ArrayList<T>();
    }

    public void g(){
        List list = this.<Integer>f();
    }

    // static void h(Map<Person, List<Pet>> petPeople){  }

    public static void main(String[] args) {
        // h(New.<Person, List<Pet>>map());

        ExplicitTypeSpecification ets = new ExplicitTypeSpecification();
        List list = ets.<Integer>f();  //难道必须在List后边加上<Integer>？？？
        list.add("1");  //显示类型说明， 好像没什么用啊，或者是不会自动检查吗？
        list.add(2);

    }

}
