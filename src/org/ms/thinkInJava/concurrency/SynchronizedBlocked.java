package org.ms.thinkInJava.concurrency;

/**
 * @Author mydre
 * @Description
 * @Date Created in 2020/5/17
 */
public class SynchronizedBlocked implements Runnable {

    public synchronized void f() {
        while (true) {  //Never releases lock
            Thread.yield();
        }
    }
    public SynchronizedBlocked() {
        new Thread(){
          public void run() {
              f();  //Lock acquired by this thread
          }
        }.start();
    }

    @Override
    public void run() {
        System.out.println("Trying to call f()");
        f();
        System.out.println("Exiting SynchronizedBlocked.run()");
    }
}
