package com.example.service02.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("service-01")
public interface OrderFeign {
    @GetMapping("/test")
    String test();
}
