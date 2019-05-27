package org.ms.thinkInJava.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/3/21 22:37
 */
public class GetChannel {

    private static final int BSIZE = 1024;

    public static void main(String[] args) throws Exception {
        //Write a file:
        FileChannel fc = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\data.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some text ".getBytes()));
        fc.close();

        //Add to the end of the file:
        fc = new RandomAccessFile("C:\\Users\\Administrator\\Desktop\\data.txt", "rw").getChannel();
        fc.position(fc.size());  //Move to the end
        fc.write(ByteBuffer.wrap("Some more".getBytes()));
        fc.close();

        //Read the file:
        fc = new FileInputStream("C:\\Users\\Administrator\\Desktop\\data.txt").getChannel();
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        fc.read(buff);
        buff.flip();
        while (buff.hasRemaining()){
            System.out.print((char)buff.get());
        }
    }

}
