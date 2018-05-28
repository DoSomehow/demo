package org.ms.javaTest;

public class TestIndexOf {

    public static void main(String[] args) {
        // test();
        // testSecondArgument();
        mutilIndexOf();
    }

    public static void mutilIndexOf(){
        String str = "abc def ghi";
        int x = str.indexOf("d");
        System.out.println("x: " + x);
        System.out.println(str.substring(x));
    }

    public static void test(){

        String str = "abcdefg  file=";
        int x = str.indexOf("file=");
        System.out.println("x: " + x);  //9

        String reuslt = str.substring(x);
        System.out.println("result: " + reuslt);  //file=

    }

    public static void testSecondArgument(){
        String str = "abc def ghi";
        int x = str.indexOf("d");
        System.out.println("x: " + x);  //4
        int y = str.indexOf("g", x);
        System.out.println("y: " + y);  //8
    }

}
