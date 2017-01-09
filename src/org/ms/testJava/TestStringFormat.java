package org.ms.testJava;

/**
 * Created by Administrator on 2017/1/6.
 */
public class TestStringFormat {

    public static void main(String[] args) {
        dump();
    }

    public static void dump(){
        byte[] data = new byte[32];
        for(int i = 0; i < 32; i++){
            data[i] = (byte)(i+90);
        }

        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for(byte b:data){
            sb.append(String.format("%04x ", b));
            sb2.append(String.format("%x ", b));
        }
        System.out.println(sb.toString());
        System.out.println(sb2.toString());

    }

}
