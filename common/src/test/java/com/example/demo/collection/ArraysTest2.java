package com.example.demo.collection;

import java.util.Arrays;
import java.util.List;

public class ArraysTest2 {
    public static void main(String[] args) {
        String[] str = new String[] {"abc", "sdd"};
        List list = Arrays.asList(str);
        //list.add("chen"); //java.lang.UnsupportedOperationException
        str[0] = "chen";
        System.out.println(list.get(0));

    }
}
