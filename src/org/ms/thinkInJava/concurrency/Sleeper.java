package org.ms.thinkInJava.concurrency;

/**
 * Created by Administrator on 2017/1/12 0012.
 */
public class Sleeper extends Thread {
    private int duration;
    public Sleeper(String name, int sleepTime){
        super(name);
        this.duration = sleepTime;
        start();
    }

    @Override
    public void run() {
        try {
            sleep(duration);
        } catch (InterruptedException e) {
            System.out.println(getName() + " was interrupted. isInterrupted():" + isInterrupted() );
            //当另一个线程在该线程上调用interrupt()时，将给该线程设定一个标志，表明该线程已经中断。然而，异常被捕获时
            //将清理这个标志，在catch子句中，在异常被捕获时这个标志总是为false。
        }
        System.out.println(getName() + " has awakened");
    }
}
