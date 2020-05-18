package org.ms.thinkInJava.concurrency;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/4/22 23:48
 */
public class SerialNumberGenerator {

    private static volatile int serialNumber = 0;
    public static int nextSerialNumber() {
        return serialNumber++;  //Not thread-safe
    }

}
