package org.ms.thinkInJava.enumerated;

import org.ms.thinkInJava.util.Generator;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/3/27 23:11
 */
public class RandomInputGenerator implements Generator<Input> {

    @Override
    public Input next() {
        return Input.randomSelection();
    }
}
