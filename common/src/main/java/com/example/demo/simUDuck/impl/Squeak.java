package com.example.demo.simUDuck.impl;

import com.example.demo.simUDuck.QuackBehavior;

public class Squeak implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Squeak");
    }
}
