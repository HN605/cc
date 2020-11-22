package com.example.demo.jdbc;

import java.lang.reflect.Field;

public class FieldTest {
    public static void main(String[] args) throws Exception {

        User user = new User();
        user.setId(1);
        user.setUsername("chen");

        Class<?> aClass = Class.forName("com.example.demo.jdbc.User");
        Field declaredFields = aClass.getDeclaredField("username");
        declaredFields.setAccessible(true);
        Object o = declaredFields.get(user);
    }
}
