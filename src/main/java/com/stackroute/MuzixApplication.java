package com.stackroute;

import com.stackroute.config.ConfigProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(ConfigProperties.class)
public class MuzixApplication {
	public static void main(String[] args) {
		SpringApplication.run(MuzixApplication.class, args);
	}
}
