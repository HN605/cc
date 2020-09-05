package com.example.singleton;

/**
 * 懒汉式
 */
public class SingletonB {
    private static SingletonB uniqueInstance;

    private SingletonB() {}

    //非线程安全
//    public static SingletonB getInstance() {
//        if (uniqueInstance == null) {
//            uniqueInstance = new SingletonB();
//        }
//
//        return uniqueInstance;
//    }

    //线程安全
    public static synchronized SingletonB getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new SingletonB();
        }

        return uniqueInstance;
    }
}
