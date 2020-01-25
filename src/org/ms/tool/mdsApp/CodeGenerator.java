package org.ms.tool.mdsApp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodeGenerator {
    private static Pattern linePattern = Pattern.compile("_(\\w)");


    public static void main(String[] args) {

        String tableName = "u_dist_app";

        CodeGenerator cg = new CodeGenerator();
        cg.execute(tableName);
    }

    public void execute(String tableName) {

        List<String> fieldList = getTableFields(tableName);  //retrieve

        StringBuilder insertFieldSb = new StringBuilder();
        StringBuilder insertValueSb = new StringBuilder();
        StringBuilder updateSb = new StringBuilder();

        for (int i = 0, len = fieldList.size(); i < len; i++) {
            String fieldName = fieldList.get(i);
            String camelFieldName = convertColumnName(fieldName);
            insertFieldSb.append(", ").append(fieldName);
            insertValueSb.append(", #").append(camelFieldName).append("#");
            updateSb.append(", ").append(fieldName).append(" = #").append(convertColumnName(fieldName)).append("#");
        }

        StringBuilder insertSql = new StringBuilder();
        StringBuilder updateSql = new StringBuilder();

        insertSql.append("insert into ").append(tableName).append(" (").append(insertFieldSb.substring(2)).append(")")
                .append(" values (").append(insertValueSb.substring(2)).append(")");
        updateSql.append("update ").append(tableName).append(" set ").append(updateSb.substring(2)).append(" where 1=1");

        System.out.println(insertSql.toString());
        System.out.println(updateSql.toString());
    }


    /**
     * 根据数据库表名获得表中字段及其类型
     * @param tableName
     * @return List<Map<String, String>>
     */
    private List<String> getTableFields(String tableName){
        Connection conn = getConnection();
        String sql = "select * from " + tableName;
        List<String> dataList = new ArrayList<>();
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData data = rs.getMetaData();
            for (int i = 1, k = data.getColumnCount(); i <= k; i++) {
                String columnName = data.getColumnName(i);  // 获得指定列的列名

                dataList.add(columnName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dataList;
    }

    /**
     * 按驼峰命名规则转换数据库表中列名
     * @param columnName
     * @return String
     */
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


    /**
     * 获得数据库连接
     * @return
     */
    private static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            String url = "jdbc:oracle:thin:@192.168.11.139:1521:orcl";
            String user = "ha_mpac";
            String pass = "ha_mpac";
            conn = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }


}
