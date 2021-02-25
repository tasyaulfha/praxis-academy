package com.example.jwthello.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/hello")
public class HelloWorldController {
    public String firstPage(){
        return "Hello World!";
    }

}
