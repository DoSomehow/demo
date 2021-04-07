package org.ms.javaTest.testException;

import java.io.*;

/**
 * @author Ryan
 * @date 2021/2/14 10:13
 */
public class TestExceptionChain {

    public static void main(String[] args) {

    }

    public static void testChain() throws Throwable {

        try {
            File file = new File("D:/my.txt");
            BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
            in.read();
        } catch (IOException e) {
            Throwable te = new RuntimeException();
            te.initCause(e);
            throw te;
        }


    }

}
