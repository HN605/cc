package com.example.demo.collection;

import com.example.demo.entity.Pizza;
import com.example.demo.enums.PizzaStatus;

public class EnumTest {
    public static void main(String[] args) {
        /*System.out.println(PizzaStatus.ORDERED.name());
        System.out.println(PizzaStatus.ORDERED);
        System.out.println(PizzaStatus.ORDERED.name().getClass());
        System.out.println(PizzaStatus.ORDERED.getClass());*/

        Pizza pizza = new Pizza();
        pizza.setStatus(Pizza.PizzaStatus.READY);
        System.out.println(pizza.isDeliverable());

        pizza.printTimeToDelivery();
    }
}
