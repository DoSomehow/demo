package org.ms.tool.mlp;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GenDevParams {

    private static Pattern linePattern = Pattern.compile("_(\\w)");

    public static void main(String[] args) {
        execute();
    }

    public static void execute(){
        List<String[]> dataList = new ArrayList<>();
        String path = "C:\\Users\\Ryan\\Desktop\\devParams_it_comp.txt";
        File file = new File(path);
        int position = 0;
        try {
            InputStream input = new FileInputStream(file);
            InputStreamReader ir = new InputStreamReader(input);
            BufferedReader br = new BufferedReader(ir);

            String lineTxt = "";
            int index = 0;
            while ((lineTxt = br.readLine()) != null) {
                if (lineTxt == null || "".equals(lineTxt)){
                    continue;
                }

                //变换是否必填
                if(lineTxt.indexOf("-") != -1){
                    position = index;
                    continue;
                }

                String[] lineArr = lineTxt.split("\t");
                if(lineArr != null && lineArr.length != 0){
                    dataList.add(lineArr);
                }

                index++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(dataList.size() != 0){
            handle(dataList, position);
        }
    }

    public static void handle(List<String[]> dataList, int position){

        StringBuffer sb = new StringBuffer();
        Map<String, StringBuffer> map = new LinkedHashMap<>();
        String require = "true";
        for (int i = 0, len = dataList.size(); i < len; i++) {
            // System.out.print(i);
            String[] arr = dataList.get(i);
            String field = arr[0];
            String name = arr[1];
            field = convertColumnName(field);

            if(i >= position){
                require = "false";
            }

            sb.append("{\r\n");
            sb.append("  paramName: '").append(name).append("',\r\n");
            sb.append("  paramCode: '").append(field).append("',\r\n");
            sb.append("  paramCodeLabel: '").append(field).append("Label").append("',\r\n");
            sb.append("  type: 'selector',\r\n");
            sb.append("  required: ").append(require).append(",\r\n");
            sb.append("  codeList: VMList.VW_METER_SORT_CODE\r\n");
            if(i == len - 1){
                sb.append("}\r\n");
            }else{
                sb.append("},\r\n");
            }
        }

        //
        System.out.println(sb.toString());
    }

    /**
     * 按驼峰命名规则转换数据库表中列名
     * @param columnName
     * @return String
     */
    private static String convertColumnName(String columnName){
        columnName = columnName.toLowerCase();
        Matcher matcher = linePattern.matcher(columnName);
        StringBuffer sb = new StringBuffer();
        while(matcher.find()){
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

}
