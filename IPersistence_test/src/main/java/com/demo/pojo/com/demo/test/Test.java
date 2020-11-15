package com.demo.pojo.com.demo.test;

import com.demo.io.Resources;

import java.io.InputStream;

public class Test {
    public void test() {
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
    }
}
