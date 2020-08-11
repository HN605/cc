package com.example.demo.test;

/**
 * ClassLoadDemo
 */
public class ClassDemo {

    static {
        System.out.println("执行了静态代码块");
        int x = 1;
    }


    public ClassDemo() {
        System.out.println("执行了构造方法");
    }


    
}