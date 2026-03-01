package com.example.profiling.controller;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
public class ApplicationJava {

    @Autowired
    Environment env;

    @Value("${user_name}")
    private String name;

    @Value("${password}")
    private String password;

    @PostConstruct
    public void displayProfile(){
        System.out.println(name);
        System.out.println(password);
    }
// this method to debug the evn variable
    @PostConstruct
    public void check() {
        System.out.println("user_name = "
                + env.getProperty("user_name"));
    }
}
