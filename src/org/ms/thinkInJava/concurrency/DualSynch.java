package org.ms.thinkInJava.concurrency;

/**
 * @Author mydre
 * @Description
 * @Date Created in 2020/5/15
 */
public class DualSynch {

    private Object syncObject = new Object();

    public synchronized void f() {
        for (int i = 0; i < 5; i++) {
            System.out.println("f()");
            Thread.yield();
        }
    }

    public void g() {
        synchronized (syncObject) {
            for (int i = 0; i < 5; i++) {
                System.out.println("g()");
                Thread.yield();
            }
        }
    }

}
