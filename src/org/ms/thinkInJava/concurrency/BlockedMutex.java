package org.ms.thinkInJava.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author mydre
 * @Description
 * @Date Created in 2020/5/17
 */
public class BlockedMutex {

    private Lock lock = new ReentrantLock();

    public BlockedMutex() {
        //Acquire it right away, to demonstrate(证明,展示,论证) interruption of a task blocked on a ReentrantLock:
        lock.lock();
    }
    public void f() {

        try {
            //This will never be available to a second task
            lock.lockInterruptibly();  //Special call
            System.out.println("lock acquired in f()");
        } catch (InterruptedException e) {
            System.out.println("Interrupted from lock acquisition if f()");
        }
    }
}
