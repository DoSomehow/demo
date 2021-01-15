package org.ms.javaTest.concurrent;

public class TestException {

    public static void main(String[] args) {
        TestException te = new TestException();
        te.testCatchExcepiton();
    }

    public void testCatchExcepiton() {
        Thread t1 = new Thread(new MyTask());
        t1.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("I catch uncaughtException");
            }
        });
        try {
            t1.start();
        } catch (Exception e) {
            System.out.println("Report! Catch exceptions!");
        }
    }

    private class MyTask implements Runnable {
        @Override
        public void run() {
            System.out.println("Start run task");
            throw new RuntimeException("OMG! Errors happen!");
        }
    }


}
