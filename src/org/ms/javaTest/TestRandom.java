package org.ms.javaTest;

import java.util.Random;

/**
 * @author Ryan
 * @date 2021/1/20 18:19
 */
public class TestRandom {

    public static void main(String[] args) {
        // test();
        // testSeed();
        lessThanOne();
    }

    private static void lessThanOne() {
        Random random = new Random();
        System.out.println(random.nextDouble());
    }

    private static void test() {
        Random random = new Random(30);
        for (int i = 0; i < 10; i++) {
            int val = random.nextInt(2);
            System.out.println(val);
        }

    }

    private static void testSeed() {
        // Random random = new Random(30);
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println("i: " + i + "\t" + random.nextInt());
        }
        // i: 0	-1153176083
        // i: 1	933071736
        // i: 2	958937531
        // i: 3	-859948088
        // i: 4	926136273
        // i: 5	-232178700
        // i: 6	-615224923
        // i: 7	-576200731
        // i: 8	1616116912
        // i: 9	886071695
    }
}
