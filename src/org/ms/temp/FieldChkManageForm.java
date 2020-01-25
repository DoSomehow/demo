package org.ms.temp;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FieldChkManageForm {

    public static void main(String[] args) {
        String params = "{'chkTaskList':[{'chkTaskNo':'071575682566707','taskType':'03','taskNum':'1','subNo':'20191205100001','subsName':'小店区厂站','madeDate':'当前时间','confRslt':'01','confNo':'','confDate':'','teamNo':'12345','checkerNo':'LL01','serveyRslt':'03','safetyRslt':'03','preMeetRslt':'03','chkRslt':'03','afterMeetRslt':'03','taskDets':[{'taskDetId':'1','barCode':'1430002000031705000574','caliNo':'','chkDate':'2019-12-07 11:59:02','concCode':'03','chkBasicRsltList':[{'chkRsltId':'1','actualRatio':'10','polarity':'0','compoundErr':'0.007','temp':'20.9','humidity':'14.9','concCode':'03','chkBasicDetList':[{'pct':'1','loadType':'01','ratioErr':'0.003','angleErr':'0.24'},{'pct':'1','loadType':'02','ratioErr':'0.003','angleErr':'0.25'},{'pct':'2','loadType':'01','ratioErr':'0.003','angleErr':'0.22'},{'pct':'2','loadType':'02','ratioErr':'0.003','angleErr':'0.22'},{'pct':'4','loadType':'01','ratioErr':'0.003','angleErr':'0.11'},{'pct':'4','loadType':'02','ratioErr':'0.003','angleErr':'0.14'}]}],'chkZYRsltList':[{'chkType':'04','pct':'05','resi':'','reac':'','conduct':'-19.156','susc':'14.575','actualLoad':'79.28'},{'chkType':'04','pct':'02','resi':'','reac':'','conduct':'-18.931','susc':'14.446','actualLoad':'79.28'}],'chkLoadRsltList':[{'chkType':'07','temp':'-','humidity':'-','concCode':'04','phaseCode':'0.81','resi':'','reac':'','rvCode':'14.27','rcCode':'','actualLoad':'5.11'}],'chkSndPreRsltList':[{}],'chkVaExRsltList':[{}],'chkIndirectRsltList':[{'chkRsltId':'1','chkType':'10','polarity':'-','compoundErr':'-','fstRcCode':'','actualVoltRatio':'-','dc':'','shortTurns':'','secuCoef':'','temp':'0','humidity':'0','concCode':'03','chkIndirectDetList':[{'pct':'01','loadType':'01','ratioErr':'-0.045','angleErr':'1.17'},{'pct':'01','loadType':'02','ratioErr':'-0.035','angleErr':'1.13'},{'pct':'02','loadType':'01','ratioErr':'-0.045','angleErr':'1.19'},{'pct':'02','loadType':'02','ratioErr':'-0.035','angleErr':'1.14'},{'pct':'04','loadType':'01','ratioErr':'-0.043','angleErr':'1.11'},{'pct':'04','loadType':'02','ratioErr':'-0.033','angleErr':'1.05'}]}]}],'surveyRsltList':[{'surveyType':'01','itemCode':'01','itemRslt':'01','surveyer':'','surveyDate':'Sat Dec 07 2019 09:36:21 GMT%2B0800 (CST)'},{'surveyType':'01','itemCode':'02','itemRslt':'01','surveyer':'','surveyDate':'Sat Dec 07 2019 09:36:21 GMT%2B0800 (CST)'},{'surveyType':'01','itemCode':'03','itemRslt':'01','surveyer':'','surveyDate':'Sat Dec 07 2019 09:36:21 GMT%2B0800 (CST)'},{'surveyType':'01','itemCode':'04','itemRslt':'01','surveyer':'','surveyDate':'Sat Dec 07 2019 09:36:21 GMT%2B0800 (CST)'},{'surveyType':'01','itemCode':'05','itemRslt':'01','surveyer':'','surveyDate':'Sat Dec 07 2019 09:36:21 GMT%2B0800 (CST)'},{'surveyType':'01','itemCode':'06','itemRslt':'01','surveyer':'','surveyDate':'Sat Dec 07 2019 09:36:21 GMT%2B0800 (CST)'},{'surveyType':'02','itemCode':'07','itemRslt':'01','surveyer':'','surveyDate':'Sat Dec 07 2019 09:36:21 GMT%2B0800 (CST)'},{'surveyType':'02','itemCode':'08','itemRslt':'01','surveyer':'','surveyDate':'Sat Dec 07 2019 09:36:21 GMT%2B0800 (CST)'},{'surveyType':'02','itemCode':'09','itemRslt':'01','surveyer':'','surveyDate':'Sat Dec 07 2019 09:36:21 GMT%2B0800 (CST)'},{'surveyType':'02','itemCode':'10','itemRslt':'01','surveyer':'','surveyDate':'Sat Dec 07 2019 09:36:21 GMT%2B0800 (CST)'},{'surveyType':'02','itemCode':'11','itemRslt':'01','surveyer':'','surveyDate':'Sat Dec 07 2019 09:36:21 GMT%2B0800 (CST)'},{'surveyType':'02','itemCode':'12','itemRslt':'01','surveyer':'','surveyDate':'Sat Dec 07 2019 09:36:21 GMT%2B0800 (CST)'},{'surveyType':'02','itemCode':'13','itemRslt':'01','surveyer':'','surveyDate':'Sat Dec 07 2019 09:36:21 GMT%2B0800 (CST)'}],'preMeetRsltList':[{'meetId':'1','hostName':'奖学金继续','deuNum':'3','realNum':'3','meetDate':'Sat Dec 07 2019 09:36:36 GMT%2B0800 (CST)','meetAddr':'啾啾啾','recName':'小小','recNo':'2558','meetInspList':[{'itemCode':'01','itemRslt':'01','insper':'2558','inspDate':'Sat Dec 07 2019 09:36:36 GMT%2B0800 (CST)'},{'itemCode':'02','itemRslt':'01','insper':'2558','inspDate':'Sat Dec 07 2019 09:36:36 GMT%2B0800 (CST)'},{'itemCode':'03','itemRslt':'01','insper':'2558','inspDate':'Sat Dec 07 2019 09:36:36 GMT%2B0800 (CST)'},{'itemCode':'04','itemRslt':'01','insper':'2558','inspDate':'Sat Dec 07 2019 09:36:36 GMT%2B0800 (CST)'},{'itemCode':'05','itemRslt':'01','insper':'2558','inspDate':'Sat Dec 07 2019 09:36:36 GMT%2B0800 (CST)'},{'itemCode':'06','itemRslt':'01','insper':'2558','inspDate':'Sat Dec 07 2019 09:36:36 GMT%2B0800 (CST)'},{'itemCode':'07','itemRslt':'01','insper':'2558','inspDate':'Sat Dec 07 2019 09:36:36 GMT%2B0800 (CST)'},{'itemCode':'08','itemRslt':'01','insper':'2558','inspDate':'Sat Dec 07 2019 09:36:36 GMT%2B0800 (CST)'},{'itemCode':'09','itemRslt':'01','insper':'2558','inspDate':'Sat Dec 07 2019 09:36:36 GMT%2B0800 (CST)'}],'signPics':'','picInfoDets':''}],'safetyRsltList':[{'itemCode':'01','itemRslt':'01','surveyer':'','surveyDate':'Sat Dec 07 2019 09:36:38 GMT%2B0800 (CST)'},{'itemCode':'02','itemRslt':'01','surveyer':'','surveyDate':'Sat Dec 07 2019 09:36:38 GMT%2B0800 (CST)'},{'itemCode':'03','itemRslt':'01','surveyer':'','surveyDate':'Sat Dec 07 2019 09:36:38 GMT%2B0800 (CST)'},{'itemCode':'04','itemRslt':'01','surveyer':'','surveyDate':'Sat Dec 07 2019 09:36:38 GMT%2B0800 (CST)'},{'itemCode':'05','itemRslt':'01','surveyer':'','surveyDate':'Sat Dec 07 2019 09:36:38 GMT%2B0800 (CST)'},{'itemCode':'06','itemRslt':'01','surveyer':'','surveyDate':'Sat Dec 07 2019 09:36:38 GMT%2B0800 (CST)'},{'itemCode':'07','itemRslt':'01','surveyer':'','surveyDate':'Sat Dec 07 2019 09:36:38 GMT%2B0800 (CST)'}],'afterMeetRsltList':[{'meetId':'4','hostName':'好尴尬','deuNum':'3','realNum':'3','meetDate':'Sat Dec 07 2019 11:59:45 GMT%2B0800 (CST)','meetAddr':'哈哈哈','recName':'LIUJIAYI','recNo':'LIUJIAYI','meetInspList':[{'itemCode':'01','itemRslt':'01','insper':'LIUJIAYI','inspDate':'Sat Dec 07 2019 11:59:45 GMT%2B0800 (CST)'},{'itemCode':'02','itemRslt':'01','insper':'LIUJIAYI','inspDate':'Sat Dec 07 2019 11:59:45 GMT%2B0800 (CST)'},{'itemCode':'03','itemRslt':'01','insper':'LIUJIAYI','inspDate':'Sat Dec 07 2019 11:59:45 GMT%2B0800 (CST)'},{'itemCode':'04','itemRslt':'01','insper':'LIUJIAYI','inspDate':'Sat Dec 07 2019 11:59:45 GMT%2B0800 (CST)'},{'itemCode':'05','itemRslt':'01','insper':'LIUJIAYI','inspDate':'Sat Dec 07 2019 11:59:45 GMT%2B0800 (CST)'},{'itemCode':'06','itemRslt':'01','insper':'LIUJIAYI','inspDate':'Sat Dec 07 2019 11:59:45 GMT%2B0800 (CST)'},{'itemCode':'07','itemRslt':'01','insper':'LIUJIAYI','inspDate':'Sat Dec 07 2019 11:59:45 GMT%2B0800 (CST)'}]}]}],'userId':'8000002297'}";

        FieldChkManageForm fcmf = new FieldChkManageForm();
        fcmf.uploadCheckRslt(params);
    }

    //上传检验结果
    public void uploadCheckRslt(String params){

        try{
            // 获取json结构的params
            if (params != null && !"".equals(params)) {
                JSONObject queryJson = JSONObject.fromObject(params);
                List<Map<String,Object>> queryList = null;
                if (queryJson.get("chkTaskList") != null
                        && !"null".equals(queryJson.get("chkTaskList").toString())
                        && !"".equals(queryJson.get("chkTaskList").toString())) {
                    String chkTaskList = queryJson.get("chkTaskList").toString();
                    JSONArray queryArray = JSONArray.fromObject(chkTaskList);
                    queryList = new ArrayList<Map<String,Object>>(queryArray.size());
                    for(int x = 0;x<queryArray.size();x++){
                        JSONObject json = JSONObject.fromObject(queryArray.get(x));
                        Map<String,Object> parameterMap = new HashMap<String,Object>();
                        parameterMap.put("chkTaskNo", json.get("chkTaskNo").toString().trim());//现场任务编号
                        parameterMap.put("taskType", json.get("taskType").toString().trim());//任务类型
                        parameterMap.put("taskNum", json.get("taskNum"));//任务数量
                        parameterMap.put("subNo", json.get("subNo").toString().trim());//厂站编号
                        parameterMap.put("subsName", json.get("subsName").toString().trim());//厂站名称
                        parameterMap.put("madeDate", json.get("madeDate"));//制定时间
                        parameterMap.put("confRslt", json.get("confRslt").toString().trim());//确认结果
                        parameterMap.put("confNo", json.get("confNo").toString().trim());//确认人
                        parameterMap.put("confDate", json.get("confDate"));//确认时间
                        parameterMap.put("teamNo", json.get("teamNo").toString().trim());//检验班组
                        parameterMap.put("checkerNo", json.get("checkerNo").toString().trim());//检验人
                        parameterMap.put("serveyRslt", json.get("serveyRslt").toString().trim());//现场勘查结果
                        parameterMap.put("safetyRslt", json.get("safetyRslt").toString().trim());//安全检查结果
                        parameterMap.put("preMeetRslt", json.get("preMeetRslt").toString().trim());//班前会结果
                        parameterMap.put("chkRslt", json.get("chkRslt").toString().trim());//现场检验结果
                        parameterMap.put("afterMeetRslt", json.get("afterMeetRslt").toString().trim());//班后会情况
                        //任务明细数据集
                        String taskDets = json.get("taskDets").toString();
                        JSONArray taskDetsArray = JSONArray.fromObject(taskDets);
                        List<Map<String,Object>> taskDetsList = new ArrayList<Map<String,Object>>();
                        for(int i=0;i<taskDetsArray.size();i++){
                            Map<String,Object> object = (Map<String, Object>) taskDetsArray.get(i);

                            Map<String,Object> taskDetsMap = new HashMap<String,Object>();
                            taskDetsMap.put("barCode", object.get("barCode").toString().trim());
                            taskDetsMap.put("caliNo", object.get("caliNo").toString().trim());
                            taskDetsMap.put("chkDate",  object.get("chkDate"));
                            taskDetsMap.put("concCode", object.get("concCode").toString().trim());
                            //误差测试数据集	chkBasicRsltList
                            if(object.get("chkBasicRsltList") != null
                                    && !"".equals(object.get("chkBasicRsltList"))
                                    && !"null".equals(object.get("chkBasicRsltList"))){
                                String chkRsltDetsJson = object.get("chkBasicRsltList").toString();
                                try{
                                    taskDetsMap.put("chkBasicRsltList", chkBasicRsltList(chkRsltDetsJson));
                                }catch(Exception e){
                                    // throw new BaseRuntimeException("解析误差测试数据集失败");
                                }
                            }else{
                                // throw new BaseRuntimeException("误差测试数据集不能为空");
                            }

                            //Z测试Y测试结果数据集	chkZYRsltList
                            if(object.get("chkZYRsltList") != null
                                    && !"".equals(object.get("chkZYRsltList"))
                                    && !"null".equals(object.get("chkZYRsltList"))){
                                String chkZYRsltListJson = object.get("chkZYRsltList").toString();
                                try{
                                    taskDetsMap.put("chkZYRsltList", chkZYRsltListList(chkZYRsltListJson));
                                }catch(Exception e){
                                    // throw new BaseRuntimeException("解析Z测试Y测试结果数据集失败");
                                }
                            }

                            //实际负荷测试结果数据集	chkLoadRsltList
                            if(object.get("chkLoadRsltList") != null
                                    && !"".equals(object.get("chkLoadRsltList"))
                                    && !"null".equals(object.get("chkLoadRsltList"))){
                                String chkLoadRsltListJson = object.get("chkLoadRsltList").toString();
                                try{
                                    taskDetsMap.put("chkLoadRsltList", chkLoadRsltList(chkLoadRsltListJson));
                                }catch(Exception e){
                                    // logger.error(" 实际负荷测试结果数据集， error",e);
                                    // throw new BaseRuntimeException("解析实际负荷测试结果数据集失败");
                                }
                            }

                            //PT二次压降测试结果数据集	chkSndPreRsltList
                            if(object.get("chkSndPreRsltList") != null
                                    && !"".equals(object.get("chkSndPreRsltList"))
                                    && !"null".equals(object.get("chkSndPreRsltList"))){
                                String chkSndPreRsltListJson = object.get("chkSndPreRsltList").toString();
                                try{
                                    taskDetsMap.put("chkLoadRsltList", chkSndPreRsltList(chkSndPreRsltListJson));
                                }catch(Exception e){
                                    // logger.error(" PT二次压降测试结果数据集， error",e);
                                    // throw new BaseRuntimeException("解析PT二次压降测试结果数据集失败");
                                }
                            }

                            //伏安特性励磁特性测试结果数据集	chkVaExRsltList
                            if(object.get("chkVaExRsltList") != null
                                    && !"".equals(object.get("chkVaExRsltList"))
                                    && !"null".equals(object.get("chkVaExRsltList"))){
                                String chkVaExRsltListJson = object.get("chkVaExRsltList").toString();
                                try{
                                    taskDetsMap.put("chkVaExRsltList", chkVaExRsltList(chkVaExRsltListJson));
                                }catch(Exception e){
                                    // logger.error(" 伏安特性励磁特性测试结果数据集	， error",e);
                                    // throw new BaseRuntimeException("解析伏安特性励磁特性测试结果数据集	失败");
                                }
                            }

                            //间接测试结果数据集	chkIndirectRsltList
                            if(object.get("chkIndirectRsltList") != null
                                    && !"".equals(object.get("chkIndirectRsltList"))
                                    && !"null".equals(object.get("chkIndirectRsltList"))){
                                String chkIndirectRsltListJson = object.get("chkIndirectRsltList").toString();
                                try{
                                    taskDetsMap.put("chkIndirectRsltList", chkIndirectRsltList(chkIndirectRsltListJson));
                                }catch(Exception e){
                                    // logger.error(" 间接测试结果数据集， error",e);
                                    // throw new BaseRuntimeException("解析间接测试结果数据集失败");
                                }
                            }


                            taskDetsList.add(taskDetsMap);
                        }
                        parameterMap.put("taskDets", taskDetsList);

                        //现场勘查数据集
                        if(json.get("surveyRsltList") != null
                                && !"".equals(json.get("surveyRsltList"))
                                && !"null".equals(json.get("surveyRsltList"))){
                            String surveyRsltJson = json.get("surveyRsltList").toString();
                            JSONArray surveyRsltArray = JSONArray.fromObject(surveyRsltJson);
                            List<Map<String,Object>> surveyRsltList = new ArrayList<Map<String,Object>>();
                            for(int i=0;i<surveyRsltArray.size();i++){
                                Map<String,Object> object = (Map<String, Object>) surveyRsltArray.get(i);
                                Map<String,Object> surveyRsltMap = new HashMap<String,Object>();
                                surveyRsltMap.put("surveyType", object.get("surveyType").toString().trim());
                                surveyRsltMap.put("itemCode", object.get("itemCode").toString().trim());
                                surveyRsltMap.put("itemRslt", object.get("itemRslt").toString().trim());
                                surveyRsltMap.put("surveyer", object.get("surveyer").toString().trim());
                                surveyRsltMap.put("surveyDate", object.get("surveyDate"));
                                surveyRsltList.add(surveyRsltMap);
                            }
                            parameterMap.put("surveyRsltList", surveyRsltList);
                        }
                        //班前会数据集
                        if(json.get("preMeetRsltList") != null
                                && !"".equals(json.get("preMeetRsltList"))
                                && !"null".equals(json.get("preMeetRsltList"))){
                            String preMeetRsltJson = json.get("preMeetRsltList").toString();
                            JSONArray preMeetRsltArray = JSONArray.fromObject(preMeetRsltJson);
                            List<Map<String,Object>> preMeetRsltList = new ArrayList<Map<String,Object>>();
                            for(int i=0;i<preMeetRsltArray.size();i++){
                                Map<String,Object> object = (Map<String, Object>) preMeetRsltArray.get(i);
                                Map<String,Object> preMeetRsltMap = new HashMap<String,Object>();
                                preMeetRsltMap.put("hostName", object.get("hostName").toString().trim());
                                preMeetRsltMap.put("deuNum", object.get("deuNum"));
                                preMeetRsltMap.put("realNum", object.get("realNum"));
                                preMeetRsltMap.put("meetDate", object.get("meetDate"));
                                preMeetRsltMap.put("meetAddr", object.get("meetAddr").toString().trim());
                                preMeetRsltMap.put("recName", object.get("recName").toString().trim());
                                //班前会-->签字数据集
                                if(object.get("signPics") != null
                                        && !"".equals(object.get("signPics"))
                                        && !"null".equals(object.get("signPics"))){
                                    String signPicsJson = object.get("signPics").toString();
                                    JSONArray signPicsArray = JSONArray.fromObject(signPicsJson);
                                    List<Map<String,Object>> signPicsList = new ArrayList<Map<String,Object>>(signPicsArray.size());
                                    for(int j=0;j<signPicsArray.size();j++){
                                        Map<String,Object> signPicsMap = (Map<String, Object>) signPicsArray.get(j);
                                        Map<String,Object> signPicsQueryMap = new HashMap<String,Object>(signPicsMap.size());
                                        signPicsQueryMap.put("picName", signPicsMap.get("picName").toString().trim());//图片名称
                                        signPicsQueryMap.put("picSize", signPicsMap.get("picSize").toString().trim());//图片大小
                                        signPicsQueryMap.put("picContent", signPicsMap.get("picContent").toString().trim());//图片内容
                                        signPicsList.add(signPicsQueryMap);
                                    }
                                    preMeetRsltMap.put("signPics", signPicsList);//签字数据集
                                }

                                //班前会-->图片数据集
                                if(object.get("picInfoDets") != null
                                        && !"".equals(object.get("picInfoDets"))
                                        && !"null".equals(object.get("picInfoDets"))){
                                    String chkRsltDetsJson = object.get("picInfoDets").toString();
                                    JSONArray chkRsltDetsArray = JSONArray.fromObject(chkRsltDetsJson);
                                    List<Map<String,Object>> chkRsltDetsList = new ArrayList<Map<String,Object>>(chkRsltDetsArray.size());
                                    for(int j=0;j<chkRsltDetsArray.size();j++){
                                        Map<String,Object> chkRsltDetsMap = (Map<String, Object>) chkRsltDetsArray.get(j);
                                        Map<String,Object> chkRsltDetsQueryMap = new HashMap<String,Object>(chkRsltDetsMap.size());
                                        chkRsltDetsQueryMap.put("picName", chkRsltDetsMap.get("picName").toString().trim());//图片名称
                                        chkRsltDetsQueryMap.put("picSize", chkRsltDetsMap.get("picSize").toString().trim());//图片大小
                                        chkRsltDetsQueryMap.put("picContent", chkRsltDetsMap.get("picContent").toString().trim());//图片内容
                                        chkRsltDetsList.add(chkRsltDetsQueryMap);
                                    }
                                    preMeetRsltMap.put("picInfoDets", chkRsltDetsList);//图片数据集
                                }

                                //班前会-->班会内容数据集
                                if(object.get("meetInspList") != null
                                        && !"".equals(object.get("meetInspList"))
                                        && !"null".equals(object.get("meetInspList"))){
                                    try{
                                        String meetInspJson = object.get("meetInspList").toString();
                                        JSONArray meetInspArray = JSONArray.fromObject(meetInspJson);
                                        List<Map<String,Object>> meetInspList = new ArrayList<Map<String,Object>>(meetInspArray.size());
                                        for(int j=0;j<meetInspArray.size();j++){
                                            Map<String,Object> meetInspMap = (Map<String, Object>) meetInspArray.get(j);
                                            Map<String,Object> meetInspQueryMap = new HashMap<String,Object>(meetInspMap.size());
                                            meetInspQueryMap.put("itemCode", meetInspMap.get("itemCode").toString().trim());
                                            meetInspQueryMap.put("itemRslt", meetInspMap.get("itemRslt").toString().trim());
                                            meetInspQueryMap.put("insper", meetInspMap.get("insper").toString().trim());
                                            meetInspQueryMap.put("inspDate", meetInspMap.get("inspDate"));
                                            meetInspList.add(meetInspQueryMap);
                                        }
                                        preMeetRsltMap.put("meetInspList", meetInspList);//班会内容数据集
                                    }catch(Exception e){
                                        // logger.error("解析 班前会-->班会内容数据集	异常，error",e);
                                        // throw new BaseRuntimeException("解析班会内容失败");
                                    }
                                }
                                preMeetRsltList.add(preMeetRsltMap);
                            }
                            parameterMap.put("preMeetRsltList", preMeetRsltList);
                        }

                        //安全检查数据集
                        if(json.get("safetyRsltList") != null
                                && !"".equals(json.get("safetyRsltList").toString())
                                && !"null".equals(json.get("safetyRsltList").toString())){
                            String safetyRsltJson = json.get("safetyRsltList").toString();
                            JSONArray safetyRsltArray = JSONArray.fromObject(safetyRsltJson);
                            List<Map<String,Object>> safetyRsltList = new ArrayList<Map<String,Object>>();
                            for(int i=0;i<safetyRsltArray.size();i++){
                                Map<String,Object>  object = (Map<String, Object>) safetyRsltArray.get(i);
                                Map<String,Object> safetyRsltMap = new HashMap<String,Object>();
                                safetyRsltMap.put("itemCode", object.get("itemCode").toString().trim());
                                safetyRsltMap.put("itemRslt", object.get("itemRslt").toString().trim());
                                safetyRsltMap.put("surveyer", object.get("surveyer").toString().trim());
                                safetyRsltMap.put("surveyDate", object.get("surveyDate"));
                                safetyRsltList.add(safetyRsltMap);
                            }
                            parameterMap.put("safetyRsltList", safetyRsltList);
                        }


                        //班后会数据集
                        if(json.get("afterMeetRsltList") != null
                                && !"".equals(json.get("afterMeetRsltList").toString())
                                && !"null".equals(json.get("afterMeetRsltList").toString())){
                            String afterMeetRsltJson = json.get("afterMeetRsltList").toString();
                            JSONArray afterMeetRsltArray = JSONArray.fromObject(afterMeetRsltJson);
                            List<Map<String,Object>> afterMeetRsltList = new ArrayList<Map<String,Object>>(afterMeetRsltArray.size());
                            for(int i=0;i<afterMeetRsltArray.size();i++){
                                Map<String,Object> object = (Map<String, Object>) afterMeetRsltArray.get(i);
                                Map<String,Object> afterMeetRsltMap = new HashMap<String,Object>();
                                afterMeetRsltMap.put("hostName", object.get("hostName").toString().trim());
                                afterMeetRsltMap.put("deuNum", object.get("deuNum").toString().trim());
                                afterMeetRsltMap.put("realNum", object.get("realNum").toString().trim());
                                afterMeetRsltMap.put("meetDate", object.get("meetDate").toString().trim());
                                afterMeetRsltMap.put("meetAddr", object.get("meetAddr").toString().trim());
                                afterMeetRsltMap.put("recName", object.get("recName").toString().trim());

                                //班后会-->班会内容数据集
                                if(object.get("meetInspList") != null
                                        && !"".equals(object.get("meetInspList").toString())
                                        && !"null".equals(object.get("meetInspList").toString())){
                                    String meetInspJson = object.get("meetInspList").toString();
                                    JSONArray meetInspArray = JSONArray.fromObject(meetInspJson);
                                    List<Map<String,Object>> meetInspList = new ArrayList<Map<String,Object>>(meetInspArray.size());
                                    for(int j=0;j<meetInspArray.size();j++){
                                        Map<String,Object> meetInspMap = (Map<String, Object>) meetInspArray.get(j);
                                        Map<String,Object> meetInspQueryMap = new HashMap<String,Object>(meetInspMap.size());
                                        meetInspQueryMap.put("itemCode", meetInspMap.get("itemCode").toString().trim());
                                        meetInspQueryMap.put("itemRslt", meetInspMap.get("itemRslt").toString().trim());
                                        meetInspQueryMap.put("insper", meetInspMap.get("insper").toString().trim());
                                        meetInspQueryMap.put("inspDate", meetInspMap.get("inspDate"));
                                        meetInspList.add(meetInspQueryMap);
                                    }
                                    afterMeetRsltMap.put("meetInspList", meetInspList);//班会内容数据集
                                }
                                afterMeetRsltList.add(afterMeetRsltMap);
                            }
                            parameterMap.put("afterMeetRsltList", afterMeetRsltList);
                        }
                        queryList.add(parameterMap);
                    }
                    System.out.println("-------------------- finish  -------------------------");
                    // try{
                    //     // 封装返回json
                    //     retInfo.put("RT_F", ResultCode.CODE_SUCCESS);
                    //     retInfo.put("RT_D", ResultCode.MESSAGE_NULL);
                    //     Map<String,Object> queryMap = new HashMap<String,Object>();
                    //     queryMap.put("queryList", queryList);
                    //     fieldChkManageService.uploadCheckRslt(queryMap);
                    // }catch(BaseRuntimeException e){
                    //     logger.error("上传检验结果失败",e);
                    //     retInfo.put("RT_F", ResultCode.CODE_SERVER_ERROR);
                    //     retInfo.put("RT_D", e.getMessage() );
                    // }catch(Exception e){
                    //     logger.error("上传检验结果失败",e);
                    //     retInfo.put("RT_F", ResultCode.CODE_SERVER_ERROR);
                    //     retInfo.put("RT_D", "上传检验结果失败" );
                    // }
                }
            }
        }catch(Exception e){
            // logger.error("上传检验结果失败",e);
            // retInfo.put("RT_F", ResultCode.CODE_SERVER_ERROR);
            // retInfo.put("RT_D", "上传检验结果失败" );
        }
        // out.print(retInfo);
    }

    /**
     * //间接测试结果数据集
     * @param chkIndirectRsltListJson
     * @return
     */
    private Object chkIndirectRsltList(String chkIndirectRsltListJson) {
        JSONArray chkIndirectRsltArray = JSONArray.fromObject(chkIndirectRsltListJson);
        List<Map<String,Object>> chkIndirectRsltList = new ArrayList<Map<String,Object>>(chkIndirectRsltArray.size());					//检验结果数据集 chkRsltDets
        String chkIndirectDetListJson = "";
        for(int j=0;j<chkIndirectRsltArray.size();j++){
            Map<String,Object> chkIndirectRsltMap = (Map<String, Object>) chkIndirectRsltArray.get(j);
            Map<String,Object> chkIndirectRsltQueryMap = new HashMap<String,Object>(chkIndirectRsltMap.size());
            chkIndirectRsltQueryMap.put("chkType", chkIndirectRsltMap.get("chkType"));//现场检验类型
            chkIndirectRsltQueryMap.put("humidity", chkIndirectRsltMap.get("humidity"));//湿度
            chkIndirectRsltQueryMap.put("humidity", chkIndirectRsltMap.get("humidity"));//湿度
            chkIndirectRsltQueryMap.put("polarity", chkIndirectRsltMap.get("polarity"));//极性
            chkIndirectRsltQueryMap.put("compoundErr", chkIndirectRsltMap.get("compoundErr"));//复合误差
            chkIndirectRsltQueryMap.put("fstRcCode", chkIndirectRsltMap.get("fstRcCode"));//实际一次电流
            chkIndirectRsltQueryMap.put("actualVoltRatio", chkIndirectRsltMap.get("actualVoltRatio"));//实际电压比
            chkIndirectRsltQueryMap.put("dc", chkIndirectRsltMap.get("dc"));//直阻
            chkIndirectRsltQueryMap.put("shortTurns", chkIndirectRsltMap.get("shortTurns"));//短路匝
            chkIndirectRsltQueryMap.put("secuCoef", chkIndirectRsltMap.get("secuCoef"));//保安系数
            chkIndirectRsltQueryMap.put("concCode", chkIndirectRsltMap.get("concCode"));//检验结论
            //间接测试结果明细数据集	chkIndirectDetList
            if(chkIndirectRsltMap.get("chkIndirectDetList") != null
                    && !"".equals(chkIndirectRsltMap.get("chkIndirectDetList").toString())
                    && !"null".equals(chkIndirectRsltMap.get("chkIndirectDetList").toString())){
                chkIndirectDetListJson = chkIndirectRsltMap.get("chkIndirectDetList").toString();
                JSONArray chkIndirectDetArray = JSONArray.fromObject(chkIndirectDetListJson);
                List<Map<String,Object>> chkIndirectDetList = new ArrayList<Map<String,Object>>(chkIndirectDetArray.size());					//检验结果数据集 chkRsltDets
                for(int i=0;i<chkIndirectDetArray.size();i++){
                    Map<String,Object> map = (Map<String, Object>) chkIndirectDetArray.get(j);
                    Map<String,Object> chkIndirectDetMap = new HashMap<String,Object>(map.size());
                    chkIndirectDetMap.put("pct", map.get("pct"));//百分比
                    chkIndirectDetMap.put("loadType", map.get("loadType"));//负荷类型
                    chkIndirectDetMap.put("ratioErr", map.get("ratioErr"));//比值差
                    chkIndirectDetMap.put("angleErr", map.get("angleErr"));//相位差
                    chkIndirectDetList.add(chkIndirectDetMap);
                }
                chkIndirectRsltQueryMap.put("chkIndirectDetList", chkIndirectDetList);
            }
            chkIndirectRsltList.add(chkIndirectRsltQueryMap);
        }
        return chkIndirectRsltList;
    }

    /**
     * 伏安特性励磁特性测试结果数据集	chkVaExRsltList
     * @param chkVaExRsltListJson
     * @return
     */
    private Object chkVaExRsltList(String chkVaExRsltListJson) {
        JSONArray chkVaExRsltArray = JSONArray.fromObject(chkVaExRsltListJson);
        List<Map<String,Object>> chkVaExRsltList = new ArrayList<Map<String,Object>>(chkVaExRsltArray.size());					//检验结果数据集 chkRsltDets
        String chkVaExDetJson = "";
        for(int j=0;j<chkVaExRsltArray.size();j++){
            Map<String,Object> chkVaExRsltMap = (Map<String, Object>) chkVaExRsltArray.get(j);
            Map<String,Object> chkVaExRsltQueryMap = new HashMap<String,Object>(chkVaExRsltMap.size());
            chkVaExRsltQueryMap.put("chkType", chkVaExRsltMap.get("chkType"));//现场检验类型
            chkVaExRsltQueryMap.put("humidity", chkVaExRsltMap.get("humidity"));//湿度
            chkVaExRsltQueryMap.put("humidity", chkVaExRsltMap.get("humidity"));//湿度

            //伏安特性励磁特性测试结果明细数据集	chkVaExDetList
            if(chkVaExRsltMap.get("chkVaExDetList") != null
                    && !"".equals(chkVaExRsltMap.get("chkVaExDetList").toString())
                    && !"null".equals(chkVaExRsltMap.get("chkVaExDetList").toString())){
                chkVaExDetJson = chkVaExRsltMap.get("chkVaExDetList").toString();
                JSONArray chkVaExDetArray = JSONArray.fromObject(chkVaExDetJson);
                List<Map<String,Object>> chkVaExDetList = new ArrayList<Map<String,Object>>(chkVaExDetArray.size());					//检验结果数据集 chkRsltDets
                for(int i=0;i<chkVaExDetArray.size();i++){
                    Map<String,Object> map = (Map<String, Object>) chkVaExDetArray.get(j);
                    Map<String,Object> chkSndPreDetMap = new HashMap<String,Object>(map.size());
                    chkSndPreDetMap.put("detOrder", map.get("detOrder"));//结果序号
                    chkSndPreDetMap.put("rcCode", map.get("rcCode"));//电流
                    chkSndPreDetMap.put("rvCode", map.get("rvCode"));//电压
                    chkVaExDetList.add(chkSndPreDetMap);
                }
                chkVaExRsltQueryMap.put("chkVaExDetList", chkVaExDetList);
            }
            chkVaExRsltList.add(chkVaExRsltQueryMap);
        }
        return chkVaExRsltList;
    }

    /**
     * PT二次压降测试结果数据集	chkSndPreRsltList
     * @param chkSndPreRsltListJson
     * @return
     */
    private List<Map<String,Object>> chkSndPreRsltList(String chkSndPreRsltListJson) {
        JSONArray chkSndPreRsltArray = JSONArray.fromObject(chkSndPreRsltListJson);
        List<Map<String,Object>> chkSndPreRsltList = new ArrayList<Map<String,Object>>(chkSndPreRsltArray.size());					//检验结果数据集 chkRsltDets
        String chkSndPreDetJson = "";
        for(int j=0;j<chkSndPreRsltArray.size();j++){
            Map<String,Object> chkSndPreRsltMap = (Map<String, Object>) chkSndPreRsltArray.get(j);
            Map<String,Object> chkSndPreRsltQueryMap = new HashMap<String,Object>(chkSndPreRsltMap.size());
            chkSndPreRsltQueryMap.put("chkType", chkSndPreRsltMap.get("chkType"));//现场检验类型
            chkSndPreRsltQueryMap.put("subNo", chkSndPreRsltMap.get("subNo"));//厂站编号
            chkSndPreRsltQueryMap.put("subsName", chkSndPreRsltMap.get("subsName"));//厂站名称
            chkSndPreRsltQueryMap.put("switchNo", chkSndPreRsltMap.get("switchNo"));//开关号
            chkSndPreRsltQueryMap.put("temp", chkSndPreRsltMap.get("temp"));//温度
            chkSndPreRsltQueryMap.put("humidity", chkSndPreRsltMap.get("humidity"));//湿度
            chkSndPreRsltQueryMap.put("concCode", chkSndPreRsltMap.get("concCode"));//检验结论

            //PT二次压降测试结果明细数据集	chkSndPreDetList
            chkSndPreDetJson = chkSndPreRsltMap.get("chkSndPreDetList").toString();
            JSONArray chkSndPreDetArray = JSONArray.fromObject(chkSndPreDetJson);
            List<Map<String,Object>> chkSndPreDetList = new ArrayList<Map<String,Object>>(chkSndPreDetArray.size());					//检验结果数据集 chkRsltDets
            for(int i=0;i<chkSndPreDetArray.size();i++){
                Map<String,Object> map = (Map<String, Object>) chkSndPreDetArray.get(j);
                Map<String,Object> chkSndPreDetMap = new HashMap<String,Object>(map.size());
                chkSndPreDetMap.put("wiringMode", map.get("wiringMode"));//接线方式  参见试图VW_IT_PHASE
                chkSndPreDetMap.put("phaseCode", map.get("phaseCode"));//相别
                chkSndPreDetMap.put("ratioErr", map.get("ratioErr"));//比值差
                chkSndPreDetMap.put("angleErr", map.get("angleErr"));//相位差
                chkSndPreDetMap.put("sndPre", map.get("sndPre"));//二次压降
                chkSndPreDetMap.put("rvCode", map.get("rvCode"));//电压
                chkSndPreDetList.add(chkSndPreDetMap);
            }
            chkSndPreRsltQueryMap.put("chkBasicDetList", chkSndPreDetList);
            chkSndPreRsltList.add(chkSndPreRsltQueryMap);
        }
        return chkSndPreRsltList;
    }

    //实际负荷测试结果数据集	chkLoadRsltList
    private List<Map<String,Object>> chkLoadRsltList(String chkLoadRsltListJson) {
        JSONArray chkLoadRsltArray = JSONArray.fromObject(chkLoadRsltListJson);
        List<Map<String,Object>> chkLoadRsltList = new ArrayList<Map<String,Object>>(chkLoadRsltArray.size());					//检验结果数据集 chkRsltDets
        for(int j=0;j<chkLoadRsltArray.size();j++){
            Map<String,Object> map = (Map<String, Object>) chkLoadRsltArray.get(j);
            Map<String,Object> chkLoadRsltQueryMap = new HashMap<String,Object>(6);
            chkLoadRsltQueryMap.put("chkType", map.get("chkType"));//现场检验类型
            chkLoadRsltQueryMap.put("temp", map.get("temp"));//温度
            chkLoadRsltQueryMap.put("resi", map.get("resi"));//电阻
            chkLoadRsltQueryMap.put("reac", map.get("reac"));//电抗
            chkLoadRsltQueryMap.put("rvCode", map.get("rvCode"));//电压
            chkLoadRsltQueryMap.put("rcCode", map.get("rcCode"));//电流
            chkLoadRsltQueryMap.put("actualLoad", map.get("actualLoad"));//实际负荷
            chkLoadRsltQueryMap.put("humidity", map.get("humidity"));//湿度
            chkLoadRsltQueryMap.put("concCode", map.get("concCode"));//检验结论
            chkLoadRsltQueryMap.put("phaseCode", map.get("phaseCode"));//相别
            chkLoadRsltList.add(chkLoadRsltQueryMap);
        }
        return chkLoadRsltList;
    }

    //Z测试Y测试结果数据集	chkZYRsltList
    private List<Map<String,Object>> chkZYRsltListList(String chkZYRsltListJson) {
        JSONArray chkZYRsltArray = JSONArray.fromObject(chkZYRsltListJson);
        List<Map<String,Object>> chkZYRslt = new ArrayList<Map<String,Object>>(chkZYRsltArray.size());					//检验结果数据集 chkRsltDets

        for(int j=0;j<chkZYRsltArray.size();j++){
            Map<String,Object> map = (Map<String, Object>) chkZYRsltArray.get(j);
            Map<String,Object> chkZYRsltQueryMap = new HashMap<String,Object>(6);
            chkZYRsltQueryMap.put("chkType", map.get("chkType"));//现场检验类型
            chkZYRsltQueryMap.put("pct", map.get("pct"));//百分比
            chkZYRsltQueryMap.put("resi", map.get("resi"));//电阻
            chkZYRsltQueryMap.put("reac", map.get("reac"));//电抗
            chkZYRsltQueryMap.put("conduct", map.get("conduct"));//电导
            chkZYRsltQueryMap.put("susc", map.get("susc"));//电钠
            chkZYRsltQueryMap.put("actualLoad", map.get("actualLoad"));//实际负荷
            chkZYRslt.add(chkZYRsltQueryMap);
        }
        return chkZYRslt;
    }

    //误差测试数据集	chkBasicRsltList
    private List<Map<String,Object>> chkBasicRsltList(String jsonString){
        JSONArray chkRsltDetsArray = JSONArray.fromObject(jsonString);
        List<Map<String,Object>> chkBasicRsltList = new ArrayList<Map<String,Object>>(chkRsltDetsArray.size());					//检验结果数据集 chkRsltDets
        String chkBasicDetListJson = "";
        for(int j=0;j<chkRsltDetsArray.size();j++){
            Map<String,Object> chkBasicRsltMap = (Map<String, Object>) chkRsltDetsArray.get(j);
            Map<String,Object> chkBasicRsltQueryMap = new HashMap<String,Object>(chkBasicRsltMap.size());
            chkBasicRsltQueryMap.put("actualRatio", chkBasicRsltMap.get("actualRatio"));//实际电流/电压比
            chkBasicRsltQueryMap.put("polarity", chkBasicRsltMap.get("polarity"));//极性
            chkBasicRsltQueryMap.put("compoundErr", chkBasicRsltMap.get("compoundErr"));//复合误差
            chkBasicRsltQueryMap.put("temp", chkBasicRsltMap.get("temp"));//温度
            chkBasicRsltQueryMap.put("humidity", chkBasicRsltMap.get("humidity"));//湿度
            chkBasicRsltQueryMap.put("concCode", chkBasicRsltMap.get("concCode"));//检验结论
            //误差测试明细数据集	chkBasicDetList
            chkBasicDetListJson = chkBasicRsltMap.get("chkBasicDetList").toString();
            JSONArray chkBasicDetArray = JSONArray.fromObject(chkBasicDetListJson);
            List<Map<String,Object>> chkBasicDetList = new ArrayList<Map<String,Object>>(chkBasicDetArray.size());					//检验结果数据集 chkRsltDets
            for(int i=0;i<chkBasicDetArray.size();i++){
                Map<String,Object> map = (Map<String, Object>) chkBasicDetArray.get(j);
                Map<String,Object> chkBasicDetMap = new HashMap<String,Object>(map.size());
                chkBasicDetMap.put("pct", map.get("pct"));//百分比
                chkBasicDetMap.put("loadType", map.get("loadType"));//负荷类型
                chkBasicDetMap.put("ratioErr", map.get("ratioErr"));//比值差
                chkBasicDetMap.put("angleErr", map.get("angleErr"));//相位差
                chkBasicDetList.add(chkBasicDetMap);
            }
            chkBasicRsltQueryMap.put("chkBasicDetList", chkBasicDetList);
            chkBasicRsltList.add(chkBasicRsltQueryMap);
        }
        return chkBasicRsltList;
    }

}
