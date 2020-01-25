package org.ms.tool.gmo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 统计代码行数
 */
public class CodeStatic {

    public static void main(String[] args) {
        // String backCodePath = "D:\\workspace\\eclipse\\eom\\EomMain\\src-ext\\modules\\gmo";
        // String frontCodePath = "D:\\workspace\\eclipse\\eom\\EomMain\\WebContent\\modules\\gmo";
        String mlpCodePath = "D:\\workspace\\vsCode\\mlp_app\\src";

        // staticCode(backCodePath);  //java
        // staticCode(frontCodePath);  //js jsp
        staticCode(mlpCodePath);  //html、js
    }

    private static void staticCode(String path){
        List<File> list = total(path);
        System.out.println("文件数量："+list.size());

        //统计代码行数
        Integer row=0;

        for (File file : list) {
            // System.out.println(file.getName());
            FileReader fr= null;//创建文件输入流
            try {
                fr = new FileReader(file);
                BufferedReader in = new BufferedReader(fr);//包装文件输入流，可整行读取
                String line = "";
                while((line = in.readLine()) != null) {
                    row++;
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("代码总行数："+row);
    }

    private static List<File> total(String path){
        List<File> files = new ArrayList<File>();
        File file = new File(path);
        File[] files2 = file.listFiles();
        for (File file3 : files2) {
            if(file3.isFile()){
                files.add(file3);
            }else {
                if (file3.getName().equals("assets")) {
                    System.out.println("skip assets");
                    continue;
                }
                files.addAll(files.size(), total(file3.getPath()));
            }
        }
        return files;
    }

}
