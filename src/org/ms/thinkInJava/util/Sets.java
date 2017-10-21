package org.ms.thinkInJava.util;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Ryan on 2017/10/18.
 */
public class Sets {

    //合并
    public static <T> Set<T> union(Set<T> a, Set<T> b){
        Set<T> result = new HashSet<T>(a);
        result.addAll(b);
        return result;
    }

    //交集
    //遍历b，如果b中不包含a中的哪一个元素，那么就把这个元素从a中删掉，从而达到取并集的效果
    public static <T> Set<T> intersection(Set<T> a, Set<T> b){
        Set<T> result = new HashSet<T>(a);
        result.retainAll(b);
        return result;
    }

    //从superset中，移除和subset相同的元素
    public static <T> Set<T> difference(Set<T> superset, Set<T> subset){
        Set<T> result = new HashSet<T>(superset);
        result.removeAll(subset);
        return result;
    }

    //差集
    //除了交集之外的所有元素(应该是差集吧？)
    public static <T> Set<T> complement(Set<T> a, Set<T> b){
        return difference(union(a, b), intersection(a, b));
    }

}
