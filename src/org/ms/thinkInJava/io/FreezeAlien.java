package org.ms.thinkInJava.io;

import java.io.FileOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/3/25 21:29
 */
public class FreezeAlien {

    public static void main(String[] args) throws Exception {
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream("X.file"));
        Alien quellek = new Alien();
        out.writeObject(quellek);
    }

}
