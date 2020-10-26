package com.example.demo.singleton;

/**
 * 懒汉式-登记式/静态内部类方式
 */
public class SingletonD {
    private static class SingletonHolder {
        private static final SingletonD INSTANCE = new SingletonD();
    }

    private SingletonD() {}

    public static final SingletonD getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
