package org.ms.thinkInJava.arrays;

import java.util.Arrays;
import java.util.Random;

public class RaggedArray {

    public static void main(String[] args) {
        Random rand = new Random(47);
        //3 - D array with varied-length vectors:
        int[][][] a = new int[rand.nextInt(7)][][];
        // System.out.println("a.length: " + a.length);
        for (int i = 0; i < a.length; i++) {
            a[i] = new int[rand.nextInt(5)][];
            // System.out.println("a[" + i + "].length: " + a[i].length);
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = new int[rand.nextInt(5)];
                // System.out.println("a["+i+"]["+j+"].length: " + a[i][j].length);
            }
        }
        System.out.println(Arrays.deepToString(a));
    }

}
