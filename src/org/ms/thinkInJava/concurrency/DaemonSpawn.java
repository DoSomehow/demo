package org.ms.thinkInJava.concurrency;

/**
 * Created by Administrator on 2017/1/12 0012.
 */
public class DaemonSpawn implements Runnable {
    @Override
    public void run() {
        while (true) Thread.yield();
    }
}
