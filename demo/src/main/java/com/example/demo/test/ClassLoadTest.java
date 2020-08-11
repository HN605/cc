package com.example.demo.test;

/**
 * ClassLoadTest
 */
public class ClassLoadTest {

    public static void main(String[] args) throws Exception{
        ClassLoader classLoader = ClassLoadTest.class.getClassLoader();

        System.out.println("before load");
        Class c = classLoader.loadClass("com.example.demo.test.ClassDemo");
        System.out.println("after load");

        System.out.println("----------------------------------");

        System.out.println("before load instance");
        ClassDemo classDemo = (ClassDemo) c.newInstance();
        System.out.println("after load instance");

    }
}