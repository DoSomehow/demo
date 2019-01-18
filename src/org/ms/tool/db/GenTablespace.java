package org.ms.tool.db;

import java.io.*;

public class GenTablespace {

    private static String SOURCE_PATH = "D:\\01_文档\\04_mod文档\\数据库";  //
    private static String SOURCE_FILE = "source.txt";  //
    private static String DEST_PATH = "D:\\01_文档\\04_mod文档\\数据库";  //
    private static String DEST_FILE = "tablespaces.sql";  //
    private static String BASE_PATH = "D:\\oracle\\tablespace\\modJs";  //


    public void execute(){

        String[] tablespaceArr = readSourceFile();

        if(tablespaceArr == null){
            return;
        }

        StringBuilder sb = handleData(tablespaceArr);

        genDestFile(sb);
    }

    //
    public void genDestFile(StringBuilder sb){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(DEST_PATH + File.separator + DEST_FILE));
            bw.write(sb.toString());
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //
    public StringBuilder handleData(String[] tablespaceArr){
        StringBuilder sb = new StringBuilder();
        String lineSeparator = System.getProperty("line.separator", "\n");
        for(String tablespace : tablespaceArr){
            sb.append("create tablespace ").append(tablespace).append(lineSeparator);
            sb.append("logging datafile '").append(BASE_PATH).append(File.separator).append(tablespace.toUpperCase()).append(".dbf'").append(lineSeparator);
            sb.append("size 32m").append(lineSeparator);
            sb.append("autoextend on next 32m maxsize unlimited").append(lineSeparator);
            sb.append("extent management local").append(lineSeparator);
            sb.append("segment space management auto;").append(lineSeparator);
            sb.append(lineSeparator);
        }
        return sb;
    }

    //读取源数据文件
    public String[] readSourceFile(){
        StringBuilder sb = new StringBuilder();

        File file = new File(SOURCE_PATH + File.separator + SOURCE_FILE);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String str = null;
            while((str = br.readLine()) != null){
                sb.append(",").append(str.trim());
            }
            br.close();;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(sb.length() > 0){
            String tablespaceStr = sb.substring(1);
            return tablespaceStr.split(",");
        }
        return null;
    }


    public static void main(String[] args) {
        GenTablespace gt = new GenTablespace();
        gt.execute();
    }


}
