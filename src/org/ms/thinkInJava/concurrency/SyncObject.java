package org.ms.thinkInJava.concurrency;

/**
 * @Author mydre
 * @Description
 * @Date Created in 2020/5/15
 */
public class SyncObject {

    public static void main(String[] args) {
        final DualSynch ds = new DualSynch();
        new Thread(){
            public void run() {
                ds.f();
            }
        }.start();
        ds.g();
    }

}
