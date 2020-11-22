package com.example.demo.collection;

/**
 * ClassLoadTest
 */
public class ClassTest {

    static {
        System.out.println("这是静态代码块1");
    }

    {
        System.out.println("这是构造代码块1");
    }

    public ClassTest() {
        System.out.println("这是无参构造函数");
    }

    public ClassTest(int t) {
        System.out.println("这是带参数的构造函数，参数是：" + t);
    }

    static {
        System.out.println("这是静态代码块2");
    }

    {
        System.out.println("这是构造代码块2");
    }

    public static void main(String[] args) {
        new ClassTest();
        new ClassTest();
    }

}