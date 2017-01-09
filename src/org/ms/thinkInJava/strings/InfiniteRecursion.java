package org.ms.thinkInJava.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * 无限递归
 * Created by Administrator on 2017/1/6.
 */
public class InfiniteRecursion {

    public String toString(){
        // return "InfiniteRecursion address: " + this + "\n";
        return "InfiniteRecursion address: " + super.toString() + "\n";
    }

    public static void main(String[] args) {
        List<InfiniteRecursion> list = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            list.add(new InfiniteRecursion());
        }
        System.out.println(list);
    }

}
