package org.ms.thinkInJava.io;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/3/23 17:44
 */
public class LargeMappedFiles {

    static int length = 0x8FFFFFF;  //128 MB

    public static void main(String[] args) throws Exception {
        MappedByteBuffer out = new RandomAccessFile("test.dat", "rw").getChannel().map(FileChannel.MapMode.READ_WRITE, 0, length);
        for (int i = 0; i < length; i++) {
            out.put((byte)'x');
        }
        System.out.println("Finished writing");
        for (int i = length/2; i < length/2 + 6; i++) {
            System.out.print((char)out.get(i));
        }

    }

}
