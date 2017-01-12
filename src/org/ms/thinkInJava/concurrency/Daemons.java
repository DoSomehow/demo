package org.ms.thinkInJava.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/1/12 0012.
 */
public class Daemons {
    public static void main(String[] args) throws InterruptedException {
        Thread d = new Thread(new Daemon());
        d.setDaemon(true);  //后台线程创建的任何线程将被自动设置为后台线程
        d.start();
        System.out.println("d.isDaemon() = " + d.isDaemon() + ", ");  //isDaemon()方法可以确定线程是否是一个后台线程
        //允许后台线程完成它们的启动进程
        TimeUnit.SECONDS.sleep(1);
    }
}
