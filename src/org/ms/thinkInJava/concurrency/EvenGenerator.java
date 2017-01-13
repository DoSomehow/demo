package org.ms.thinkInJava.concurrency;

/**
 * Created by Administrator on 2017/1/13 0013.
 */
public class EvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;

    @Override
    public int next() {  //每次++两次，所以如果资源不被占用，那么将一直产生偶数。
        ++currentEvenValue;  //Danger point here!
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator());
    }
}
