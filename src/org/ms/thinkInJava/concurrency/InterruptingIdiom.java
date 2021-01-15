package org.ms.thinkInJava.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * @Author mydre
 * @Description
 * @Date Created in 2020/5/17
 */
public class InterruptingIdiom {

    public static void main(String[] args) throws InterruptedException {
//        if (args.length != 1) {
//            System.out.println("usage: java InterruptingIdiom delay-in-mS");
//            System.exit(1);
//        }
//        int delayTime = 1100;  //在point1和point2之间打断  //阻塞，抛异常打断
        int delayTime = 2038;  //在point2之后打断  //非阻塞，通过调用interrupted()来检查中断状态

        Thread t = new Thread(new Blocked3());
        t.start();
//        TimeUnit.MILLISECONDS.sleep(new Integer(args[0]));
        TimeUnit.MILLISECONDS.sleep(delayTime);
        t.interrupt();
    }

}
