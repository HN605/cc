package com.example.singleton;

public class Test {
    public static void main(String[] args) {
        SingletonA singletonA = SingletonA.INSTANCE;

        singletonA.doSomething();
    }
}
