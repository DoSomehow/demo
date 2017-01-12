package org.ms.thinkInJava.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/1/12 0012.
 */
public class ADaemon implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("Starting ADaemon");
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            System.out.println("Exiting via InterruptedException");
        }finally {
            System.out.println("This should always run ?");
            //当最后一个非后台线程终止时，后台线程会“突然”终止。因此一旦main()退出，JVM就会关闭所有的后台线程，而不会有
            //任何你希望出现的确认形式。因为你不能以优雅的方式关闭后台线程，所以它们几乎不是一种好的思想。
            //非后台的Executor通常是一种更好的方式，因为Executor控制的所有任务可以同时被关闭。在这种情况下，关闭将以有序
            //的方式执行。
        }
    }
}
