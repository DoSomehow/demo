package org.ms.javaTest;

import java.util.HashMap;
import java.util.Map;

public class TestByte {

    public static void main(String[] args) {
         strToByteArr();
        // byteArrToStr();
        // byteArrAddStr();
//        byteArr2Str2ByteArr();
    }

    public static void byteArr2Str2ByteArr(){
        String str = "abcdefgh";
        byte[] source = str.getBytes();

        String mid = new String(source);

        byte[] dest = mid.getBytes();

    }

    public static void strToByteArr(){
        String str = "abcdefgh1";
        byte[] arr = str.getBytes();
        System.out.println(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + ": " + arr[i]);
        }
    }

    public static void byteArrAddStr(){
        String baseStr = "abcdefgh";
        byte[] arr = baseStr.getBytes();
        System.out.println("bufferOut=" + arr);

        System.out.println("bufferOut2=" + arr);

        Map<String, Object> map = new HashMap<>();
        map.put("photo", arr);
        System.out.println("bufferOut3=" + map.get("photo"));
    }

    public static void byteArrToStr(){
        String str = "abcdefgh";
        byte[] arr = str.getBytes();
        System.out.println(arr);

        String newStr = new String(arr);
        System.out.println(newStr);
    }

}
