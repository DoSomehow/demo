package org.ms.javaTest;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2016/12/28.
 */
public class TestArrays {

    public static void main(String[] args){
        testAsList();


    }

    public static void testAsList(){
        List<String> list = Arrays.asList("1","2","3","4","5");
        for(String s:list){
            System.out.println(s);
        }
    }


}
