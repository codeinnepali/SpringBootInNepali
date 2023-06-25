package com.group.Demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @GetMapping(value = "/")
    public String Hello(String name, String role){
        return "Hello World";
    }
}
