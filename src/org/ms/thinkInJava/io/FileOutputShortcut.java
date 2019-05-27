package org.ms.thinkInJava.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/3/20 23:01
 */
public class FileOutputShortcut {

    static String file = "C:\\Users\\Administrator\\Desktop\\net2.out";

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new StringReader(BufferedInputFile.read("C:\\Users\\Administrator\\Desktop\\net.txt")));
        //Here's the shortcut:
        PrintWriter out = new PrintWriter(file);
        int lineCount = 1;
        String s;
        while ((s = in.readLine()) != null){
            out.println(lineCount++ + ": " + s);
        }
        out.close();
        //Show the stored file:
        System.out.println(BufferedInputFile.read(file));
    }

}
