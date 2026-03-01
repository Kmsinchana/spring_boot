package com.example.profiling.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.Arrays;

@Component
public class ApplicationRunnerExp implements ApplicationRunner {

//command to run
//    .\mvnw.cmd spring-boot:run "-Dspring-boot.run.arguments=--name=Sinchana --age=22 file1.txt"
//    .\mvnw.cmd spring-boot:run "-Dspring-boot.run.arguments=--name=Sinchana --name=shiva --age=22 file1.txt"
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("running the application runner");
        System.out.println(args.containsOption("name")); //return true or false
        System.out.println(args.getOptionNames()); //keys will be printed
        System.out.println(args.getOptionValues("name")); //value will be printed
        System.out.println(args.getNonOptionArgs()); //displays all non optional values
        Arrays.stream(args.getSourceArgs()).forEach(System.out::println); //this will return the array of strings
    }
}
