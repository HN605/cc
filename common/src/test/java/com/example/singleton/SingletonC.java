package com.example.singleton;

/**
 * 懒汉式-双重检查加锁
 */
public class SingletonC {
    //volatile保证，当uniqueInstance变量被初始化成Singleton实例时，多个线程可以正确处理uniqueInstance变量
    private volatile static SingletonC uniqueInstance;

    private SingletonC() {}

    public static SingletonC getInstance() {
        if (uniqueInstance == null) {
            synchronized (SingletonC.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new SingletonC();
                }
            }
        }

        return  uniqueInstance;
    }


}
