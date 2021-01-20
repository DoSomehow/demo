package org.ms.tool.excel;

/**
 * @author Ryan
 * @date 2021/1/20 12:23
 */
public class DbDataScript {

    private final static Integer LETTER_ASCII_A = 65;

    private static String TABLE_NAME = "u_dist_det";
    private static Integer COLUMN_NUM = 10;


    public static void main(String[] args) {
        DbDataScript dbDataScript = new DbDataScript();
        dbDataScript.execute();
    }

    public void execute() {
        StringBuilder fieldBuilder = new StringBuilder();
        StringBuilder valueBuilder = new StringBuilder();

        Integer asciiIndex = LETTER_ASCII_A;
        for (int i = 0; i < COLUMN_NUM; i++) {
            //
            char[] arr = Character.toChars(asciiIndex);
            String letter = String.valueOf(arr);
            asciiIndex++;
            //   '"&A3&"'
            fieldBuilder.append(", \"&$").append(letter).append("$1&\"");
            valueBuilder.append(", '\"&").append(letter).append("2&\"'");
        }

        StringBuilder resultBuilder = new StringBuilder();
        resultBuilder.append("=\"insert into ").append(TABLE_NAME).append(" (").append(fieldBuilder.substring(2)).append(") values (").append(valueBuilder.substring(2)).append(");\"");
        System.out.println(resultBuilder.toString());
    }

    private void test() {
        // 方法一：将char强制转换为byte
        char ch = 'A';
        byte byteAscii = (byte) ch;
        System.out.println(byteAscii);

        // 方法二：将char直接转化为int，其值就是字符的ascii
        int byteAscii1 = (int) ch;
        System.out.println(byteAscii1);

        // 直接int强制转换为char
        int ascii = 65;
        char ch1 = (char)ascii;
        System.out.println(ch1);
    }

}
