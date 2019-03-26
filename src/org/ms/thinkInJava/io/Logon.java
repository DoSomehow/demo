package org.ms.thinkInJava.io;

import java.io.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/3/25 22:12
 */
public class Logon implements Serializable {

    private Date date = new Date();
    private String username;
    private transient String password;

    public Logon(String name, String pwd) {
        username = name;
        password = pwd;
    }

    @Override
    public String toString() {
        return "Logon info: \n    username: " + username + "\n    date: " + date + "\n    password: " + password;
    }

    public static void main(String[] args) throws Exception{
        Logon a = new Logon("Hulk", "myLittlePony");
        System.out.println("logon a = " + a);
        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("Logon.out"));
        o.writeObject(a);
        o.close();

        TimeUnit.SECONDS.sleep(1);  //Delay

        //Now get them back:
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("Logon.out"));
        System.out.println("Recovering object at " + new Date());
        a = (Logon) in.readObject();
        System.out.println("logong a = " + a);
    }

}
