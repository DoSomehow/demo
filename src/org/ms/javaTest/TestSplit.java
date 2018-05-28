package org.ms.javaTest;

/**
 * Created by Ryan on 2017/9/8.
 */
public class TestSplit {

    public static void main(String[] args) {
        // moreBlank();
        emptyBeginOrEnd();
    }

    private static void emptyBeginOrEnd(){
        // String str = "@123";  //这种情况下，数组长度为 2
        String str = "123@";  //这种情况下，数组长度为 1
        String[] arr = str.split("@");
        for (int i = 0; i < arr.length; i++){
            System.out.println(i + ": " + arr[i]);
        }
    }

    private static void moreBlank(){
        String str = "equipCateg       01   电能表";
        String[] arr = str.split("\\s+");
        for (int i = 0; i < arr.length; i++){
            System.out.println(i + ": " + arr[i]);
        }
    }

}
