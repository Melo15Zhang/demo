package com.example.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

@RestController
@RequestScope
public class ConfigController {

    @Value("${config.name}")
    private String name;
    @Value("${config.index}")
    private int index;

    @RequestMapping("/get")
    public String home() {
        return "index->" + index +"name->" + name;
    }
}
