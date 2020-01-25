package org.ms.javaTest;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestSimpleDateFormat {

    public static void main(String[] args) throws Exception {
        String dateStr = "Sat Dec 07 2019 15:45:41 GMT%2B0800 (CST)";
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = formatDate.parse(dateStr);
        System.out.println(date);
    }

}
