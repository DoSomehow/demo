package org.ms.thinkInJava.concurrency;

/**
 * Created by Administrator on 2017/1/9 0009.
 */
public class LiftOff implements Runnable {
    protected int countDown = 10;  //Default
    private static int taskCount = 0;
    private final int id = taskCount++;

    public LiftOff(){}

    public LiftOff(int countDown){
        this.countDown = countDown;
    }

    public String status(){
        return "#" + id + "(" + (countDown > 0 ? countDown : "Lift Off!") + "), ";
    }

    public void run(){
        while(countDown-- > 0){
            System.out.print(status());
            Thread.yield();  //让步，不过这只是一个暗示，没有任何机制保证它将被采纳
        }
    }
}
