package org.ms.thinkInJava.strings;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/1/8.
 */
public class BetterRead {
    public static BufferedReader input = new BufferedReader(new StringReader("Sir Robin of Camelot\n 22 1.61803"));

    public static void main(String[] args) {
        Scanner in = new Scanner(input);
        System.out.println("What is your name?");
        String name = in.nextLine();
        System.out.println(name);
        System.out.println("How old are you? What is your favorite double?");
        System.out.println("(input: <age> <double>)");
        int age = in.nextInt();
        double favorite = in.nextDouble();
        System.out.println(age);
        System.out.println(favorite);
        System.out.format("Hi %s.\n", name);
        System.out.format("In 5 years you will be %d.\n", age + 5);
        System.out.format("My favorite double is %f.", favorite / 2 );
        System.out.println();
        // Pattern p = in.delimiter();
        // System.out.println(p);
    }
}
