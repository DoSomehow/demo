package org.ms.javaTest;

import java.util.Random;

/**
 * @author Ryan
 * @date 2021/1/20 18:19
 */
public class TestRandom {

    public static void main(String[] args) {
        test();
    }

    private static void test() {
        Random random = new Random(30);
        for (int i = 0; i < 10; i++) {
            int val = random.nextInt(2);
            System.out.println(val);
        }

    }
}
