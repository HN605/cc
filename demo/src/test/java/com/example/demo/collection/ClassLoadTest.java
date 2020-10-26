package com.example.demo.collection;

/**
 * ClassLoadTest
 */
public class ClassLoadTest {

    public static void main(String[] args) throws Exception{
        ClassLoader classLoader = ClassLoadTest.class.getClassLoader();

        System.out.println("before load");
        Class c = classLoader.loadClass("com.example.demo.collection.ClassDemo");
        System.out.println("after load");

        System.out.println("----------------------------------");

        System.out.println("before load instance");
        ClassDemo classDemo = (ClassDemo) c.newInstance();
        System.out.println("after load instance");

    }
}