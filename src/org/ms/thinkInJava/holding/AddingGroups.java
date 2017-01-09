package org.ms.thinkInJava.holding;

import java.util.*;

/**
 * Created by Administrator on 2016/12/28.
 */
public class AddingGroups {

    public static void main(String[] args){
        Collection<Integer> collection = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
        Integer[] moreInts = {6,7,8,9,10};
        collection.addAll(Arrays.asList(moreInts));

        Collections.addAll(collection, 11, 12, 13, 14, 15);  //首选这种方式，速度快
        Collections.addAll(collection, moreInts);

//        List<Integer> list = Arrays.asList(16, 17, 18, 19, 20);
        Integer[] intArr = {16, 17, 18, 19, 20};
        List<Integer> list = Arrays.asList(intArr);
        list.set(1, 99);
        //list.add(21);  //运行时异常，因为Arrays.asList方法返回的是一个依靠指定数组的固定长度的集合

        for(Integer i:collection){
            System.out.println("collection:"+ i);
        }

        for(Integer i:list){
            System.out.println("list:"+ i);
        }

        for(Integer i:intArr){
            System.out.println("array:"+ i);  //这里表明，使用Arrays.asList方法后，如果对list进行修改，也会修改到传入的数组
        }

    }

}
