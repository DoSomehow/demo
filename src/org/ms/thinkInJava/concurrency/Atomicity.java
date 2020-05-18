package org.ms.thinkInJava.concurrency;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/4/22 23:27
 */
public class Atomicity {

    int i;
    void f1() {
        i++;
    }
    void f2() {
        i += 3;
    }

}
