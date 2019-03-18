package org.ms.thinkInJava.containers;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/3/18 22:40
 */
public class VeryBig {

    private static final int SIZE = 10000;
    private long[] la = new long[SIZE];
    private String ident;
    public VeryBig(String id) {
        ident = id;
    }

    @Override
    public String toString() {
        return ident;
    }

    protected void finalize(){
        System.out.println("Finalizing " + ident);
    }
}
