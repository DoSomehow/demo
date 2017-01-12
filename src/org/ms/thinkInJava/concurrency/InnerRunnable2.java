package org.ms.thinkInJava.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/1/12 0012.
 */
public class InnerRunnable2 {
    private int countDown = 5;
    private Thread t;
    public InnerRunnable2(String name){
        t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true){
                        System.out.println(this);
                        if(--countDown == 0) return;
                        TimeUnit.MILLISECONDS.sleep(10);
                    }
                } catch (InterruptedException e) {
                    System.out.println("sleep() interrupted");
                }
            }
            public String toString(){
                return t.getName() + ": " + countDown;
            }
        }, name);
        t.start();
    }
}
