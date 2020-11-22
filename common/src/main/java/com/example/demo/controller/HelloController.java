package com.example.demo.controller;

import com.example.demo.common.BizException;
import com.example.demo.entity.Person;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Api("hello")
@RestController
@RequestMapping(value = "/")
public class HelloController {

    private Logger logger = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(){
        throw new BizException("this is a exception test");
        //return "hello, my name is chen chuang";
    }

    @ApiOperation("hello")
    @RequestMapping(value = "/person/add", method = RequestMethod.POST)
    public Map<String, Object> addPerson(Person person) {
        logger.info("收到请求，name = " + person.getName() + ", age= " + person.getAge());
        Map<String, Object> result = new HashMap<>();
        result.put("code", "0000");
        result.put("message", "success");
        return result;
    }
}
