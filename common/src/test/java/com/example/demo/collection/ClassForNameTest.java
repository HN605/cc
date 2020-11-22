package com.example.demo.collection;

/**
 * ClassForNameTest
 */
public class ClassForNameTest {

    public static void main(String[] args) throws Exception {

        ClassLoader loader = ClassForNameTest.class.getClassLoader();

        System.out.println("before load");
        Class c = Class.forName("com.example.demo.collection.ClassDemo");
        System.out.println("after load");

        c.newInstance();
       

        System.out.println("----------------------------------");

        System.out.println("before load");
        Class c2 = Class.forName("com.example.demo.collection.ClassDemo", false, loader);
        System.out.println("after load"); 

        c2.newInstance();
    }
}