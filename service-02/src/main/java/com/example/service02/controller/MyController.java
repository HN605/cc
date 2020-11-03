package com.example.service02.controller;

import com.example.service02.feign.OrderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    private OrderFeign orderFeign;

    @GetMapping("/myTest")
    public String myTest() {
        return orderFeign.test();
    }


    /*@Autowired
    private RestTemplate restTemplate;

    @GetMapping("/myTest")
    public String myTest() {
        return restTemplate.getForObject("http://service-01/test", String.class);
    }*/
}
