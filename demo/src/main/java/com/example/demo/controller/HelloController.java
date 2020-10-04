package com.example.demo.controller;

import com.example.demo.entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/hello")
public class HelloController {

    private Logger logger = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(){
        return "hello, my name is chen chuang";
    }

    @RequestMapping(value = "/person/add", method = RequestMethod.POST)
    public Map<String, Object> addPerson(Person person) {
        logger.info("收到请求，name = " + person.getName() + ", age= " + person.getAge());
        Map<String, Object> result = new HashMap<>();
        result.put("code", "0000");
        result.put("message", "success");
        return result;
    }
}
