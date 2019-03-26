package org.ms.thinkInJava.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/3/21 23:05
 */
public class BufferToText {

    private static final int BSIZE = 1024;

    public static void main(String[] args) throws Exception {
        FileChannel fc = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\data.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some text".getBytes()));
        fc.close();

        fc = new FileInputStream("C:\\Users\\Administrator\\Desktop\\data.txt").getChannel();
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        fc.read(buff);
        buff.flip();
        //Doesn't work:
        System.out.println(buff.asCharBuffer());

        //Decode using this system's default Charset:
        buff.rewind();
        String encoding = System.getProperty("file.encoding");
        System.out.println("Decoded using " + encoding + ": " + Charset.forName(encoding).decode(buff));

        //Or, we could encode with something that will print:
        fc = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\data.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some text".getBytes("UTF-16BE")));
        fc.close();

        //Now try reading again:
        fc = new FileInputStream("C:\\Users\\Administrator\\Desktop\\data.txt").getChannel();
        buff.clear();
        fc.read(buff);
        buff.flip();
        System.out.println(buff.asCharBuffer());

        //Use a CharBuffer to write through:
        fc = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\data.txt").getChannel();
        buff = ByteBuffer.allocate(24);  //More than needed
        buff.asCharBuffer().put("Some text");  //"Some text"只有9个字符，剩余的内容为零的字节仍出现在由它的toString()所产生的CharBuffer的表示中
        fc.write(buff);
        fc.close();

        //Read and display:
        fc = new FileInputStream("C:\\Users\\Administrator\\Desktop\\data.txt").getChannel();
        buff.clear();
        fc.read(buff);
        buff.flip();
        System.out.println(buff.asCharBuffer());
    }

}
