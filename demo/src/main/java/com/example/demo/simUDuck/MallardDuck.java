package com.example.demo.simUDuck;

import com.example.demo.simUDuck.Duck;
import com.example.demo.simUDuck.impl.FlyWithWings;
import com.example.demo.simUDuck.impl.Quack;

public class MallardDuck extends Duck {

    public MallardDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    @Override
    public void display() {
        System.out.println("I'm a real Mallard duck");
    }
}
