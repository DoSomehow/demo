package org.ms.thinkInJava.enumerated.cartoons;

import org.ms.thinkInJava.util.Generator;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/3/26 23:14
 */
public class EnumImplementation {

    public static <T> void printNext(Generator<T> rg) {
        System.out.print(rg.next() + ", ");
    }

    public static void main(String[] args) {
        //Choose any instance:
        CartoonCharacter cc = CartoonCharacter.BOB;
        for (int i = 0; i < 10; i++) {
            printNext(cc);
        }
    }

}
