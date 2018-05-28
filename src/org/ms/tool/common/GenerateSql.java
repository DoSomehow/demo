package org.ms.tool.common;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GenerateSql {

    private static Pattern linePattern = Pattern.compile("_(\\w)");

    public static void main(String[] args) {
        GenerateSql gs = new GenerateSql();
        String filePath = "C:\\Users\\Ryan\\Desktop";
        String fileName = "test.txt";
        String tableName = "gm_schedule_info";
        gs.generateUpdateSql(filePath, fileName, tableName);
    }

    private void generateUpdateSql(String filePath, String fileName, String tableName){

        StringBuffer sb = new StringBuffer();
        sb.append("update ").append(tableName).append(" set ");

        File file = new File(filePath + File.separator + fileName);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String str = null;
            while((str = br.readLine()) != null){
                sb.append(getUpdateField(str.trim()));
            }
            System.out.println(sb.toString());
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getUpdateField(String field){
        String key = field.toUpperCase();
        String value = toCamelStyle(field);
        return key + " = #" + value + "#, ";
    }

    private String toCamelStyle(String field){
        field = field.toLowerCase();
        Matcher matcher = linePattern.matcher(field);
        StringBuffer sb = new StringBuffer();
        while(matcher.find()){
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }


}
