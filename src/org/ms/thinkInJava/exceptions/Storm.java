package org.ms.thinkInJava.exceptions;

/**
 * Created by Administrator on 2017/1/3.
 */
public interface Storm {
    public void event() throws RainedOut;

    public void rainHard() throws RainedOut;
}
