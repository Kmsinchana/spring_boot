package com.example.demo.qualifierandprimary;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class SMSService implements MessageService{

    @Override
    public void sendMsg() {
        System.out.println("message send through SMS");
    }
}
