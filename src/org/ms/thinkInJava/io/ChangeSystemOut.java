package org.ms.thinkInJava.io;

import java.io.PrintWriter;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/3/21 21:37
 */
public class ChangeSystemOut {

    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out, true);
        out.println("Hello, world");
    }

}
