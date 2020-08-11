package com.example.demo.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtil {
    /**
     * 日期格式：yyyy-MM-dd
     */
    private static final String DATE = "([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8])))";

    public static boolean isMatch(String input, String regex) {
        if (null == regex || regex.length() == 0) {
            return false;
        }
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public static void main(String[] args) {
        System.out.println(RegexUtil.isMatch("202003-25", RegexUtil.DATE));
    }
}
