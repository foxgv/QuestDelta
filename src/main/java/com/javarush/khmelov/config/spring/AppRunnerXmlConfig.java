package com.javarush.khmelov.config.spring;

import com.javarush.khmelov.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class AppRunnerXmlConfig {

    public static final String APPLICATION_XML = "application.xml";

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(APPLICATION_XML);
        //check beans
        String[] names = applicationContext.getBeanDefinitionNames();
        Arrays.asList(names).forEach(System.out::println);
        //one bean
        UserService userService = applicationContext.getBean(UserService.class);
        System.out.println("bean userService=" + userService);
    }
}
