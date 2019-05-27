package org.ms.thinkInJava.containers;

import java.util.Collections;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetDemo {

    public static void main(String[] args) {
        SortedSet<String> sortedSet = new TreeSet<String>();
        Collections.addAll(sortedSet, "one two three four five six seven eight".split(" "));
        System.out.println(sortedSet);

        String low = sortedSet.first();
        String high = sortedSet.last();
        System.out.println(low);
        System.out.println(high);

        Iterator<String> it = sortedSet.iterator();
        for (int i = 0; i <= 6; i++) {
            if (i == 3) low = it.next();
            if (i == 6) high = it.next();
            else it.next();
        }
        System.out.println(low);
        System.out.println(high);  //之所以这里结果为“two”，是因为上边是一个if和一个if else，所以当i等于3时，走了两个it.next()方法
        System.out.println(sortedSet.subSet(low, high));
        System.out.println(sortedSet.headSet(high));
        System.out.println(sortedSet.tailSet(low));
    }

}
