package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.utils.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class MessageController {

    @Autowired
    private MessageUtil messageUtils;


    @PostMapping("/upload")
    public String upload(@RequestPart("file") MultipartFile file, @RequestPart User user) {
        System.out.println(file.getOriginalFilename());
        return "success";
    }

    @RequestMapping(value = "/welcome")
    public Map<String, Object> welcome(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        map.put("tile", messageUtils.get("user.title") + "hotswaps test 1231231312");
        map.put("userName", messageUtils.get("userName"));
        return map;
    }

}
