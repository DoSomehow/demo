package org.ms.thinkInJava.util;

import java.io.File;
import java.io.IOException;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/3/19 22:54
 */
public class ProcessFiles {

    public interface Strategy {
        void process(File file);
    }

    private Strategy strategy;
    private String ext;

    public ProcessFiles(Strategy strategy, String ext){
        this.strategy = strategy;
        this.ext = ext;
    }

    public void start(String[] args){
        try{
            if(args.length == 0){
                processDirectoryTree(new File("."));
            }else{
                for (String arg : args){
                    File fileArg = new File(arg);
                    if(fileArg.isDirectory()){
                        processDirectoryTree(fileArg);
                    }else{
                        //Allow user to leave off extension:
                        if(!arg.endsWith("." + ext)){
                            arg += "." + ext;
                        }
                        strategy.process(new File(arg).getCanonicalFile());
                    }
                }
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void processDirectoryTree(File root) throws IOException {
        for (File file : Directory.walk(root.getAbsolutePath(), ".*\\." + ext)){
            strategy.process(file.getCanonicalFile());
        }
    }

    //Demonstration of how to use it:
    public static void main(String[] args) {
        new ProcessFiles(new ProcessFiles.Strategy(){
            @Override
            public void process(File file) {
                System.out.println(file);
            }
        }, "java").start(args);
    }


}
