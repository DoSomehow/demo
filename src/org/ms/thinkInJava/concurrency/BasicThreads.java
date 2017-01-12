package org.ms.thinkInJava.concurrency;

/**
 * Created by Administrator on 2017/1/9 0009.
 */
public class BasicThreads {
    public static void main(String[] args) {
        Thread t = new Thread(new LiftOff());
        t.start();
        System.out.println("Waiting for LiftOff");
    }
}
