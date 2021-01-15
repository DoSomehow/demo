package org.ms.javaTest;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author Ryan
 * @date 2020/6/3 18:15
 */
public class TestIterator {

    public static void main(String[] args) {
        testHasNext();
    }

    public static void testHasNext() {
        List<String> dataList = Arrays.asList("1", "2", "3", "4");
        Iterator<String> it = dataList.iterator();
        while (it.hasNext()) {
            System.out.println("has next ? " + (it.hasNext() ? "true" : "false"));
            System.out.println(it.next());
        }
    }
}
