package org.ms.thinkInJava.io;

import java.io.*;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/3/20 23:12
 */
public class StoringAndRecoveringData {

    public static void main(String[] args) throws IOException {
        DataOutputStream out = new DataOutputStream(new FileOutputStream("C:\\Users\\Administrator\\Desktop\\Data.txt"));
        out.writeDouble(3.14159);
        out.writeUTF("That was pi");
        out.writeDouble(1.41413);
        out.writeUTF("Square root of 2");
        out.close();

        DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("C:\\Users\\Administrator\\Desktop\\Data.txt")));
        System.out.println(in.readDouble());
        //Only readUTF() will recover the Java-UTF String properly:
        System.out.println(in.readUTF());
        System.out.println(in.readDouble());
        System.out.println(in.readUTF());
    }

}
