package com.example.demo.utils;

public class WordsDesensitizationUtil {

    private static IDesensitization desensitization = new DefaultDesensitizationImpl();

    /**
     * 脱敏
     *
     * @param str   待脱敏字符串
     * @param left  左边保留多少位
     * @param right 右边保留多少位
     * @return 脱敏结果，除左右外，其余字符将被替换为*
     */
    public static String around(String str, int left, int right) {
        return desensitization.around(str, left, right);
    }

    /**
     * 身份证号脱敏
     *
     * @param cardNum 身份证号码
     * @return 脱敏后身份证号码，形如510**********1232
     */
    public static String idCard(String cardNum) {
        return desensitization.idCard(cardNum);
    }

    /**
     * 电话号码脱敏
     *
     * @param phone 电话号码
     * @return 脱敏后电话号码，形如152****1232
     */
    public static String phone(String phone) {
        return desensitization.phone(phone);
    }

    public static void main(String[] args) {
        System.out.println(phone("13825259304"));
    }
}
