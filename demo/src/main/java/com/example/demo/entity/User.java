package com.example.demo.entity;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class User {
    User(){
        System.out.println("user initiated");
    }

    @PostConstruct
    public void init(){
        System.out.println("user hash code is" +this.hashCode());
    }
}
