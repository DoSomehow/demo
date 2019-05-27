package org.ms.thinkInJava.io;

import java.io.Serializable;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/3/25 0:17
 */
public class Data implements Serializable {

    private int n;
    public Data(int n) {
        this.n = n;
    }

    @Override
    public String toString() {
        return Integer.toString(n);
    }
}
