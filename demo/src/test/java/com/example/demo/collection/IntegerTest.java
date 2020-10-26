package com.example.demo.collection;

import java.util.Objects;

public class IntegerTest {
    public static void main(String[] args) {
        Integer a = 3;
        Integer b = 3;
        System.out.println(a == b);

        Integer x = new Integer(3);
        Integer y = new Integer(3);
        System.out.println(x == y);
        System.out.println(Objects.equals(x, y));
    }
}
