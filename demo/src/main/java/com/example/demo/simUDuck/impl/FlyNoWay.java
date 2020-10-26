package com.example.demo.simUDuck.impl;

import com.example.demo.simUDuck.FlyBehavior;

public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I can't fly!");
    }
}
