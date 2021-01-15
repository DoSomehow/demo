package org.ms.thinkInJava.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/6/19 0:13
 */
public class AtomicEvenGenerator extends IntGenerator {

    private AtomicInteger currentEvenValue = new AtomicInteger(0);

    public int next() {
        return currentEvenValue.addAndGet(2);
    }

    public static void main(String[] args) {
        EvenChecker.test(new AtomicEvenGenerator());
    }

}
