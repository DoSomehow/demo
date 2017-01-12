package org.ms.thinkInJava.concurrency;

/**
 * Created by Administrator on 2017/1/9 0009.
 */
public class MoreBasicThreads {
    public static void main(String[] args) {
        for(int i = 0; i < 5; i++){
            new Thread(new LiftOff()).start();
        }
        System.out.println("Waiting for LiftOff");
    }
}
