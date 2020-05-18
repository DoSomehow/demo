package org.ms.thinkInJava.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/6/19 23:27
 */
public class ExplicitPairManager1 extends PairManager {  //Synchronize the entire method:

    private Lock lock = new ReentrantLock();

    public synchronized void increment() {
        lock.lock();
        try{
            p.incrementX();
            p.incrementY();
            store(getPair());
        }finally {
            lock.unlock();
        }
    }

}
