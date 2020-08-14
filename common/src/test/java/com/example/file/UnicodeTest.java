package com.example.file;

import java.io.UnsupportedEncodingException;

public class UnicodeTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        test2();
    }

    public static void test1() {
        String str = "我爱中国 china";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            System.out.println(c + " " + Integer.toHexString((int)c));

        }

        System.out.println("\u4e2d\u56fd");
    }

    public static void test2() throws UnsupportedEncodingException {
        String str = "我爱中国 china";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            //byte[] bytes = (c + "").getBytes("utf-8");
            byte[] bytes = (c + "").getBytes("gb2312");

            String tem = "";

            for (byte b: bytes) {
                tem += Integer.toHexString(b & 0x00ff) + " ";
            }

            System.out.println(c + " " + tem);

        }

        System.out.println("\u4e2d\u56fd");
    }
}
