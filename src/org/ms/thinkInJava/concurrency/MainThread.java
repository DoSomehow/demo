package org.ms.thinkInJava.concurrency;

/**
 * Created by Administrator on 2017/1/9 0009.
 */
public class MainThread {
    public static void main(String[] args) {
        LiftOff launch = new LiftOff();
        launch.run();
    }
}
