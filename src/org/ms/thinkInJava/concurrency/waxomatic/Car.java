package org.ms.thinkInJava.concurrency.waxomatic;

/**
 * @Author mydre
 * @Description
 * @Date Created in 2020/5/18
 */
public class Car {

    private boolean waxOn = false;

    public synchronized void waxed() {
        waxOn = true;  //Ready to buff
        notifyAll();
    }

    public synchronized void buffed() throws InterruptedException {
        waxOn = false;  //Ready for another coat of wax
        notifyAll();
    }

    public synchronized void waitForWaxing() throws InterruptedException {
        while (waxOn == false) {
            wait();
        }
    }

    public synchronized void waitForBuffing() throws InterruptedException {
        while (waxOn == true) {
            wait();
        }
    }

}
