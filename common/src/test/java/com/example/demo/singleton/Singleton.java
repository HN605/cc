package com.example.demo.singleton;

/**
 * 饿汉式-线程安全
 */
public class Singleton {
    private static Singleton uniqueInstance = new Singleton();

    private Singleton(){};

    public static Singleton getInstance() {
        return uniqueInstance;
    }
}
