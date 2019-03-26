package org.ms.thinkInJava.io;

import java.nio.ByteBuffer;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/3/21 23:36
 */
public class GetData {

    private static final int BSIZE = 1024;

    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);  //在分配一个ByteBuffer之后，可以通过检测它 的值来查看缓冲器的分配方式是否将其内容自动置零
        //Allocation automatically zeroes the ByteBuffer:
        int i = 0;
        while (i++ < bb.limit()){
            if(bb.get() != 0){
                System.out.println("nonzero");
            }
        }
        System.out.println("i = " + i);
        bb.rewind();
        //Store and read a char array:
        bb.asCharBuffer().put("Howdy!");
        char c;
        while ((c = bb.getChar()) != 0){
            System.out.print(c + " ");
        }
        System.out.println();
        bb.rewind();
        //Store and read a short:
        bb.asShortBuffer().put((short)471142);
        System.out.println(bb.getShort());
        bb.rewind();
        //Store and read an int:
        bb.asIntBuffer().put(99471142);
        System.out.println(bb.getInt());
        bb.rewind();
        //Store and read an long:
        bb.asLongBuffer().put(99471142);
        System.out.println(bb.getLong());
        bb.rewind();
        //Store and read an float:
        bb.asFloatBuffer().put(99471142);
        System.out.println(bb.getFloat());
        bb.rewind();
        //Store and read an double:
        bb.asDoubleBuffer().put(99471142);
        System.out.println(bb.getDouble());
        bb.rewind();
    }

}
