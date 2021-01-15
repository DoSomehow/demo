package org.ms.javaTest.concurrent;

/**
 * @Author mydre
 * @Description
 * @Date Created in 2020/5/18
 */
public class TestWaitAndNotify {

    public static void main(String[] args) {
        TestWaitAndNotify twan = new TestWaitAndNotify();
        twan.aaa();

    }

    public void aaa() {
        Thread t = new Thread(new Task());
        t.start();
    }

    private class Task implements Runnable {
        private Object obj = new Object();

        @Override
        public void run() {
            fff();
        }

//        public void fff() {
    public synchronized void fff() {
            try {
                obj.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }







}
