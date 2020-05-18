package org.ms.thinkInJava.concurrency;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/6/19 23:18
 */
public class PairManager2 extends PairManager {  //Use a critical section:

    public void increment() {
        Pair temp;
        synchronized (this) {
            p.incrementX();
            p.incrementY();
            temp = getPair();
        }
        store(temp);
    }

}
