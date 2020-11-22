package com.example.demo.entity;

public class Singleton {

    private volatile static Singleton uniqueInstance;

    private Singleton() {}

    public static Singleton getUniqueInstance() {
        if (null == uniqueInstance) {
            synchronized (Singleton.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                }
            }
        }

        return uniqueInstance;
    }
}
