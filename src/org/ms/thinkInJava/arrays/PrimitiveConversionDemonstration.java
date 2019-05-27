package org.ms.thinkInJava.arrays;

import org.ms.thinkInJava.util.ConvertTo;
import org.ms.thinkInJava.util.CountingGenerator;
import org.ms.thinkInJava.util.Generated;

import java.util.Arrays;

public class PrimitiveConversionDemonstration {

    public static void main(String[] args) {
        Integer[] a = Generated.array(Integer.class, new CountingGenerator.Integer(), 15);

        int[] b = ConvertTo.primitive(a);
        System.out.println(Arrays.toString(b));

        boolean[] c = ConvertTo.primitive(Generated.array(Boolean.class, new CountingGenerator.Boolean(), 7));
        System.out.println(Arrays.toString(c));
    }

}
