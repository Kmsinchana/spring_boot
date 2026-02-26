package com.example.demo.controller;

import com.example.demo.entity.User;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@Scope("session")
public class UserController {
    @Autowired
     private User user;
    UserController(){
        System.out.println("user controller initiated");
    }

    @PostConstruct
    public void init(){
        System.out.println("user controller hash code"+this.hashCode()+"user hashcode"+user.hashCode());
    }

    @GetMapping
    public ResponseEntity<String> callUser(){
        System.out.println("the method called");
        return ResponseEntity.status(HttpStatus.OK).body("ok");
    }

    @GetMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest request){
        System.out.println("the method called");
        request.getSession().invalidate();
        return ResponseEntity.status(HttpStatus.OK).body("ok");
    }
}
