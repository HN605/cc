package com.example.demo.simUDuck;

import com.example.demo.simUDuck.impl.FlyNoWay;
import com.example.demo.simUDuck.impl.Quack;

public class ModelDuck extends Duck{

    public ModelDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("I'm a model duck");
    }
}
