package org.ms.thinkInJava.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/3/19 0:58
 */
public class DirList2 {

    public static FilenameFilter filter(final String regex){
        //Creation of anonymous inner class:
        return new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);
            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        };  //End of anonymous inner class
    }

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
