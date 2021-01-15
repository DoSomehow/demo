package org.ms.javaTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestList {

    public static void main(String[] args) {
        // test();
        // testRemoveByEnhanceFor();
        // testRemoveByFor();
        // testRemoveInWhile();
        // testRemoveAndSize();
        testRemoveObject();
    }

    public static void testRemoveObject() {
        List<Integer> data = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> list = new ArrayList<>(data);
        int i = 0;
        while (i < list.size()) {
            Integer val = list.get(i);
            if (val.equals(4)) {
                list.remove(val);
            }
            i++;
        }
        list.forEach(integer -> System.out.print(integer));
    }

    public static void testRemoveAndSize() {
        List<Integer> data = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> list = new ArrayList<>(data);
        // int i = 0;
        // while ((i = list.size()) > 0) {
        //     System.out.println(i);
        //     list.remove(0);
        // }
        while (list.size() > 0) {
            System.out.println("exe");
            list.remove(0);
        }
    }

    public static void testRemoveInWhile() {
        List<Integer> data = Arrays.asList(1, 2, 3, 4, 4, 5, 6, 7, 8, 9);
        List<Integer> list = new ArrayList<>(data);
        int i = 0;
        while (list.size() > 0) {
            if (i < list.size()) {
                System.out.print(i);
                list.remove(i);
                i++;
                System.out.println("  " + list.size());
            }
        }
        // list.forEach(integer -> System.out.print(integer));
    }

    public static void testRemoveByFor() {
        List<Integer> data = Arrays.asList(1, 2, 3, 4, 4, 5, 6, 7, 8, 9);
        List<Integer> list = new ArrayList<>(data);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 4) {
                list.remove(i);
            }
        }
        list.forEach(integer -> System.out.print(integer));
    }

    public static void testRemoveByEnhanceFor() {
        List<Integer> data = Arrays.asList(1, 2, 3, 4, 4, 5, 6, 7, 8, 9);
        List<Integer> list = new ArrayList<>(data);
        for (Integer val : list) {
            if (val == 4) {
                list.remove(val);
            }
        }
        list.forEach(integer -> System.out.println(integer));
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
