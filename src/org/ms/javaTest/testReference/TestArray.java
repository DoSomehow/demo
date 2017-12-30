package org.ms.javaTest.testReference;

/**
 * Created by Ryan on 2017/10/23.
 */
public class TestArray {

    public static void main(String[] args) {
        over255();
    }

    private static void over255(){
        String[] array = new String[256];
        array[0] = "1";
    }

}
