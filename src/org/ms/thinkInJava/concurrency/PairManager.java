package org.ms.thinkInJava.concurrency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/6/19 0:23
 */
abstract class PairManager {  //Protect a Pair inside a thread-safe class:

    AtomicInteger checkCounter = new AtomicInteger(0);
    protected Pair p = new Pair();

    private List<Pair> storage = Collections.synchronizedList(new ArrayList<Pair>());

    public synchronized Pair getPair() {
        //Make a copy to keep ths original safe:
        return new Pair(p.getX(), p.getY());
    }

    //Assume this is a time consuming operation
    protected void store(Pair p) {
        storage.add(p);
        try {
            TimeUnit.MILLISECONDS.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public abstract void increment();

}
