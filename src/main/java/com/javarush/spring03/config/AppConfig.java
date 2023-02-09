package com.javarush.spring03.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.javarush.spring03")
@PropertySource("classpath:application.properties")
public class AppConfig {

}
