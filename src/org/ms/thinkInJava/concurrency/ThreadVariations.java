package org.ms.thinkInJava.concurrency;

/**
 * Created by Administrator on 2017/1/12 0012.
 */
public class ThreadVariations {
    public static void main(String[] args) {
        new InnerThread1("InnerThread 1");
        new InnerThread2("InnerThread 2");
        new InnerRunnable1("InnerRunnable 1");
        new InnerRunnable2("InnerRunnable 2");
        new ThreadMethod("ThreadMethod").runTask();
    }
}
