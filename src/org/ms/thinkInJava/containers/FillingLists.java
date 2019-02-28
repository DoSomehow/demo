package org.ms.thinkInJava.containers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FillingLists {

    public static void main(String[] args) {
        List<StringAddress> list = new ArrayList<>(Collections.nCopies(4, new StringAddress("Hello")));
        System.out.println(list);

        System.out.println("");

        Collections.fill(list, new StringAddress("World!"));
        System.out.println(list
        );
    }

}
