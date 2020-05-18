package org.ms.thinkInJava.concurrency;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/6/19 23:21
 */
public class PairChecker implements Runnable {

    private PairManager pm;

    public PairChecker(PairManager pm) {
        this.pm = pm;
    }

    @Override
    public void run() {
        while (true) {
            pm.checkCounter.incrementAndGet();
            pm.getPair().checkState();
        }
    }
}
