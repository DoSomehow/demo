package org.ms.thinkInJava.io;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/3/20 23:23
 */
public class UsingRandomAccessFIle {

    static String file = "C:\\Users\\Administrator\\Desktop\\rtest.dat";

    static void display() throws IOException {
        RandomAccessFile rf = new RandomAccessFile(file, "r");
        for (int i = 0; i < 7; i++) {
            System.out.println("Value " + i + ": " + rf.readDouble());
        }
        System.out.println(rf.readUTF());
        rf.close();
    }

    public static void main(String[] args) throws IOException {
        RandomAccessFile rf = new RandomAccessFile(file, "rw");
        for (int i = 0; i < 7; i++) {
            rf.writeDouble(i * 1.414);
        }
        rf.writeUTF("The end of the file");
        rf.close();

        display();

        rf = new RandomAccessFile(file, "rw");
        rf.seek(5 * 8);
        rf.writeDouble(47.0001);
        rf.close();

        display();
    }

}
