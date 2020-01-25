package org.ms.javaTest.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestExecutorService {

    class MyTask implements Runnable {
        private Integer num;

        public MyTask(Integer num) {
            this.num = num;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("num: " + num);
        }
    }

    public void testSingleThreadExecutor() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new MyTask(i));
        }
    }


    public static void main(String[] args) {
        TestExecutorService tes = new TestExecutorService();
        tes.testSingleThreadExecutor();
    }

}
