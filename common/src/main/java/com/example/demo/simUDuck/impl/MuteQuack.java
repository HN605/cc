package com.example.demo.simUDuck.impl;

import com.example.demo.simUDuck.QuackBehavior;

public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("<<Silence>>");
    }
}
