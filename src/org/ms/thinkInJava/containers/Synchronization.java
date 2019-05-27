package org.ms.thinkInJava.containers;

import java.util.*;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/3/18 0:32
 */
public class Synchronization {

    public static void main(String[] args) {

        Collection<String> c = Collections.synchronizedCollection(new ArrayList<String>());
        List<String> list = Collections.synchronizedList(new ArrayList<String>());
        Set<String> s = Collections.synchronizedSet(new HashSet<String>());
        Set<String> ss = Collections.synchronizedSortedSet(new TreeSet<String>());
        Map<String, String> m = Collections.synchronizedMap(new HashMap<String, String>());
        Map<String, String> sm = Collections.synchronizedSortedMap(new TreeMap<String, String>());


    }

}
