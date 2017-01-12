package org.ms.thinkInJava.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/1/9 0009.
 */
public class SleepingTask extends LiftOff {
    public void run(){
        try {
            while (countDown-- > 0) {
                System.out.print(status());
                // Thread.sleep(100);  //老方法
                TimeUnit.MILLISECONDS.sleep(100);  //java SE5/6 之后的方法
                System.out.println();
            }
        } catch (InterruptedException e){
            System.err.println("Interrupted");
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0; i < 5; i++){
            exec.execute(new SleepingTask());
        }
        exec.shutdown();;
    }
}
