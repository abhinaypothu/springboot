package com.pothu.springbootpractice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {


    /*
    syntax to use key value pair from the application.properties
    @Value(${key})
     */
    @Value("${welcome.message}")
    String message;

    @RequestMapping(value = "/helloUsingRequestMapping",method = RequestMethod.GET)
    public String hello(){
        return message;
    }

    @GetMapping("/")
    public String hello2(){
        return "Hello world aaaaa";
    }
}
