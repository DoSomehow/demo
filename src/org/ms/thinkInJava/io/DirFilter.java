package org.ms.thinkInJava.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/3/19 0:47
 */
public class DirFilter implements FilenameFilter {

    private Pattern pattern;
    public DirFilter(String regex){
        pattern = Pattern.compile(regex);
    }
    public boolean accept(File dir, String name){
        return pattern.matcher(name).matches();
    }

}
