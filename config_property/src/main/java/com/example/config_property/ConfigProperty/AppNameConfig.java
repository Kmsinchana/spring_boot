package com.example.config_property.ConfigProperty;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(AppNameConfiguration.class)
public class AppNameConfig {
}
