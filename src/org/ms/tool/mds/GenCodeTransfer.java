package org.ms.tool.mds;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Ryan on 2017/9/8.
 */
public class GenCodeTransfer {
    public static final String fieldFilePath = "E:\\code\\20170909\\field.txt";  // 20170909  test
    public static final String yxFilePath = "E:\\code\\20170909\\yx.txt";
    public static final String mdsFilePath = "E:\\code\\20170909\\mds.txt";
    public static final String resultFilePath = "E:\\code\\20170909\\result.txt";

    public static final String HANDLE_TYPE_FIELD = "01";  //
    public static final String HANDLE_TYPE_YX = "02";  //
    public static final String HANDLE_TYPE_MDS = "03";  //

    private List<String> fieldTxtList = new ArrayList<>();  //
    private List<String> yxTxtList = new ArrayList<>();  //
    private List<String> mdsTxtList = new ArrayList<>();  //

    private Map<String, Map<String, String>> fieldMap = new HashMap<>();  //
    private Map<String, Map<String, String>> yxMap = new HashMap<>();
    private Map<String, Map<String, String>> mdsMap = new HashMap<>();

    public static void main(String[] args) {

        GenCodeTransfer gct = new GenCodeTransfer();

        //1. 输入字段名称、codeType。
        //2. 输入营销的 codeType、编码及码值。
        //3. 输入mds的 codeType、编码及码值。
        //4. 有的码值只有营销有，有的只有mds有，对于这种情况，以营销为准，因为是营销提订单，他只会选取他有的，然后再转成mds的。不过有可能这个码值在mds这边没有。

        gct.gen();

    }

    private void gen(){
        readAllTxt();
        transferDataStru();
        doHandle();
    }

    private void doHandle(){
        try {
            PrintStream print = new PrintStream(new FileOutputStream(resultFilePath));  //写好输出位置文件；
            System.setOut(print);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for(Map.Entry<String, Map<String, String>> entry : fieldMap.entrySet()){  // { fieldName : { codeType : equipCateg } }
            String fieldName = entry.getKey();
            Map<String, String> map = entry.getValue();

            for(Map.Entry<String, String> ent : map.entrySet()){  //{ codeType : equipCateg }
                String codeType = ent.getKey();
                String equipCategs = ent.getValue();
                compareCodeName(fieldName, codeType, equipCategs);
            }
        }
    }

    private void compareCodeName(String fieldName, String codeType, String equipCategs){
        Map<String, String> yxCodeMap = yxMap.get(codeType);
        Map<String, String> mdsCodeMap = mdsMap.get(codeType);

        if (yxCodeMap == null || mdsCodeMap == null){
            return;
        }

        for(Map.Entry<String, String> entry : yxCodeMap.entrySet()){  //以营销为准
            String yxCodeName = entry.getKey();
            String yxCode = entry.getValue();

            String mdsCode = mdsCodeMap.get(yxCodeName);
            if(mdsCode == null || "".equals(mdsCode)){
                //System.out.println("codeType: " + codeType + " yxCodeName: " + yxCodeName + " yxCode: " + yxCode +"  mds没有对应的码值描述");
                continue;
            }

            if(yxCode.equals(mdsCode)){
                continue;
            }

            String sql = null;
            if(equipCategs == null || "".equals(equipCategs)){
                sql = "insert into i_interface_p_code (INFO_ID, SYN_METHOD, TABLE_NAME, TABLE_COS, COLUMN_NAME, OLD_VALUE, NEW_VALUE, MAIN_NAME, "
                    + "TYPE_VALUE, TYPE_NAME, EQUIP_CATEG) "
                    + "values ('211', '1', 'DIST_APP_DET', '1', '"+fieldName+"', '"+yxCode+"', '"+mdsCode+"', 'OPER_ID', null, null, null);";
                System.out.println(sql);
            }else{
                String[] equipCategArr = equipCategs.split(",");
                for(int i = 0; i < equipCategArr.length; i++){
                    sql = "insert into i_interface_p_code (INFO_ID, SYN_METHOD, TABLE_NAME, TABLE_COS, COLUMN_NAME, OLD_VALUE, NEW_VALUE, MAIN_NAME, "
                        + "TYPE_VALUE, TYPE_NAME, EQUIP_CATEG) "
                        + "values ('211', '1', 'DIST_APP_DET', '1', '"+fieldName+"', '"+yxCode+"', '"+mdsCode+"', 'OPER_ID', null, null, '"+equipCategArr[i]+"');";
                    System.out.println(sql);
                }
            }
        }
    }

    private void transferDataStru(){
        transferFieldDataStru();
        transferYxDataStru();
        transferMdsDataStru();
    }

    private void transferFieldDataStru(){
        for(String line : fieldTxtList){
            String[] arr = line.split("\\s+");
            String fieldName = arr[0];
            String codeTypes = arr[1];

            Map<String, String> map = new HashMap<>();
            fieldMap.put(fieldName, map);

            String[] codeTypeArr = codeTypes.split(",");
            if (arr.length == 3){
                String[] equipCategArr = arr[2].split(";");
                for(int i = 0; i < codeTypeArr.length; i++){
                    map.put(codeTypeArr[i], equipCategArr[i]);
                }
            }else{
                for(int i = 0; i < codeTypeArr.length; i++){
                    map.put(codeTypeArr[i], null);
                }
            }
        }
    }

    private void transferYxDataStru(){
        for(String line : yxTxtList){
            String[] arr = line.split("\\s+");
            String codeType = arr[0];
            String code = arr[1];
            String codeName = arr[2];

            Map<String, String> map = yxMap.get(codeType);
            if(map == null){
                map = new HashMap<>();
                yxMap.put(codeType, map);
            }
            map.put(codeName, code);
        }
    }

    private void transferMdsDataStru(){
        for(String line : mdsTxtList){
            String[] arr = line.split("\\s+");
            String codeType = arr[0];
            String code = arr[1];
            String codeName = arr[2];

            Map<String, String> map = mdsMap.get(codeType);
            if(map == null){
                map = new HashMap<>();
                mdsMap.put(codeType, map);
            }

            // if("currentItRatio".equals(codeType)){
            //     System.out.println(codeName + "-----" + code);
            // }

            map.put(codeName, code);
        }
    }

    private void readAllTxt(){
        readFile(fieldFilePath, HANDLE_TYPE_FIELD);
        readFile(yxFilePath, HANDLE_TYPE_YX);
        readFile(mdsFilePath, HANDLE_TYPE_MDS);
    }

    private void readFile(String filePath, String handleType){
        String encoding = "GBK";
        File file = new File(filePath);
        if(file.isFile() && file.exists()){
            InputStreamReader input = null;
            BufferedReader bufferedReader = null;
            try {
                input = new InputStreamReader(new FileInputStream(file), encoding);
                bufferedReader = new BufferedReader(input);
                String lineTxt = null;
                while((lineTxt = bufferedReader.readLine()) != null){
                    if (lineTxt == null || "".equals(lineTxt)){
                        continue;
                    }

                    if(HANDLE_TYPE_FIELD.equals(handleType)){
                        fieldTxtList.add(lineTxt);
                    }else if (HANDLE_TYPE_YX.equals(handleType)){
                        yxTxtList.add(lineTxt);
                    }else{
                        mdsTxtList.add(lineTxt);
                    }
                }

            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    bufferedReader.close();
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }else{
            //System.out.println("找不到指定的文件");
        }
    }
}
