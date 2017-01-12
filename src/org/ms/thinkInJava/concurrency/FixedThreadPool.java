package org.ms.thinkInJava.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2017/1/9 0009.
 */
public class FixedThreadPool {
    public static void main(String[] args) {
        //构造器参数是线程数量
        ExecutorService exec = Executors.newFixedThreadPool(4);  //此时同时最多执行4个线程，剩余一个要等到有一个已经完成后，才可以执行
        for(int i = 0; i < 5; i++){
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}
