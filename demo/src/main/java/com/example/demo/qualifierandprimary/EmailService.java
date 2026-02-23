package com.example.demo.qualifierandprimary;

import org.springframework.stereotype.Component;

@Component("Email")
public class EmailService implements MessageService {

    @Override
    public void sendMsg() {
        System.out.println("message send through email");
    }
}
