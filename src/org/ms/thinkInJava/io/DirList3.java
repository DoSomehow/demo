package org.ms.thinkInJava.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/3/19 21:54
 */
public class DirList3 {

    public static void main(String[] args) {
        File path = new File(".");
        String[] list;
        if(args.length == 0){
            list = path.list();
        }else{
            list = path.list(new FilenameFilter() {
                private Pattern pattern = Pattern.compile(args[0]);  //既然匿名内部类直接使用args[0]那么传递给main()方法的参数现在就是final的
                @Override
                public boolean accept(File dir, String name) {
                    return pattern.matcher(name).matches();
                }
            });
        }
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String dirItem : list){
            System.out.println(dirItem);
        }
    }

}
