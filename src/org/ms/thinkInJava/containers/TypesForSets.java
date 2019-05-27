package org.ms.thinkInJava.containers;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class TypesForSets {

    static <T> Set<T> fill(Set<T> set, Class<T> type){
        try{
            for (int i = 0; i < 10; i++) {
                set.add(type.getConstructor(int.class).newInstance(i));
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return set;
    }

    static <T> void test(Set<T> set, Class<T> type){
        fill(set, type);
        fill(set, type);  //Try to add duplicates
        fill(set, type);
        System.out.println(set);
    }

    public static void main(String[] args) {
        test(new HashSet<HashType>(), HashType.class);
        test(new LinkedHashSet<HashType>(), HashType.class);
        test(new TreeSet<TreeType>(), TreeType.class);
        //Things that don't work:
        test(new HashSet<SetType>(), SetType.class);  //放入的元素未实现hashCode方法
        test(new HashSet<TreeType>(), TreeType.class);  //放入的元素未实现hashCode方法
        test(new LinkedHashSet<SetType>(), SetType.class);  //放入的元素未实现hashCode方法
        test(new LinkedHashSet<TreeType>(), TreeType.class);  //放入的元素未实现hashCode方法

        try{
            test(new TreeSet<SetType>(), SetType.class);  //放入的元素未实现Comparable接口
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        try{
            test(new TreeSet<HashType>(), HashType.class);  //放入的元素未实现Comparable接口
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
