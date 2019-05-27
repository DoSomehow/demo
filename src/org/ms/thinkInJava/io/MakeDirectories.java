package org.ms.thinkInJava.io;

import java.io.File;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/3/19 23:13
 */
public class MakeDirectories {

    private static void usage(){
        System.err.println(
            "usage:MakeDirectories path1 ...\n" +
            "Creates each path\n" +
            "Usage:MakeDirectories -d path1 ...\n" +
            "Deletes each path\n" +
            "Usage:MakeDirectories -r path1 path2\n" +
            "Renames from path1 to path2"
        );
        System.exit(1);
    }

    private static void fileData(File f){
        System.out.println(
            "Absolute path: " + f.getAbsolutePath() +
            "\n Can read: " + f.canRead() +
            "\n Can Write: " + f.canWrite() +
            "\n getName: " + f.getName() +
            "\n getParent: " + f.getParent() +
            "\n getPath: " + f.getPath() +
            "\n length: " + f.length() +
            "\n lastModified: " + f.lastModified()
        );

        if(f.isFile()){
            System.out.println("It's a file");
        }else if(f.isDirectory()){
            System.out.println("It' s a directory");
        }
    }

    public static void main(String[] args) {
        // args = new String[1];
        // args[0] = "G:\\for test\\io";

        args = new String[3];
        args[0] = "-r";
        args[1] = "G:\\for test2\\io3";
        args[2] = "G:\\for test3\\io1";

        // args = new String[2];
        // args[0] = "-d";
        // args[1] = "G:\\for test\\io2";

        if(args.length < 1){
            usage();
        }

        if(args[0].equals("-r")){
            if(args.length != 3){
                usage();
            }
            File old = new File(args[1]);
            File rname = new File(args[2]);
            old.renameTo(rname);  //用来把一个文件重命名(或移动)到另一个完全不同的新路径(也就是另一个File对象)下面
            fileData(old);
            fileData(rname);
            return;  //Exit main
        }

        int count = 0;
        boolean del = false;
        if(args[0].equals("-d")){
            count++;
            del = true;
        }
        count--;
        while (++count < args.length){
            File f = new File(args[count]);
            if(f.exists()){
                System.out.println(f + " exists");
                if(del){
                    System.out.println("deleting..." + f);
                    f.delete();  //必须是空文件才可以删除
                }
            }else{  //Doesn't exists
                if(!del){
                    f.mkdirs();
                    System.out.println("created " + f);
                }
            }
            fileData(f);
        }
    }

}
