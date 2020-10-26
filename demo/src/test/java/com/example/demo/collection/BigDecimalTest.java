package com.example.demo.collection;

import java.math.BigDecimal;

public class BigDecimalTest {
    public static void main(String[] args) {
        /*float a = 1.0f - 0.9f;
        float b = 0.9f - 0.8f;
        System.out.println(a);
        System.out.println(b);
        System.out.println(a == b);*/

        BigDecimal a = new BigDecimal("1.0");
        BigDecimal b = new BigDecimal("0.9");
        BigDecimal c = new BigDecimal("0.8");
        BigDecimal x = a.subtract(b);
        BigDecimal y = b.subtract(c);
        System.out.println(x.equals(y));

        System.out.println(a.compareTo(b));

        BigDecimal m = new BigDecimal("1.255433");
        BigDecimal n = m.setScale(3, BigDecimal.ROUND_HALF_DOWN);
        System.out.println(n);

    }
}
