package com.example.demo.simUDuck.impl;

import com.example.demo.simUDuck.FlyBehavior;

public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I'm flying!");
    }
}
