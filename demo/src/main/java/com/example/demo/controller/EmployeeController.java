package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.entity.User;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/employee")
//@Scope("prototype")
@Scope("request")
public class EmployeeController {
    @Autowired
     private Employee employee;
    @Autowired
     private User user;
    EmployeeController(){
        System.out.println("employee controller is created");
    }

    @PostConstruct
    public void init(){
        System.out.println("employee and employee controller are created" +this.hashCode() +"Employee hashcode"+employee.hashCode()+ "user hashcode:" +user.hashCode());
    }

    @GetMapping
    public ResponseEntity<String> callUser(){
        System.out.println("the method called");
        return ResponseEntity.status(HttpStatus.OK).body("ok");
    }
}

//for singleton,prototype,request do changes in EmployeeController, UserController, Employee
//singleton flow
//goes to the controller and creates necessary bean ans also create the bean which need to be injected
//goes to the entity then check wheather id all beans created, if created not creates the new one orelse creates the new one

//prototype flow
//it will be lazy initialization
//i have not mentioned anything for employee so it will be singleton flow by default, so only that bean will be created when application starts along with its dependency.
//then call the method of employee controller,their we can see that user is created a new instance but employee is the one which is created at first its reused.

//to understand prototype make every scope as prototype then when i call the employee api then i can observe that user will be created twice.

//then make the api as request the we can see that user will be created once per request,not twice as prototype

//now just make employee as singleton then run code
//the below error we get
//Error creating bean with name 'user': Scope 'request' is not active for the current thread; consider defining a scoped proxy for this bean if you intend to refer to it from a singleton
//because we have created request flow(in User) inside singleton flow(in Employee), so create a proxy in user(not the real user controller) that means proxy user will get created

// to check the session flow
//cha ge the userController to session then we can see as we call the get method no new userController will be created call the logout method then we can see that UserContoller will be created new