package com.javarush.khmelov.config.spring;

import com.javarush.khmelov.repository.SessionCreator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@ComponentScan("com.javarush.khmelov")
public class AppRunnerJavaConfiguration {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                AppRunnerJavaConfiguration.class
        );
        String[] names = context.getBeanDefinitionNames();
        Arrays.asList(names).forEach(System.out::println);
    }

    @Bean()
    SessionCreator sessionCreator(){
        //many op
        return new SessionCreator();
    }
}
