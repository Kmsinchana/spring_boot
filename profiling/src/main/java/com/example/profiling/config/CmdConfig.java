package com.example.profiling.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class CmdConfig implements CommandLineRunner {

//    to pass the argument through command line use the below command in terminal
//    .\mvnw.cmd spring-boot:run "-Dspring-boot.run.arguments=hello,world

    @Override
    public void run(String... args) throws Exception {
        System.out.println("starting the command line arguments");
        for (String str:args){
            System.out.println("arguments are:"+str);
        }
    }

}
