package org.ms.thinkInJava.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/3/21 22:53
 */
public class ChannelCopy {

    private static final int BSIZE = 1024;

    public static void main(String[] args) throws Exception {
        if (args.length != 2){
            System.out.println("arguments: sourcefile destfile");
            System.exit(1);
        }

        FileChannel in = new FileInputStream(args[0]).getChannel();
        FileChannel out = new FileOutputStream(args[1]).getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
        while (in.read(buffer) != -1){
            buffer.flip();  //Prepare for writing
            out.write(buffer);
            buffer.clear();  //Prepare for reading
        }
    }

}
