package org.ms.thinkInJava.holding;

import java.util.LinkedList;

/**
 * Created by Administrator on 2016/12/30.
 */
public class LinkedListFeatures {

    public static void main(String[] args){
        LinkedList<String> list = new LinkedList<>();
        list.addFirst("a");
        list.addFirst("b");
        list.addFirst("c");
        list.addFirst("d");
        System.out.println(list);
        list.add("e");
        list.add("f");
        System.out.println(list);

    }

}
