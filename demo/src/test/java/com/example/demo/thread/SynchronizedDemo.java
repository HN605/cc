package com.example.demo.thread;

public class SynchronizedDemo {
    Object object = new Object();
    public void method() {
        synchronized (object) {

        }
    }
}
