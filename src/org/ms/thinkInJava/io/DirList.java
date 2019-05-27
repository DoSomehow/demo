package org.ms.thinkInJava.io;

import java.io.File;
import java.util.Arrays;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/3/19 0:46
 */
public class DirList {

    public static void main(String[] args) {
        File path = new File(".");
        String[] list;
        if(args.length == 0){
            list = path.list();
        }else{
            list = path.list(new DirFilter(args[0]));
        }
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String dirItem : list){
            System.out.println(dirItem);
        }
    }

}
