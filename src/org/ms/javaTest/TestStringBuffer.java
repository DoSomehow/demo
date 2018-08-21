package org.ms.javaTest;

public class TestStringBuffer {

    public static void main(String[] args) {
        charAtWithChinese();
    }

    //带汉字情况下的charAt
    private static void charAtWithChinese(){
        StringBuffer sb = new StringBuffer();
        sb.append("abc 哈哈哈 123");
        System.out.println("length: " + sb.length());
        for(int i = 0; i < sb.length(); i++){
            System.out.println(sb.charAt(i));
        }
    }

}
