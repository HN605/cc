package com.example.demo.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadTest test = new ThreadTest();
        MyCallAble mc = new MyCallAble();

        FutureTask<Integer> ft = new FutureTask<>(mc);

        Thread thread = new Thread(ft);

        thread.start();

        System.out.println(ft.get());
    }
}
