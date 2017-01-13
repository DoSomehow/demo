package org.ms.testJava;

/**
 * Created by Administrator on 2017/1/13 0013.
 */
public class TestOperator {
    public static void main(String[] args) {
        testQuYu();
    }

    public static void testQuYu(){
        for(int i = 0; i < 10; i++){
            System.out.println(i % 2 == 0);
        }
    }
}
