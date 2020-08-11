package com.example.demo.singleton;

import java.util.function.DoubleToIntFunction;

/**
 * 饿汉式
 */
public enum SingletonA {
    INSTANCE;

    public void doSomething() {
        System.out.println("枚举方法实现单例");
    }
}
