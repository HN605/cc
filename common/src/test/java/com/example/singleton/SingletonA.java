package com.example.singleton;

/**
 * 饿汉式
 */
public enum SingletonA {
    INSTANCE;

    public void doSomething() {
        System.out.println("枚举方法实现单例");
    }
}
