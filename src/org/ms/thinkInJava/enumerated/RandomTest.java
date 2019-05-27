package org.ms.thinkInJava.enumerated;

import org.ms.thinkInJava.util.Enums;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/3/26 23:21
 */
public class RandomTest {

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println(Enums.random(Activity.class) + " ");
        }
    }

}
