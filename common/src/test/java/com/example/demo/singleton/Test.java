package com.example.demo.singleton;

public class Test {
    public static void main(String[] args) {
        SingletonA singletonA = SingletonA.INSTANCE;

        singletonA.doSomething();
    }
}
