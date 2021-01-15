package org.ms.thinkInJava.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/6/19 23:29
 */
public class ExplicitPairManager2 extends PairManager {  //Use a critical section:

    private Lock lock  = new ReentrantLock();

    public void increment() {
        Pair temp;
        lock.lock();
        try {
            p.incrementX();
            p.incrementY();
            temp = getPair();
        }finally {
            lock.unlock();
        }
        store(temp);
    }

}
