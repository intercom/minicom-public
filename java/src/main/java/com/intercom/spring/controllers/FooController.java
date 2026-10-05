package com.intercom.spring.controllers;

import java.util.Map;
import java.util.HashMap;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FooController {

    @PostMapping("/foo")
    public Map verify() {
        HashMap<String, Boolean> map = new HashMap<>();
        map.put("success", true);
        return map;
    }

}