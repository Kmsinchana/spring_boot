package com.example.config_property.ConfigProperty;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@ConfigurationProperties(prefix = "payment.gateway")
@Getter
@Setter
@Validated
public class PaymentGatewayProperty {

    @NotNull
    private String url;
    @NotNull
    private String apikey;
    private int timeout;
}
