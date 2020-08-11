package com.example.demo.entity;

import java.io.Serializable;

/**
 * Person
 */
public class Person implements Comparable<Person>, Serializable {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    //@NotNull(message = "name is not null")
    private String name;
    private int age;

    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person o) {
        if(this.age > o.getAge()) {
            return 1;
        } else if(this.age < o.getAge()) {
            return -1;
        }
        return age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    
}