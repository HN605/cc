package com.example.demo.collection;

/**
 * ClassTest2
 */
public class ClassTest2 {

    public static Parameter parameter1= new Parameter("这是静态成员变量");

    public Parameter parameter2 = new Parameter("这是非静态成员变量");

    public ClassTest2() {
        System.out.println("构造函数");
    }

    static {
        System.out.println("静态代码块");
    }

    {
        System.out.println("构造代码块a");
    }

    {
        System.out.println("构造代码块b");
    }

    public static void main(String[] args) {
        new ClassTest2();

        new ClassTest2();
    }
}