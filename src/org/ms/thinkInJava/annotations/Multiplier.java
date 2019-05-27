package org.ms.thinkInJava.annotations;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/3/29 23:12
 */
@ExtractInterface("IMultiplier")
public class Multiplier {

    public int multiply(int x, int y) {
        int total = 0;
        for (int i = 0; i < x; i++) {
            total = add(total, y);
        }
        return total;
    }

    private int add(int x, int y) {
        return x + y;
    }

    public static void main(String[] args) {
        Multiplier m = new Multiplier();
        System.out.println("11 * 16 = " + m.multiply(11,16));
    }
}
