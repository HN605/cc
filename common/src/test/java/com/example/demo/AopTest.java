package com.example.demo;

import com.example.demo.aop.DynamicAgent;
import com.example.demo.service.Fruit;

public class AopTest {

    public static void main(String[] args){
        Fruit fruit = (Fruit) new DynamicAgent("com.example.demo.service.impl.Apple").agent(Fruit.class);
        fruit.show();
    }

}
