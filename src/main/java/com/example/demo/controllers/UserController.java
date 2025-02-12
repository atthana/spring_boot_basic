package com.example.demo.controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  
// @RequestMapping("/users")
public class UserController {

    @GetMapping("/")
    public String display() {
        return "Hello Spring Boot Users!";
    }
    @GetMapping("/about")
    public String about() {
        return "Abount QQ!";
    }
    @GetMapping("/api")
    public String api() {
        return "Test API!";
    }
}
