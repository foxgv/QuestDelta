package com.javarush.khmelov.config.spring;

import com.javarush.khmelov.repository.SessionCreator;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

import java.util.Arrays;

@Configuration
@ComponentScan("com.javarush.khmelov")
public class AppRunnerJavaConfiguration {


    public static final String REPO = "com.javarush.khmelov.repository.impl";
    public static final String SERVICES = "com.javarush.khmelov.service";

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppRunnerJavaConfiguration.class);
        String[] names = context.getBeanDefinitionNames();
        Arrays.asList(names).forEach(System.out::println);
    }

    @Bean()
    SessionCreator sessionCreator(){
        //many op
        return new SessionCreator();
    }
}
