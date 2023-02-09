package com.javarush.khmelov.config.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class AppRunnerAnnotationConfig {

    public static final String BASE = "com.javarush.khmelov";

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BASE);
        String[] names = applicationContext.getBeanDefinitionNames();
        Arrays.asList(names).forEach(System.out::println);
    }

}
