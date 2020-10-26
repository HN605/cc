package com.example.demo;

import com.example.demo.simUDuck.Duck;
import com.example.demo.simUDuck.MallardDuck;
import com.example.demo.simUDuck.ModelDuck;
import com.example.demo.simUDuck.impl.FlyRocketPowered;

public class MiniDuckSimulator {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.performFly();
        mallard.performQuack();

        Duck model = new ModelDuck();
        model.performFly();
        model.setFlyBehavior(new FlyRocketPowered());
        model.performFly();
    }
}
