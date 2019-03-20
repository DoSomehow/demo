package org.ms.thinkInJava.io;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/3/20 22:38
 */
public class FormattedMemoryInput {

    public static void main(String[] args) throws IOException {
        try{
            DataInputStream in = new DataInputStream(new ByteArrayInputStream(BufferedInputFile.read("C:\\Users\\Administrator\\Desktop\\net.txt").getBytes()));
            while (true){
                System.out.print((char)in.readByte());
            }
        }catch (EOFException e){
            System.err.println("End of stream");
        }

    }

}
