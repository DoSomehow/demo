package org.ms.javaTest.concurrent;

public class TestRunnable {

    class MyTask implements Runnable {
        private Integer num = 0;

        @Override
        public void run() {
            num++;
            System.out.println("my num: " + num);
        }
    }

    public void testCommonVari() {
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new MyTask());
            thread.start();
        }
    }

    public static void main(String[] args) {
        TestRunnable tr = new TestRunnable();
        tr.testCommonVari();
    }

}
