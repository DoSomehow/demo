package org.ms.thinkInJava.io;

import java.io.IOException;
import java.io.StringReader;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/3/20 22:32
 */
public class MemoryInput {

    public static void main(String[] args) throws IOException{
        StringReader in = new StringReader(BufferedInputFile.read("C:\\Users\\Administrator\\Desktop\\net.txt"));
        int c;
        while ((c = in.read()) != -1){
            System.out.print((char)c);
        }
    }

}
