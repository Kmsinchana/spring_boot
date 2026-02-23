package com.example.demo.qualifierandprimary;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class NotificationSendService {

//    we can use both constructor and autowire injection but its not recommended
//    code will run successfully but the injection happens twice first constructor injection happens and the field one
    @Autowired
    private MessageService messageService;

//    recommended
    NotificationSendService(@Qualifier("Email")MessageService messageService){
        this.messageService= messageService;
    }
//    if we doesn't use @qualifier and @primary then we get below error
//Field messageService in com.example.demo.qualifierandprimary.NotificationSendService required a single bean, but 2 were found:
//            - emailService: defined in file [E:\Downloads\demo\demo\target\classes\com\example\demo\qualifierandprimary\EmailService.class]
//            - SMSService: defined in file [E:\Downloads\demo\demo\target\classes\com\example\demo\qualifierandprimary\SMSService.class]

    @PostConstruct
    public void init(){
        System.out.println("the bean which is injected is" +messageService.getClass().getName());
    }


}
