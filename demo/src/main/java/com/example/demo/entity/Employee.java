package com.example.demo.entity;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
//@Scope("request")
public class Employee {
    @Autowired
     private User user;
    Employee(){
        System.out.println("Employee entity created");
    }

//    What is @PostConstruct?
//
//    @PostConstruct is a lifecycle annotation used in Spring-managed beans.
//
//    👉 It marks a method that should run:
//
//    After the bean is created
//
//    After all @Autowired dependencies are injected
//
//    Before the application starts serving requests
    @PostConstruct
    public void init(){
        System.out.println("Employee object hash code: " +this.hashCode() +"user hashcode: " +user.hashCode());
    }
}
