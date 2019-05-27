package org.ms.thinkInJava.util;

import java.util.Random;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/3/26 23:17
 */
public class Enums {

    private static Random rand = new Random(47);
    public static <T extends Enum<T>> T random(Class<T> ec) {
        return random(ec.getEnumConstants());
    }

    public static <T> T random(T[] values) {
        return values[rand.nextInt(values.length)];
    }

}
