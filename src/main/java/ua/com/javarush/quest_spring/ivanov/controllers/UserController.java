package ua.com.javarush.quest_spring.ivanov.controllers;

import ua.com.javarush.quest_spring.ivanov.services.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }




}
