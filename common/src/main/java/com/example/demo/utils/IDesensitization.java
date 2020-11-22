package com.example.demo.utils;

public interface IDesensitization {

    String REPLACE_CHAR = "*";

    /**
     * 脱敏
     *
     * @param str   待脱敏字符串
     * @param left  左边保留多少位
     * @param right 右边保留多少位
     * @return 脱敏结果，除左右外，其余字符将被替换为*
     */
    String around(String str, int left, int right);

    /**
     * 身份证号脱敏
     *
     * @param cardNum 身份证号码
     * @return 脱敏后身份证号码，形如510**********1232
     */
    String idCard(String cardNum);

    /**
     * 电话号码脱敏
     *
     * @param phone 电话号码
     * @return 脱敏后电话号码，形如152****1232
     */
    String phone(String phone);
}
