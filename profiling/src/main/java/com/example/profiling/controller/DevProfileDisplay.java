package com.example.profiling.controller;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class DevProfileDisplay {
    @Value("${user_name}")
    private String name;

    @Value("${password}")
    private String password;

    @PostConstruct
    public void displayProfile(){
        System.out.println("dev profile display");
        System.out.println(name);
        System.out.println(password);
    }
}
