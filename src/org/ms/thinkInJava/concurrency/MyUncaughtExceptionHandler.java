package org.ms.thinkInJava.concurrency;

/**
 * Created by Administrator on 2017/1/13 0013.
 */
public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("caught " + e);
    }
}
