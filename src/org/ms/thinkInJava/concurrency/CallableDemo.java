package org.ms.thinkInJava.concurrency;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 从任务中获取返回值
 * Created by Administrator on 2017/1/9 0009.
 */
public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> resultList = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            resultList.add(exec.submit(new TaskWithResult(i)));  //必须使用ExecutorService.submit()方法调用
        }
        for(Future<String> fs : resultList){
            try {
                // fs.isDone()  该方法用来查询Future是否已经完成
                System.out.println(fs.get());
            } catch (InterruptedException e) {
                System.out.println(e);
                return;
            } catch (ExecutionException e) {
                System.out.println(e);
            } finally {
                exec.shutdown();
            }
        }
    }
}
