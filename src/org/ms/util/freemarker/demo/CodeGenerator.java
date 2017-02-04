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
    private static final String srcPath = "com.hzwq.mip.";
    private static Pattern linePattern = Pattern.compile("_(\\w)");
    private static Configuration cfg;


    public static void main(String[] args) throws Exception {
        CodeGenerator cg = new CodeGenerator();
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("tableName","mip_b_roundtime");
        paramMap.put("boName","配送往返时间");
        paramMap.put("moduleName","basis");
        paramMap.put("author","Adminstrator");
        cg.generateCode(paramMap);
    }

    public void generateCode(Map<String, Object> root){
        getTemplateCfg();
        if(cfg == null) return;

        //1. data-model相关数据
        setDataModel(root);

        //2. 通过这些数据，要根据五个模板，创建四个java类和一个XML文件。
        String[] tmplFile = {"bo", "idaoc", "daoc", "ibizc", "bizc", "iwebc", "webc"};
        for(String tmpl:tmplFile){
            String fileName = root.get("boClassName").toString();
            String tmplName = tmpl + ".ftl";

            if(tmpl.startsWith("i")){
                tmpl = tmpl.substring(1);
                fileName = "I" + fileName;
            }
            if(!tmpl.equalsIgnoreCase("bo")) {
                fileName = fileName + upperFirstCharacter(tmpl);
            }

            root.put("package", root.get("basePackage").toString() + "." + tmpl);  //单独处理
            root.put("importClass", "");  //单独处理

            String filePath = "D:\\Program Files\\iworkspace\\iProject\\src\\org\\ms\\util\\freemarker\\demo\\test\\"
                    + tmpl +"\\"+fileName+".java";
            outputFile(tmplName, filePath, root);
        }
    }

    private void setDataModel(Map<String, Object> root){
        String tableName = root.get("tableName").toString();
        List<Map<String, String>> fieldList = getTableFields(tableName);  //retrieve
        String boClassName= getBoClassName(tableName);  //convert
        root.put("boClassName", boClassName);
        root.put("basePackage", srcPath + root.get("moduleName").toString());

        List<Map<String, String>> fieldList_individual = new ArrayList<>();
        StringBuilder insertFieldStr = new StringBuilder();
        StringBuilder insertValuesStr = new StringBuilder();
        StringBuilder insertParamsStr = new StringBuilder();
        StringBuilder updateFieldStr = new StringBuilder();
        StringBuilder updateParamsStr = new StringBuilder();
        StringBuilder deleteFieldStr = new StringBuilder();
        StringBuilder deleteParamsStr = new StringBuilder();

        for(Map<String, String> field:fieldList){
            String name = field.get("name");
            String dbName = field.get("dbName");
            String getterName = upperFirstCharacter(name);  //首字母大写

            if (!"id".equalsIgnoreCase(name)
                    && !"optrCode".equalsIgnoreCase(name)
                    && !"optTime".equalsIgnoreCase(name)){
                fieldList_individual.add(field);
            }

            //新增
            insertFieldStr.append(",").append(dbName);
            insertValuesStr.append(",?");
            insertParamsStr.append(",entity.get").append(getterName).append("()");
            //修改
            if(!"id".equalsIgnoreCase(dbName)){
                updateFieldStr.append(",").append(dbName).append("=?");
                updateParamsStr.append(",entity.get").append(getterName).append("()");
            }
            //删除
            deleteFieldStr.append("and ").append(dbName).append("=? ");
            deleteParamsStr.append(",entity.get").append(getterName).append("()");
        }
        StringBuilder insertSql = new StringBuilder();
        insertSql.append("sb.append(\"insert into ").append(tableName).append(" (").append(insertFieldStr.substring(1)).append(")")
                .append(" values (").append(insertValuesStr.substring(1)).append(") \");");
        StringBuilder updateSql = new StringBuilder();
        updateSql.append("sb.append(\"update ").append(tableName).append(" set ").append(updateFieldStr.substring(1)).append(" where id=? \");");
        updateParamsStr.append(",entity.getId()");
        StringBuilder deleteSql = new StringBuilder();
        deleteSql.append("sb.append(\"delete from ").append(tableName).append(" where ").append(deleteFieldStr.substring(4)).append(" \");");
        StringBuilder querySql = new StringBuilder();
        querySql.append("sb.append(\"select ").append(insertFieldStr.substring(1)).append(" from ").append(tableName).append(" where 1=1 \");");

        List<Map<String, String>> methodList = new ArrayList<>();
        Map<String, String> saveMethod = new HashMap<>();
        saveMethod.put("comment", "新增");
        saveMethod.put("name", "add");
        saveMethod.put("sql", insertSql.toString());
        saveMethod.put("params", insertParamsStr.substring(1));
        methodList.add(saveMethod);

        Map<String, String> updateMethod = new HashMap<>();
        updateMethod.put("comment", "修改");
        updateMethod.put("name", "update");
        updateMethod.put("sql", updateSql.toString());
        updateMethod.put("params", updateParamsStr.substring(1));
        methodList.add(updateMethod);

        Map<String, String> deleteMethod = new HashMap<>();
        deleteMethod.put("comment", "删除");
        deleteMethod.put("name", "delete");
        deleteMethod.put("sql", deleteSql.toString());
        deleteMethod.put("params", deleteParamsStr.substring(1));
        methodList.add(deleteMethod);

        root.put("methodList", methodList);
        root.put("querySql", querySql);
        root.put("fieldList", fieldList_individual);
    }

    private String getBoClassName(String tableName){
        int x = tableName.indexOf("_", 4);
        tableName = tableName.substring(x + 1);  //roundtime
        tableName = convertColumnName(tableName);
        return upperFirstCharacter(tableName);
    }

    private String upperFirstCharacter(String str){
        char[] ca = str.toCharArray();
        ca[0] -= 32;
        return String.valueOf(ca);
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
                String columnName = data.getColumnName(i);  // 获得指定列的列名
                String columnTypeName = data.getColumnTypeName(i);  // 获得指定列的数据类型名

                Map<String, String> map = new HashMap<>();
                map.put("type", columnTypeToJavaType(columnTypeName));
                map.put("name", convertColumnName(columnName));
                map.put("dbName", columnName);
                dataList.add(map);
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

    /**
     * 输出文件
     */
    private void outputFile(String tmplName, String filePath, Object dataModel){
        try {
            /* Get the template (uses cache internally) */
            Template tmpl = cfg.getTemplate(tmplName);
            FileOutputStream fos = new FileOutputStream(new File(filePath)); //java文件的生成目录
            tmpl.process(dataModel, new OutputStreamWriter(fos, "UTF-8"));
            fos.flush();
            fos.close();
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
}
