package com.example.demo;

import com.example.demo.config.BeanConfig;
import com.example.demo.service.impl.UseFunctionService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        UseFunctionService useFunctionService = context.getBean(UseFunctionService.class);
        System.out.println(useFunctionService.sayHello("java config"));

        context.close();
    }
}
