package org.ms.temp;

import java.util.regex.Pattern;

public class TestReg {

    private static Pattern pattern = null;
    //middle
    private static String securityRule = ".*(^javascript(\\:|%3A)|(%27|\\\\')|--|[\\\\s+]and[\\\\s+]|/[\\\\*].*[\\\\*]/and[\\\\s+]|/[\\\\*].*[\\\\*]/and/[\\\\*].*[\\\\*]/|[\\\\s+]and/[\\\\*].*[\\\\*]/|[\\\\s+]or[\\\\s+]|/[\\\\*].*[\\\\*]/or[\\\\s+]|/[\\\\*].*[\\\\*]/or/[\\\\*].*[\\\\*]/|[\\\\s+]or/[\\\\*].*[\\\\*]/|[\\:%3A](<|%3c|&lt|&\\#60)[^\\:%3A]|[^\\:%3A](<|%3c|&lt|&\\#60)[\\:%3A]|[\\:%3A](>|%3e|&gt|&\\#62)[^\\:%3A]|[^\\:%3A](>|%3e|&gt|&\\#62)[\\:%3A]|^(<|%3c|&lt|&\\#60).*|^(>|%3e|&gt|&\\#62).*|(<|%3c|&lt|&\\#60)$|(>|%3e|&gt|&\\#62)$).*";
    //lower
    // private static String securityRule = ".*(^javascript\\:|(%27|\\\\')|[\\:%3A](<|%3c|&lt|&\\#60)[^\\:%3A]|[^\\:%3A](<|%3c|&lt|&\\#60)[\\:%3A]|[\\:%3A](>|%3e|&gt|&\\#62)[^\\:%3A]|[^\\:%3A](>|%3e|&gt|&\\#62)[\\:%3A]|^(<|%3c|&lt|&\\#60).*|^(>|%3e|&gt|&\\#62).*|(<|%3c|&lt|&\\#60)$|(>|%3e|&gt|&\\#62)$).*";

    public static void main(String[] args) {
        // String params = "bRA6xkmWS--Kdm_YSNH3ZspN85ne5aItBUa2TIQCDm5Zz_CSPG_D!-1595477704";
        String params = "bRA6xkmWSKdm_YSNH3ZspN85ne5aItBUa2TIQCDm5Zz_CSPG_D!-1595477704";
        pattern = Pattern.compile(securityRule, 2);
        boolean result = pattern.matcher(params).matches();
        System.out.println(result);

    }

}
