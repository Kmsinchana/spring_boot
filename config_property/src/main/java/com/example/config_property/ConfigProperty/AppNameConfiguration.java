package com.example.config_property.ConfigProperty;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@ConfigurationProperties(prefix = "app")
@Validated
@Getter
@Setter
public class AppNameConfiguration {

//    if the name mismatch from the yml file then it will return null only for that particular field not compilation error will come
    @NotNull
    private String name;

    @NotNull
    private String version;

    private String support_email;
}
