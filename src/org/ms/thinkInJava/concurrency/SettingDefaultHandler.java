package org.ms.thinkInJava.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2017/1/13 0013.
 */
public class SettingDefaultHandler {
    public static void main(String[] args) {
        //设置默认的未捕获异常处理器
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new ExceptionThread2());
    }
    //这个处理器只有在不存在线程专有的未捕获异常处理器的情况下才会被调用。系统会检查线程专有版本，如果没有发现，则检查
    //线程组是否有其专有的uncaughtException()方法，如果也没有，再调用defaultUncaughtExceptionHandler()。
}
