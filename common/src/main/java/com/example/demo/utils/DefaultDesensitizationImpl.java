package com.example.demo.utils;

public class DefaultDesensitizationImpl implements IDesensitization {
    @Override
    public String around(String str, int left, int right) {
        if (str == null || (str.length() < left + right + 1)) {
            return str;
        }
        String regex = String.format("(?<=\\w{%d})\\w(?=\\w{%d})", left, right);
        return str.replaceAll(regex, REPLACE_CHAR);
    }

    @Override
    public String idCard(String cardNum) {
        return this.around(cardNum, 3, 4);
    }

    @Override
    public String phone(String phone) {
        return this.around(phone, 3, 4);
    }
}
