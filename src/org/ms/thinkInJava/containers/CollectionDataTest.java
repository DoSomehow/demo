package org.ms.thinkInJava.containers;

import org.ms.thinkInJava.util.CollectionData;

import java.util.LinkedHashSet;
import java.util.Set;

public class CollectionDataTest {

    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<>(new CollectionData<String>(new Government(), 15));

        //Using the convenience method:
        set.addAll(CollectionData.list(new Government(), 15));
        System.out.println(set);
    }

}
