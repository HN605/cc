package com.example.demo.service.impl;

import com.example.demo.service.Fruit;

public class Apple implements Fruit {
    @Override
    public void show() {
        System.out.println("<<<<<<<<method is invoked");
    }
}
