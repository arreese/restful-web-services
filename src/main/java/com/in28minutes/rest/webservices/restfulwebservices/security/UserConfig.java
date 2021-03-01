package com.in28minutes.rest.webservices.restfulwebservices.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
@Configuration
@PropertySource("classpath:application.properties")
public class UserConfig {
    @Value("${spring.security.user.name}")
    private String userName;
    @Value("${spring.security.user.password}")
    private String password;
    public String getUserName() {
        return userName;
    }
    public String getPassword() {
        return password;
    }
}
