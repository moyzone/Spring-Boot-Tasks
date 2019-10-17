package com.stackroute.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
@ConfigurationProperties("lastfm")
@Data
public class ConfigProperties {
    private String prefix;
    private String suffix;
}
