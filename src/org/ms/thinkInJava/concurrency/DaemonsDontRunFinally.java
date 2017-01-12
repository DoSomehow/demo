package org.ms.thinkInJava.concurrency;

/**
 * Created by Administrator on 2017/1/12 0012.
 */
public class DaemonsDontRunFinally {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new ADaemon());
        t.setDaemon(true);
        t.start();
        // TimeUnit.SECONDS.sleep(2);
    }
}
