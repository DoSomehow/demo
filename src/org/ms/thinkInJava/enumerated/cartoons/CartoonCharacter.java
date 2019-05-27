package org.ms.thinkInJava.enumerated.cartoons;

import org.ms.thinkInJava.util.Generator;

import java.util.Random;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/3/26 23:12
 */
public enum CartoonCharacter implements Generator<CartoonCharacter>  {

    SLAPPY, SPANKY, PUNCHY, SILLY, BOUNCY, NUTTY, BOB;

    private Random rand = new Random(47);


    @Override
    public CartoonCharacter next() {
        return values()[rand.nextInt(values().length)];
    }
}
