package org.ms.thinkInJava.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/3/20 22:25
 */
public class BufferedInputFile {

    //Throw exceptions to console:
    public static String read(String filname) throws IOException {
        //Reading input by lines:
        BufferedReader in  = new BufferedReader(new FileReader(filname));
        String s;
        StringBuilder sb = new StringBuilder();
        while ((s= in.readLine()) != null){
            sb.append(s + "\n");
        }
        in.close();
        return sb.toString();
    }

    public static void main(String[] args) throws IOException{
        System.out.println(read("C:\\Users\\Administrator\\Desktop\\net.txt"));
    }

}
