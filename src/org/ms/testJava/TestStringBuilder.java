package org.ms.testJava;

import java.util.Random;

/**
 * Created by Administrator on 2017/1/6.
 */
public class TestStringBuilder {

    public static void main(String[] args) {
        testDelete();
    }

    public static void testDelete(){
        StringBuilder sb = new StringBuilder();
        Random rand = new Random(47);
        for (int i = 0; i < 5; i++) {
            sb.append(rand.nextInt(9));
            // sb.append(",");
        }
        System.out.println(sb.toString());
        System.out.println(sb.length());
        sb.delete(sb.length()-1, sb.length());
        System.out.println(sb.toString());
    }

}
