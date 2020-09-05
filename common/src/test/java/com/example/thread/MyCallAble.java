package com.example.thread;

import java.util.concurrent.Callable;

public class MyCallAble implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        return 123;
    }
}
