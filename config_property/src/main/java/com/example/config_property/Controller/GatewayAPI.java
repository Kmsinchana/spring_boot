package com.example.config_property.Controller;

import com.example.config_property.ConfigProperty.AppNameConfiguration;
import com.example.config_property.ConfigProperty.PaymentGatewayProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class GatewayAPI {

    @Autowired
    private PaymentGatewayProperty paymentGatewayProperty;

    @Autowired
    private AppNameConfiguration appNameConfiguration;

    @GetMapping("/gateway")
    public PaymentGatewayProperty getPaymentGatewayDetails(){
        return paymentGatewayProperty;
    }

    @GetMapping("/appname")
    public AppNameConfiguration getAppInformation(){
        return appNameConfiguration;
    }
}
