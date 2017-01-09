package org.ms.thinkInJava.exceptions;

/**
 * 异常丢失2
 * Created by Administrator on 2017/1/3.
 */
public class ExceptionSliencer {

    public static void main(String[] args) {
        try{
            throw new RuntimeException();
        }finally {
            return;  //在finally块中使用“return”，将会对任何抛出的异常保持沉默，即不会产生任何输出
            // System.out.println("finally");
        }

    }

}
