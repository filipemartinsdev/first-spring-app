package com.filipe.first_spring_app.controller;

import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/hello")
public class HelloController {

    @GetMapping()
    public String helloGet(){
        return "Hello World!";
    }

    @GetMapping("/{name}")
    public String helloGet(@PathVariable("name") String name){
        return "Hello "+name+"!";
    }

//    @PostMapping()
//    public String helloPost(){}
}
