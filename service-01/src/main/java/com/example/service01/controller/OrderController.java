package com.example.service01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/order")
public class OrderController {

    @GetMapping("/test")
    public String test() {
        return "this is a test";
    }
}
