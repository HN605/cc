package com.example.demo.thread.productAndConsumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

public class Test {
    public static void main(String[] args) {
        LinkedBlockingDeque<String> strings = new LinkedBlockingDeque<>(4);
        new Product(strings).start();
        new Consumer(strings).start();
        new Consumer(strings).start();
        new Consumer(strings).start();

        ExecutorService service = Executors.newFixedThreadPool(2);
    }
}
