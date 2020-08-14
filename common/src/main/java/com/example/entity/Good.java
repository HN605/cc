package com.example.entity;

/**
 * 实现comparable接口后，可以使用Arrays.sort()和Collections.sort()排序
 */
public class Good implements Comparable<Good> {

    private String name;
    private double price;

    public Good(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public int compareTo(Good good) {
        if (this.price > good.getPrice()) {
            return 1;
        } else if (this.price < good.getPrice()) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Good{name='" + name + "\'" + ", price=" + price + "}";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
