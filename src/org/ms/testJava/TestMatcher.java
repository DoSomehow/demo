package org.ms.testJava;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/1/8.
 */
public class TestMatcher {
    public static void main(String[] args) {
        String str = "Hello, I am Wang Shangyu";
        Pattern p = Pattern.compile("\\w+");
        Matcher m = p.matcher(str);
        // while(m.find()){
        //     System.out.println("find() "+ m.group());
        // }
        int i = 0;
        while(m.lookingAt()){
            System.out.println("lookingAt() "+m.group());
            if(i > 10) break;
            i++;
        }
    }
}
