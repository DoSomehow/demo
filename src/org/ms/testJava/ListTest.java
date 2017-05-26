package org.ms.testJava;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Ryan on 2017/2/27.
 */
public class ListTest {

    public static void main(String[] args) {

        testNullList();

    }

    public static void testNullList(){
        List<String> list = new ArrayList<>();
        Iterator<String> it = list.iterator();
        if(it.hasNext()){
            System.out.println(it.next());
        }
    }

}
