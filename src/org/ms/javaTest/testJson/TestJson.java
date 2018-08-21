package org.ms.javaTest.testJson;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.Map;

public class TestJson {

    public static void main(String[] args) {
        test();
    }

    public static void test(){
        // String str = "{name:'Tom', method:'uploadFile', files:[{imgName:'aaa.jsp', size:'1111'}, {imgName:'bbb.jsp', size:'2222'}, {imgName:'ccc.jsp', path:'3333'}]}";
        String str = "{APP_NO:'51GM180330534160', CMETHOD:'uploadGmoApp'," +
                     "UP_DTL:'[{\"APP_NO\":\"51GM180330534160\",\"RESN\":\"\"," +
                     "\"STA_FILES\":[{\"FILE_NAME\":\"523_2\",\"FUll_NAME\":\"0.jpg\",\"IMG_SIZE\":\"0B\",\"IMG_TIME\":\"2018-03-30 22:58:24\"},{\"FILE_NAME\":\"478_2\",\"FUll_NAME\":\"0.jpg\",\"IMG_SIZE\":\"0B\",\"IMG_TIME\":\"2018-03-30 22:57:11\"}]," +
                     "}]', OTHER_INFO:''}";

        JSONObject mainObj = JSONObject.fromObject(str);
        Map<String, Object> mainMap = mainObj;
        for(Map.Entry<String, Object> entry : mainMap.entrySet()){
            System.out.println("main[KEY: "+ entry.getKey() +", VALUE: "+ entry.getValue() +"]");
        }

        Object upDtl = mainMap.get("UP_DTL");
        JSONArray upDtlJsonArr = JSONArray.fromObject(upDtl);
        for(int i = 0; i < upDtlJsonArr.size(); i++){
            JSONObject upDtlJsonObj = upDtlJsonArr.getJSONObject(i);
            Map<String, Object> upDtlMap = upDtlJsonObj;

            for(Map.Entry<String, Object> entry : upDtlMap.entrySet()){
                System.out.println("upDtl[KEY: "+ entry.getKey() +", VALUE: "+ entry.getValue() +"]");
            }

            Object staFiles = upDtlMap.get("STA_FILES");
            JSONArray staFilesJsonArr = JSONArray.fromObject(staFiles);
            for(int j = 0; j < staFilesJsonArr.size(); j++){
                JSONObject staFilesJsonObj = staFilesJsonArr.getJSONObject(j);
                Map<String, Object> staFilesMap = staFilesJsonObj;

                for(Map.Entry<String, Object> entry : staFilesMap.entrySet()){
                    System.out.println("staFiles[KEY: "+ entry.getKey() +", VALUE: "+ entry.getValue() +"]");
                }
            }
        }
    }
}
