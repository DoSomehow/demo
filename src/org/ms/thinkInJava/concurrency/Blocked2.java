package org.ms.thinkInJava.concurrency;

/**
 * @Author mydre
 * @Description
 * @Date Created in 2020/5/17
 */
public class Blocked2 implements Runnable {
    BlockedMutex blocked = new BlockedMutex();

    @Override
    public void run() {
        System.out.println("Waiting for f() in BlockedMutex");
        blocked.f();
        System.out.println("Broken out of blocked call");
    }
}
