package org.ms.thinkInJava.concurrency;

import java.util.concurrent.Callable;

/**
 * Created by Administrator on 2017/1/9 0009.
 */
public class TaskWithResult implements Callable<String> {
    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    public String call(){
        return "result of TaskWithResult " + id;
    }
}
