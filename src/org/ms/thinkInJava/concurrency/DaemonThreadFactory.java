package org.ms.thinkInJava.concurrency;

import java.util.concurrent.ThreadFactory;

/**
 * Created by Administrator on 2017/1/12 0012.
 */
public class DaemonThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    }
}
