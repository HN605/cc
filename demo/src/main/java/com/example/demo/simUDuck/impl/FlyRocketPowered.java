package com.example.demo.simUDuck.impl;

import com.example.demo.simUDuck.FlyBehavior;

public class FlyRocketPowered implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I'm flying with a rocket!");
    }
}
