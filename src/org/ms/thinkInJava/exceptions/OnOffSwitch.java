package org.ms.thinkInJava.exceptions;

/**
 * Created by Administrator on 2017/1/2.
 */
public class OnOffSwitch {
    private  static Switch sw = new Switch();
    public static void f() throws OnOffException1, OnOffException2 { }

    public static void main(String[] args){
        try{
            sw.on();
            f();  //为什么这样捕获不了异常？  答：因为人家f()方法只是声明了会抛出那两种异常，但执行过程中并没有发生这两种异常
            // throw new OnOffException1();
            sw.off("try");
        }catch (OnOffException1 e){
            System.out.println("OnOffException1");
            sw.off("OnOffException1");
        }catch (OnOffException2 e){
            System.out.println("OnOffException2");
            sw.off("OnOffException2");
        }
    }
}
