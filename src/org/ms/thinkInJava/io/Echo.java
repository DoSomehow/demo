package org.ms.thinkInJava.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/3/21 21:25
 */
public class Echo {

    public static void main(String[] args) throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = stdin.readLine()) != null && s.length() != 0){
            System.out.println(s);
        }
        //An empty line or Ctrl-Z terminates the program
        //就是while条件中的 s.length() != 0 才使得输入空行可以结束程序
    }

}
