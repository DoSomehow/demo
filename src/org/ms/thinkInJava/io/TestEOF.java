package org.ms.thinkInJava.io;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/3/20 22:44
 */
public class TestEOF {

    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("C:\\Users\\Administrator\\Desktop\\net.txt")));
        while (in.available() != 0){
            System.out.print((char)in.readByte());
        }
    }

}
