package org.ms.testJava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2017/1/10.
 */
public class TestCollections {
    public static void main(String[] args) {
        test();
    }

    public static void test(){
        List list = new ArrayList<>();
        String[] arr = new String[]{"a", "b", "c"};
        Collections.addAll(list, arr);
        Collections.addAll(list, "d", "e", "f");
        List list2 = new ArrayList();
        list2.add("g");
        list2.add("h");
        list2.add("i");
        Collections.addAll(list, list2);
        Collections.addAll(list, list2.toArray());
        list.addAll(list2);
        // list.addAll(arr);  //error
        for(Object obj:list){
            System.out.println(obj);
        }
    }
}
