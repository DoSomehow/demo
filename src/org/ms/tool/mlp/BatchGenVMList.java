package org.ms.tool.mlp;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BatchGenVMList {

    public static void main(String[] args) {
        // String sourcePath = "C:\\Users\\Ryan\\Desktop\\batchVMList.txt";
        // String destPath = "C:\\Users\\Ryan\\Desktop\\result.txt";
        String sourcePath = "C:\\Users\\Ryan\\Desktop\\modelCodeVMList.txt";
        String destPath = "C:\\Users\\Ryan\\Desktop\\modelCodeResult.txt";
        execute(sourcePath, destPath);
    }

    public static void execute(String filePath, String destPath){
        List<String> dataList = new ArrayList<>();
        File file = new File(filePath);
        try {

            InputStream input = new FileInputStream(file);
            InputStreamReader ir = new InputStreamReader(input);
            BufferedReader br = new BufferedReader(ir);

            String lineTxt = "";
            while ((lineTxt = br.readLine()) != null) {
                if (lineTxt == null || "".equals(lineTxt)){
                    continue;
                }
                dataList.add(lineTxt);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(dataList.size() != 0){
            StringBuffer sb = handleThreeCol(dataList);
            outputFile(destPath, sb);
        }
    }

    public static StringBuffer handleThreeCol(List<String> dataList){

        StringBuffer sb = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
        boolean flag = true;
        for (int i = 0, len = dataList.size(); i < len; i++) {
            String lineText = dataList.get(i);
            String[] lineArr = lineText.split("\t");
            if(lineArr == null || lineArr.length == 0){
                continue;
            }

            String code = lineArr[0];
            String name = lineArr[1];

            if (code.startsWith("$")) {
                //新生成一个js对象
                //$测试 VW_TEST
                sb.append("\r\n];\r\n");
                sb.append("\r\n");
                sb.append("\r\n");
                sb.append("/**\r\n");
                sb.append(" * ").append(code.substring(1)).append(" ").append(name).append("\r\n");
                sb.append(" */\r\n");
                sb.append("var ").append(name).append(" = [\r\n");
                flag = false;

                //生成export部分
                sb2.append("  ").append(name).append(",\r\n");
            } else {
                if(flag){
                    sb.append(",\r\n");
                }
                sb.append("  {\r\n");
                sb.append("    codeName: \"").append(name).append("\",\r\n");
                sb.append("    codeValue: \"").append(code).append("\"\r\n");
                sb.append("  }");
                flag = true;
            }
        }
        sb.append("\r\n];\r\n");
        sb.append(sb2);

        // sb.substring(0, sb.length()-1);
        // System.out.println(sb.toString());
        return sb;
    }

    public static void outputFile(String destPath, StringBuffer sb) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(destPath));
            bw.write(sb.toString());
            bw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
