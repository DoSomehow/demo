package org.ms.javaTest.testFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2017/2/7.
 */
public class GetPath {
    public static void main(String[] args) {
        System.out.println("------------------- System.getProperty(\"user.dir\") -----------------");
        System.out.println(System.getProperty("user.dir"));
        System.out.println("------------------- new File(\"\") -----------------");
        File file = new File("");
        try {
            System.out.println("file.getPath(): " + file.getPath());
            System.out.println("file.getCanonicalPath(): " + file.getCanonicalPath());
            System.out.println("file.getAbsolutePath(): " + file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("------------------- new File(\".\") -----------------");
        File file2 = new File(".");
        try {
            System.out.println("file.getPath(): " + file2.getPath());
            System.out.println("file.getCanonicalPath(): " + file2.getCanonicalPath());
            System.out.println("file.getAbsolutePath(): " + file2.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("------------------- new File(\"..\") -----------------");
        File file3 = new File("..");
        try {
            System.out.println("file.getPath(): " + file3.getPath());
            System.out.println("file.getCanonicalPath(): " + file3.getCanonicalPath());
            System.out.println("file.getAbsolutePath(): " + file3.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("------------------- GetPath.class.getClass().getResource(\"/\").getPath() -----------------");
        System.out.println(GetPath.class.getClass().getResource("/").getPath());

        System.out.println("------------------- 获得所有工程的路径 -----------------");
        File ff = new File(file.getAbsolutePath());
        File pf = ff.getParentFile();
        System.out.println("pf.getAbsolutePath(): " + pf.getAbsolutePath());
        File[] farr = pf.listFiles();
        for(File f:farr){
            System.out.println("f.getAbsolutePath(): " + f.getAbsolutePath());
        }

    }
}
