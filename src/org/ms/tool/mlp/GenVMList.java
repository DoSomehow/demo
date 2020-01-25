package org.ms.tool.mlp;

import java.io.*;
import java.util.*;

public class GenVMList {

    public static void main(String[] args) {
        execute();
    }

    public static void execute(){
        List<String[]> dataList = new ArrayList<>();
        String path = "C:\\Users\\Ryan\\Desktop\\VW_EQUIP_STATUS_CODE.txt";
        File file = new File(path);
        try {

            InputStream input = new FileInputStream(file);
            InputStreamReader ir = new InputStreamReader(input);
            BufferedReader br = new BufferedReader(ir);

            String lineTxt = "";
            while ((lineTxt = br.readLine()) != null) {
                if (lineTxt == null || "".equals(lineTxt)){
                    continue;
                }
                String[] lineArr = lineTxt.split("\t");
                if(lineArr != null && lineArr.length != 0){
                    dataList.add(lineArr);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(dataList.size() != 0){
            handleThreeCol(dataList);
        }
    }

    public static void handleThreeCol(List<String[]> dataList){

        Map<String, StringBuffer> map = new LinkedHashMap<>();
        for (int i = 0, len = dataList.size(); i < len; i++) {
            String[] arr = dataList.get(i);
            String categ = arr[0];
            String code = arr[1];
            String name = arr[2];

            StringBuffer sb = map.get(categ);
            if(sb == null){
                sb = new StringBuffer();
                map.put(categ, sb);
            }
            sb.append("    ").append("{").append("\r\n");
            sb.append("    ").append("  codeValue: \"").append(code).append("\",\r\n");
            sb.append("    ").append("  codeName: \"").append(name).append("\"\r\n");
            sb.append("    ").append("}");


            if(i != len - 1){
                String[] nextArr = dataList.get(i+1);
                if(categ.equalsIgnoreCase(nextArr[0])){
                    sb.append(",").append("\r\n");
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        for(Map.Entry<String, StringBuffer> entry : map.entrySet()){
            String categ = entry.getKey();
            StringBuffer codeStr = entry.getValue();

            sb.append("{").append("\r\n");
            sb.append("  equipCateg: \"").append(categ).append("\",\r\n");
            sb.append("  codeList: [").append("\r\n");
            sb.append(codeStr).append("\r\n");
            sb.append("  ]").append("\r\n");
            sb.append("},").append("\r\n");
        }

        // sb.substring(0, sb.length()-1);
        System.out.println(sb.toString());

    }

}
