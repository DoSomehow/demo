package org.ms.thinkInJava.containers;

import org.ms.thinkInJava.util.Generator;

public class Government implements Generator<String>{

    String[] foundation = ("strange women lying in ponds " + "distributing swords is no basis for a system of " + "government").split(" ");

    private int index;

    @Override
    public String next() {
        return foundation[index++];
    }
}
