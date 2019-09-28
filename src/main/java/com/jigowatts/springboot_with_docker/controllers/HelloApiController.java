package com.jigowatts.springboot_with_docker.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloApiController
 */
@RestController
public class HelloApiController {

    @RequestMapping("/")
    public String index() {
        return "Welcome to SPRING BOOT with Docker.";
    }

    @RequestMapping("api/hello/{name}")
    public String hello(@PathVariable String name){
        return "Hello " + name + "!";
    }
    
}
