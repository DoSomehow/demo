package org.ms.thinkInJava.concurrency;

/**
 * Created by Administrator on 2017/1/12 0012.
 */
public class ThreadMethod {
    private int countDown = 5;
    private Thread t;
    private String name;
    public ThreadMethod(String name){ this.name = name; }
    public void runTask(){
        if(t == null){
            t = new Thread(name){
                public void run(){
                    try {
                        while (true){
                            System.out.println(this);
                            if(--countDown == 0) return;
                            sleep(10);
                        }
                    } catch (InterruptedException e) {
                        System.out.println("sleep() interrupted");
                    }
                }
                public String toString(){
                    return getName() + ": " + countDown;
                }
            };
            t.start();
        }
    }
}
