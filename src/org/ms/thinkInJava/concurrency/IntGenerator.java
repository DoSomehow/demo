package org.ms.thinkInJava.concurrency;

/**
 * Created by Administrator on 2017/1/13 0013.
 */
public abstract class IntGenerator {
    private volatile boolean canceled = false;
    public abstract int next();
    public void canceled() { canceled = true; }
    public boolean isCanceled() { return canceled; }
}
