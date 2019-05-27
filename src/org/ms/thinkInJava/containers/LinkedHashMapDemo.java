package org.ms.thinkInJava.containers;

import org.ms.thinkInJava.util.CountingMapData;

import java.util.LinkedHashMap;

public class LinkedHashMapDemo {

    public static void main(String[] args) {
        LinkedHashMap<Integer, String> linkedMap = new LinkedHashMap<>(new CountingMapData(9));
        System.out.println(linkedMap);

        //Least-recently-used order:
        linkedMap = new LinkedHashMap<>(16, 0.75f, true);
        linkedMap.putAll(new CountingMapData(9));;
        System.out.println(linkedMap);

        for (int i = 0; i < 6; i++) {  //Cause accesses:
            linkedMap.get(i);
        }
        System.out.println(linkedMap);
        linkedMap.get(0);
        System.out.println(linkedMap);
    }

}
