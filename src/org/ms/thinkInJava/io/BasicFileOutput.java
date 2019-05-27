package org.ms.thinkInJava.io;

import java.io.*;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/3/20 22:52
 */
public class BasicFileOutput {

    static String file = "C:\\Users\\Administrator\\Desktop\\net.out";

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new StringReader(BufferedInputFile.read("C:\\Users\\Administrator\\Desktop\\net.txt")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
        int lineCount = 1;
        String s;
        while ((s = in.readLine()) != null) {
            out.println(lineCount++ + ": " + s);
        }
        out.close();
        //Show the stored file:
        System.out.println(BufferedInputFile.read(file));
    }

}
