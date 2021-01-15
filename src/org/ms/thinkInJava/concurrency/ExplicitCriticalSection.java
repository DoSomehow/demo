package org.ms.thinkInJava.concurrency;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/6/19 23:30
 */
public class ExplicitCriticalSection {

    public static void main(String[] args) throws Exception {
        PairManager pman1 = new ExplicitPairManager1();
        PairManager pman2 = new ExplicitPairManager2();
        CriticalSection.testApproaches(pman1, pman2);
    }

}
