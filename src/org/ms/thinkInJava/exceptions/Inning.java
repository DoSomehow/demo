package org.ms.thinkInJava.exceptions;

/**
 * Created by Administrator on 2017/1/3.
 */
public abstract class Inning {
    public Inning() throws BaseballException{
    }

    public void event() throws BaseballException {
        // 不必必须抛出一个异常
    }

    public abstract void atBat() throws Strike, Foul;

    public void walk() throws PopFoul {
        //该方法不抛出任何异常
    }
}
