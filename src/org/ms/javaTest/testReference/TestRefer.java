package org.ms.javaTest.testReference;

/**
 * Created by Administrator on 2017/1/16.
 */
public class TestRefer {
    public static void main(String[] args) {
        test();
    }

    public static void test(){
        Hello h1 = new Hello("张三");
        Hello h2 = h1;
        h1 = new Hello("李四");
        h2.say();
    }
}
