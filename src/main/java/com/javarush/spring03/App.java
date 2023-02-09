package com.javarush.spring03;

import com.javarush.spring03.config.AppConfig;
import com.javarush.spring03.service.CustomerService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static final String BASE_PACKAGE = App.class.getPackageName();

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        for (String definitionName : context.getBeanDefinitionNames()) {
            System.out.println(definitionName);
        }
        CustomerService customerService = context.getBean(CustomerService.class);
        Long id = 1L;
        System.out.println(customerService.getById(id));

        customerService.setPasswordFirst(id, "tmpPass");
        System.out.println(customerService.getById(id));
        customerService.setPasswordFirst(id, "456");
        for (int i = 0; i < 2; i++) {
            System.out.println(customerService.getById(id));
        }
    }
}
