package org.ms.thinkInJava.concurrency;

import java.util.Random;

/**
 * @Author mydre
 * @Description
 * @Date Created in 2020/5/15
 */
public class Count {

    private int count = 0;
    private Random rand = new Random(47);
    //Remove the synchronized keyword to see counting fail:
    public synchronized int increment() {
        int temp = count;
        if(rand.nextBoolean())  //Yield half the time
            Thread.yield();
        return (count = ++temp);
    }

    public synchronized int value() {
        return count;
    }

}
