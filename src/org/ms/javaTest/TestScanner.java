package org.ms.javaTest;

import java.util.Scanner;
import java.util.regex.MatchResult;

/**
 * Created by Administrator on 2017/1/8.
 */
public class TestScanner {
    public static void main(String[] args) {
        // testHasNextWithArg();
        // testHasNext();
        // testHasNext2();
        testHasNextWithArg2();
    }


    public static void testHasNext(){
        String input2 = "Hello I am WangShangyu && Welcome here To be yourself at home";
        Scanner sc = new Scanner(input2);
        String regex = "\\w+";
        while(sc.hasNext()){
            if(sc.hasNext(regex)){
                System.out.print(sc.next());
                System.out.print(" - ");
            }else{
                sc.next();
            }
        }
    }

    public static void testHasNext2(){
        String input = "Hello,I am WangShangyu,Welcome here,To be yourself at home";
        Scanner sc = new Scanner(input);
        sc.useDelimiter(",");
        String regex = "\\w+";
        while(sc.hasNext()){
            if(sc.hasNext(regex)){
                System.out.print(sc.next(regex));
                System.out.print(" - ");
            }else{
                sc.next();
            }
            // System.out.println(sc.next());
        }
    }

    public static void testHasNextWithArg(){
        String input = "Hello I am WangShangyu Welcome here To be yourself at home";
        // String input2 = "Hello I am WangShangyu && Welcome here To be yourself at home";
        Scanner sc = new Scanner(input);
        // sc.useDelimiter("\\s");
        String regex = "\\w+";
        while(sc.hasNext(regex)){  //针对下一个输入分词进行匹配，但是好像如果这次匹配没有匹配成功，返回值是false，while循环不执行了，当然也就不会再输出什么东西了。
            sc.next(regex);
            // System.out.println(sc.next(regex));
            MatchResult mr = sc.match();
            String str = mr.group();
            System.out.print(str);
            System.out.print(" | ");
        }

        // while(sc.hasNext()){
        //     System.out.println(sc.next());
        // }
    }

    public static void testHasNextWithArg2(){
        String input = "Hello, I am WangShangyu, Welcome here, To be yourself at home.";
        Scanner sc = new Scanner(input);
        // sc.useDelimiter("\\s");
        String regex = "\\w+,";
        int count = 0;
        while(count < 5){
            if(sc.hasNext(regex)){
                System.out.println(sc.next(regex));
                // System.out.println(sc.next());
            }else{
                sc.next();
            }
            count++;
        }
    }
}
