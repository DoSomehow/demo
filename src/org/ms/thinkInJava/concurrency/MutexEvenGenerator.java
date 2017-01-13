package org.ms.thinkInJava.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2017/1/13 0013.
 */
public class MutexEvenGenerator extends IntGenerator {
    private int currentEvenValue = 0 ;
    private Lock lock = new ReentrantLock();

    @Override
    public int next() {
        lock.lock();
        try {
            ++currentEvenValue;
            Thread.yield();
            ++currentEvenValue;
            return currentEvenValue;  //return语句必须在try块中出现，以确保unlock()不会过早发生，从而将数据暴露给了第二个任务
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        EvenChecker.test(new MutexEvenGenerator());
    }
}
