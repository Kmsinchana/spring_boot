package com.example.bean_lifecycle_spring_data_jpa.beancycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class NewWay {

    @PostConstruct
    public void init(){
        System.out.println("using post-construct");
    }

    @PreDestroy
    public void dispose(){
        System.out.println("distroying a bean with new way");
    }
}
