package org.ms.thinkInJava.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * @Author mydre
 * @Description
 * @Date Created in 2020/5/17
 */
public class SleepBlocked implements Runnable {

    @Override
    public void run() {

        try {
            TimeUnit.SECONDS.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        }
        System.out.println("Exiting SleepBlocked.run()");

    }
}
