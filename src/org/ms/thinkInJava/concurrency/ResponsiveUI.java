package org.ms.thinkInJava.concurrency;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/4/3 23:36
 */
public class ResponsiveUI extends Thread {

    private static volatile double d = 1;
    public ResponsiveUI() {
        setDaemon(true);
        start();
    }

    public void run() {
        while (true) {
            d = d + (Math.PI + Math.E) / d;
        }
    }

    public static void main(String[] args) throws Exception {
        //new UnresponsiveUI();  //Must kill this process
        new ResponsiveUI();
        System.in.read();
        System.out.println(d);  //Shows progress1
    }

}
