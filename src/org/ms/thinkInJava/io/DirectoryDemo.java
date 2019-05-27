package org.ms.thinkInJava.io;

import org.ms.thinkInJava.util.Directory;
import org.ms.thinkInJava.util.PPrint;

import java.io.File;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/3/19 22:38
 */
public class DirectoryDemo {

    public static void main(String[] args) {
        //All directories:
        PPrint.pprint(Directory.walk(".").dirs);
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

        //All files beginning with 'T'
        for (File file : Directory.local(".", "T.*")){  //这儿用的local方法，里边可没有用到递归
            System.out.println(file);
        }
        System.out.println("---------------------------------");

        //All Java files beginning with 'T':
        for (File file : Directory.walk(".", "T.*\\.java")){
            System.out.println(file);
        }
        System.out.println("=================================");

        //Class files containing "Z" or "z":
        for (File file : Directory.walk(".", ".*[Zz].*\\.class")){
            System.out.println(file);
        }
    }

}
