package org.ms.javaTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Date;

/**
 * Created by Administrator on 2017/1/2.
 */
public class TestSystemIO {

    public static void main(String[] args){

        // testSystemErr();
        redirectSystemOut();
    }

    public static void redirectSystemOut(){
        try {
            //对标准输出进行重定向
            System.setOut(new PrintStream(new FileOutputStream(new File("C:\\Users\\Administrator\\Desktop\\TestRedirect.txt"))));
            System.out.println("Hello!");
            System.out.println("I am the System.out after redirected");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void testSystemErr(){
        // System.err打出来的信息常常会跑到System.out信息的前面去
        System.err.println(new Date() + "method start...");
        System.out.println("I am the body of method");
        System.out.println(new Date() + "method end...");
        //当输出一个流时，JVM和操作系统共同决定何时输出这个流。也就是说，尽管开发者键入了System.out
        //JVM和操作系统的组合体并不会立即输出这个流。相反，它将保持等待状态直到将要输出的东西达到一定的量。
        //假设输入以下指令：System.out.println("Debugging   Info."); JVM可能同意输出；然而，操作系统可能决定暂不输出。
        //使用System.err来报告错误、调试程序就可以避免这种情况出现，它将使每一次操作的结果都输出出来。
        //System.out.println可能会被缓冲,而System.err.println不会
    }

}
