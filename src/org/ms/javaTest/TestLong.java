package org.ms.javaTest;

import org.ms.javaTest.entity.Wang;

/**
 * @author Ryan
 * @date 2020/11/20 9:18
 */
public class TestLong {

    public static void main(String[] args) {
        // testAddrRef();
        // testDivide();
        testUnexactDivide();
        // testNullStringToLong();
    }



    //测试空字符串转Long
    private static void testNullStringToLong() {
        // String str = null;
        // Long result = Long.valueOf(str);
        // System.out.println("result: " + result);

        Object obj = null;
        String str_2 = String.valueOf(obj);
        Long result_2 = Long.valueOf(str_2);
        System.out.println("result_2: " + result_2);
    }

    //测试非整除
    private static void testUnexactDivide() {
        Long x = 3L;
        Long y = 2L;
        Long result = x / y;
        System.out.println(result);
    }

    //测试除法
    private static void testDivide() {
        Long a = 2L;
        Long b = 3L;
        Long result = a / b;
        Double convertResult = Double.valueOf(String.valueOf(a)) /  Double.valueOf(String.valueOf(b));
        System.out.println(String.valueOf(result));
        System.out.println(String.valueOf(convertResult));
    }

    //测试地址引用
    private static void testAddrRef() {
        TestLong tl = new TestLong();
        Wang wang = new Wang();
        wang.setCap(100L);
        tl.test(wang.getCap());
        System.out.println("main: " + wang.getCap());
        System.out.println("main obj addr: " + wang.getCap().hashCode());
        System.out.println();
        long cap = 200L;
        tl.test2(cap);
        System.out.println("main: " + cap);
    }

    private void test(Long cap){
        System.out.println("test start: " + cap.hashCode());
        cap++;  //这里操作之后，对象变了，应该是指向了一个新的Long对象
        System.out.println("test: " + cap);
        System.out.println("test obj addr: " + cap.hashCode());
    }

    private void test2(long cap) {
        cap++;
        System.out.println("test2: " + cap);
    }

}
