package org.ms.util.freemarker.demo;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/2/3 0003.
 */
public class CodeGenerator {
    private static final String FTL_FILE_PATH = "D:\\Program Files\\iworkspace\\iProject\\src\\org\\ms\\util\\freemarker\\demo\\ftl";
    private Configuration cfg;
    private static Pattern linePattern = Pattern.compile("_(\\w)");

    public void generateCode(String tableName){
        getTemplateCfg();
        if(cfg == null) return;

        //1. 连接数据库，获得表的相关数据
        //2. 通过这些数据，要根据五个模板，创建四个java类和一个XML文件。
        generateBo();

    }

    private List<Map<String, String>> getTableFields(String tableName){

        Connection conn = getConnection();
        String sql = "select * from " + tableName;
        List<Map<String, String>> dataList = new ArrayList<>();
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData data = rs.getMetaData();
            for (int i = 1, k = data.getColumnCount(); i <= k; i++) {
                // 获得指定列的列名
                String columnName = data.getColumnName(i);
                // 获得指定列的数据类型名
                String columnTypeName = data.getColumnTypeName(i);

                columnName = convertColumnName(columnName);
                if ("id".equalsIgnoreCase(columnName)
                        || "optrCode".equalsIgnoreCase(columnName)
                        || "optTime".equalsIgnoreCase(columnName)){
                    continue;
                }
                columnTypeName = columnTypeToJavaType(columnTypeName);


                Map<String, String> map = new HashMap<>();
                map.put("type", columnTypeName);
                map.put("name", columnName);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dataList;
    }

    private String convertColumnName(String columnName){
        columnName = columnName.toLowerCase();
        Matcher matcher = linePattern.matcher(columnName);
        StringBuffer sb = new StringBuffer();
        while(matcher.find()){
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    private String columnTypeToJavaType(String columnTypeName){
        if("varchar2".equalsIgnoreCase(columnTypeName)){
            return "String";
        }else if("number".equalsIgnoreCase(columnTypeName)){
            return "Long";
        }else if("date".equalsIgnoreCase(columnTypeName)){
            return "Date";
        }else{
            return "String";
        }
        //还是有Double的情况的，比如配送往返时间！！！！！！！！！！！！！！
    }

    private static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            String url = "jdbc:oracle:thin:@192.168.1.47:1521:eom";
            String user = "miptg_ha";
            String pass = "miptg_ha";
            conn = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public void generateBo(){
        Map root = new HashMap();
        root.put("package","org.ms.util.freemarker.demo.test.bo");
        root.put("boName","教师");
        root.put("author","Adminstrator");
        root.put("boClassName","Teacher");

        List<Map> fieldList = new ArrayList<>();
        Map field1 = new HashMap();
        field1.put("type","String");
        field1.put("name","name");
        fieldList.add(field1);

        Map field2 = new HashMap();
        field2.put("type","String");
        field2.put("name","age");
        fieldList.add(field2);

        Map field3 = new HashMap();
        field3.put("type","Date");
        field3.put("name","birthday");
        fieldList.add(field3);
        root.put("fieldList", fieldList);

        root.put("importClass","import java.util.Date;\r\nimport java.util.List;");

        String filePath = "D:\\Program Files\\iworkspace\\iProject\\src\\org\\ms\\util\\freemarker\\demo\\test\\bo\\Teacher.java";
        outputFile("bo.ftl", filePath, root);
    }

    /**
     * 输出文件
     */
    private void outputFile(String tmplName, String filePath, Object dataModel){
        try {
            /* Get the template (uses cache internally) */
            Template tmpl = cfg.getTemplate(tmplName);
            FileOutputStream fos = new FileOutputStream(new File(filePath)); //java文件的生成目录
            tmpl.process(dataModel, new OutputStreamWriter(fos, "UTF-8"));
        } catch (IOException e){
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获得模板配置对象
     */
    private void getTemplateCfg(){
        /* You should do this ONLY ONCE in the whole application life-cycle */
        /* Create and adjust the configuration singleton */
        cfg = new Configuration(Configuration.VERSION_2_3_25);
        try {
            cfg.setDirectoryForTemplateLoading(new File(FTL_FILE_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
        cfg.setDefaultEncoding("UTF-8");
        // cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        // cfg.setLogTemplateExceptions(false);
    }

    public static void main(String[] args) throws Exception {
        CodeGenerator cg = new CodeGenerator();
        cg.generateCode("test_teacher");
    }
}
