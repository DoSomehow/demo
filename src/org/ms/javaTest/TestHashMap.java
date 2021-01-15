package org.ms.javaTest;

import org.ms.javaTest.entity.Wang;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ryan
 * @date 2020/12/7 16:29
 */
public class TestHashMap {

    public static void main(String[] args) {
        testReturnValueOfPutMethod();
    }

    private static void testReturnValueOfPutMethod() {
        Wang wang = new Wang();
        wang.setName("wang");
        wang.setCap(999999999L);
        Map<String, Wang> map = new HashMap<>();
        Wang val = map.put("1", wang);

        if (wang == val) {
            System.out.println("Yes");
        }
        if (wang.equals(val)) {
            System.out.println("Yes");
        }

        System.out.println(wang);
        System.out.println(val);

    }

}
