package org.ms.javaTest.util;

public class StringUtil {

    private static final String SYMBOL_COMMA = ",";  //逗号

    public static final boolean isEmpty(String s) {
        return s == null || s.trim().equals("") || s.equals("null")
                || s.equals("NULL") || s.trim().equals("undefined");
    }
    public static final boolean isNotEmpty(String s) {
        return !isEmpty(s);
    }


}
