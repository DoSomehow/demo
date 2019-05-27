package org.ms.thinkInJava.io;

import java.io.*;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/3/25 21:48
 */
public class Blips {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Constructing objects:");
        Blip1 b1 = new Blip1();
        Blip2 b2 = new Blip2();
        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("Blips.out"));
        System.out.println("Saving objects:");
        o.writeObject(b1);
        o.writeObject(b2);
        o.close();

        //Now get them back:
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("Blips.out"));
        System.out.println("Recovering b1:");
        b1 = (Blip1) in.readObject();
        //OOPS! Throws an exception:
        System.out.println("Recovering b2:");
        b2 = (Blip2) in.readObject();  //构造器不是公共的，这样就会在恢复时造成异常
    }

}
