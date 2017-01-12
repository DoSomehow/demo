package org.ms.thinkInJava.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/1/12 0012.
 */
public class SimpleDiaemons implements Runnable {
    @Override
    public void run() {
        try{
            while (true){
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + "  " + this);
            }
        }catch (InterruptedException e){
            System.out.println("sleep() interrupted");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for(int i = 0; i < 10; i++){
            Thread daemon = new Thread(new SimpleDiaemons());
            daemon.setDaemon(true);
            daemon.start();
        }
        System.out.println("All daemons started");
        TimeUnit.MILLISECONDS.sleep(175);  //调整该时间，从而调整main()线程结束时间
    }
}
