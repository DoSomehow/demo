package org.ms.thinkInJava.concurrency;

/**
 * @Author mydre
 * @Description
 * @Date Created in 2020/5/17
 */
public class NeedsCleanup {

    private final int id;

    public NeedsCleanup(int id) {
        this.id = id;
        System.out.println("NeedsCleanup " + id);
    }

    public void cleanup() {
        System.out.println("Cleaning up " +id);
    }
}
