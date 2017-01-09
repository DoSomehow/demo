package org.ms.thinkInJava.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/1/8.
 */
public class StartEnd {
    public static String INPUT =
            "As long as there is injustice, whenever a\n" +
            "Targathian baby cries out, wherever a distress\n" +
            "signal sounds among the stars ... We'll be there.\n" +
            "This fine ship, and this fine crew ...\n" +
            "Never give up! Never surrender!";

    //嵌套类
    private static class Display {
        private boolean regexPrinted = false;
        private String regex;
        Display(String regex) { this.regex = regex; }
        void display(String message) {
            if(!regexPrinted) {
                System.out.println(regex);
                regexPrinted = true;
            }
            System.out.println(message);
        }
    }

    public static void examine(String s, String regex) {
        Display d = new Display(regex);
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(s);

        while(m.find()){  //可以在输入的任意位置定位正则表达式
            d.display("find() '" + m.group() + "' start = " + m.start() + " end = " + m.end());
        }

        if(m.lookingAt()) {  //只能从输入的最开始出，也就是第一个字符开始处进行匹配，且只能匹配成功第一部分。
            d.display("lookingAt() start = " + m.start() + " end = " + m.end());
        }

        if(m.matches()) {  //这个也是必须从最开始处，即第一个字符开始匹配，但必须是整个输入都匹配才算成功。
            d.display("matches() start = " + m.start() + " end = " + m.end() );
        }
    }

    public static void main(String[] args) {
        String[] arr = new String[]{"\\w*ere\\w*", "\\w*ever", "T\\w+", "Never.*?!"};
        for(String in : INPUT.split("\n")){
            System.out.println("input: " + in);
            for(String regex : arr){
                examine(in, regex);
            }
        }
    }
}
