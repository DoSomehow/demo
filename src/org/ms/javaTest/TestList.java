package org.ms.javaTest;

import java.util.ArrayList;
import java.util.List;

public class TestList {

    public static void main(String[] args) {
        test();
    }

    public static void test(){
        List<String> dataList = new ArrayList<>();
        dataList.add("1");
        dataList.add("2");
        dataList.add("3");

        List<String> retList = new ArrayList<>();
        retList.addAll(dataList);

        dataList.clear();

        for(String str : retList){
            System.out.println("result: " + str);
        }

        for(String str : dataList){
            System.out.println("data: " + str);
        }

    }

}
