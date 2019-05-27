package org.ms.thinkInJava.enumerated;

import org.ms.thinkInJava.util.Enums;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/3/28 22:55
 */
public class RoShamBo {

    public static <T extends Competitor<T>> void match(T a, T b) {
        System.out.println(a + " vs. " + b + ": " + a.compete(b));
    }
    public static <T extends Enum<T> & Competitor<T>> void play(Class<T> rsbClass, int size) {
        for (int i = 0; i < size; i++) {
            match(Enums.random(rsbClass), Enums.random(rsbClass));
        }
    }

}
