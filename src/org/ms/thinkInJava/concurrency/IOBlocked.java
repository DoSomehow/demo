package org.ms.thinkInJava.concurrency;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author mydre
 * @Description
 * @Date Created in 2020/5/17
 */
public class IOBlocked implements Runnable{

    private InputStream in;

    public IOBlocked(InputStream is) {
        this.in = is;
    }

    @Override
    public void run() {
        try {
            System.out.println("Wating for read():");
            in.read();
        } catch (IOException e) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Interrupted from blocked I/O");
            } else {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Exiting IOBlocked.run()");
    }
}
