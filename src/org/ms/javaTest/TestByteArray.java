package org.ms.javaTest;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class TestByteArray {

    public static void main(String[] args) {

        test();

    }

    public static void test(){
        try {
            byte[] before = new byte[] {80, 75, 3, 4, 10, 60, 82, -83, 68, 8, 0, 28, 0, 80, 97, 121, 108, 108};

            String str = new String(before, "GBK");
            System.out.println("str:" + str);

            byte[] after = str.getBytes("GBK");

            System.out.println("before= "+ Arrays.toString(before));
            System.out.println("after = "+Arrays.toString(after));

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
