package org.ms.thinkInJava.io.xfiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/3/25 21:31
 */
public class ThawAlien {

    public static void main(String[] args) throws Exception {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File("..", "X.file")));
        Object mystery = in.readObject();
        System.out.println(mystery.getClass());
    }

}
