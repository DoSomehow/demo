package org.ms.thinkInJava.arrays;

import org.ms.thinkInJava.util.Generated;
import org.ms.thinkInJava.util.RandomGenerator;

import java.util.Arrays;

public class AlphabeticSearch {

    public static void main(String[] args) {
        String[] sa = Generated.array(new String[30], new RandomGenerator.String(5));
        Arrays.sort(sa, String.CASE_INSENSITIVE_ORDER);
        System.out.println(Arrays.toString(sa));

        //如果使用了COmparator排序了某个对象数组(基本类型数组无法使用Comparator进行排序)，在使用binarySearch()时必须提供同样的Comparator(使用binarySearch()方法的重载版本)
        int index = Arrays.binarySearch(sa, sa[10], String.CASE_INSENSITIVE_ORDER);
        // int index = Arrays.binarySearch(sa, sa[10]);
        System.out.println("Index: " + index + "\n" + sa[index]);
    }

}
