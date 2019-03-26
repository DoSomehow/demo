package org.ms.thinkInJava.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/3/21 22:58
 */
public class TransferTo {

    public static void main(String[] args) throws Exception {
        if(args.length != 2){
            System.out.println("arguments: sourcefile destfile");
            System.exit(1);
        }

        FileChannel in = new FileInputStream(args[0]).getChannel();
        FileChannel out = new FileOutputStream(args[1]).getChannel();
        in.transferTo(0, in.size(), out);
        //Or:
        //out.transferFrom(in, 0, in.size());
    }

}
