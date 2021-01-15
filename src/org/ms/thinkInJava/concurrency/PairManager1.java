package org.ms.thinkInJava.concurrency;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/6/19 0:27
 */
public class PairManager1 extends PairManager {  //Synchronize the entire method:

    public synchronized void increment() {
        p.incrementX();
        p.incrementY();
        store(getPair());
    }

}
