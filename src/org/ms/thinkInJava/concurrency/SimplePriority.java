package org.ms.thinkInJava.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2017/1/12 0012.
 */
public class SimplePriority implements Runnable{
    private int countDown = 5;
    private volatile double d;  //努力确保使得不进行任何编译器优化
    private int priority;

    public SimplePriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        //Thread.currentThread打印出的信息包含"线程的名称","线程的优先级","线程所属的线程组"
        return Thread.currentThread() + ": " + countDown;
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(priority);  //在构造器中设置优先级没有任何好处，因为Executor在此刻还没有开始执行任务
        while (true){
            //一个开销大的，可打断的操作
            for(int i = 1; i < 100000; i++){
                d += (Math.PI + Math.E) / (double)i;  //加入这些运算是为了容易看出设置优先级的效果
                if(i % 1000 ==0){
                    Thread.yield();
                }
            }
            System.out.println(this);
            if(--countDown == 0) return;
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0; i < 5; i++){
            exec.execute(new SimplePriority(Thread.MIN_PRIORITY));
        }
        exec.execute(new SimplePriority(Thread.MAX_PRIORITY));
        exec.shutdown();
    }
}
