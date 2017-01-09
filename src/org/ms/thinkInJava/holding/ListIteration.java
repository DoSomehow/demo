package org.ms.thinkInJava.holding;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Administrator on 2016/12/29.
 */
public class ListIteration {

    public static void main(String[] args){
        //region Description
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        //endregion

        ListIterator<String> it = list.listIterator();
        while(it.hasNext()){
            System.out.println(it.next() + ", " + it.nextIndex() + ", " + it.previousIndex());
        }
        System.out.println();
        System.out.println(list);

        it = list.listIterator(3);  //此时it指向位置3的元素，也就是说，此时的it.next()方法会获得位置3的元素，而不是位置4的
        it.next();
        it.set("3");
        System.out.println(list);

    }

}