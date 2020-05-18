package org.ms.javaTest.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestSynchronized {

    class TaskOne implements Runnable {
        private Object lockObject = new Object();
        private String name;
        private Long duration;

        public TaskOne(String name, Long duration) {
            this.name = name;
            this.duration = duration;
        }

        @Override
        public void run() {
            System.out.println("start run " + name);
            synchronized (lockObject) {
                long start = System.currentTimeMillis();
                while (true) {
                    long end = System.currentTimeMillis();
                    if ((end - start) / 1000 == duration) {
                        System.out.println("my name is " + name);
                        break;
                    }
                }
            }
        }
    }

    //主要用来测试上边TaskOne中的lockObject对象。如果这个对象是TaskOne的，那么下边每次new TaskOne，则相当于各自有一个lockObject，因此实际不能达到同步的作用。
    //但是如果把lockObject放到了TestSynchronized中，那么下边每次new TaskOne，它们实际都是用的同一个lockObject，那么才能达到同步的效果。
    public void testObjLock() {
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(new TaskOne("Tom", 4L));
        service.execute(new TaskOne("Jerry", 2L));
    }

    public static void main(String[] args) {
        TestSynchronized ts = new TestSynchronized();
        ts.testObjLock();
    }


}
