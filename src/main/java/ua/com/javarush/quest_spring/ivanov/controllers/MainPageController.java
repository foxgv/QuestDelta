package ua.com.javarush.quest_spring.ivanov.controllers;

import ua.com.javarush.quest_spring.ivanov.entities.User;
import ua.com.javarush.quest_spring.ivanov.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class MainPageController {

    private final UserService service;

    public MainPageController(UserService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String showLoginPage(Model model) {
        model.addAttribute("user", new User());
        return "login-page";
    }

    @PostMapping(value = "/main_page")
    public String showMainPageLogIn(@Valid @ModelAttribute("user") User user,
                                    BindingResult bindingResult,
                                    @RequestParam(name = "action") String actionName,
                                    Model model) {
        //Check for valid
        if (bindingResult.hasErrors()) {
            return "login-page";
        }
        String userName = user.getUsername();

        //Check for Sigh in if user already exist
        if (actionName.equals("sigh_in") && service.isUserPresent(userName)) {
            model.addAttribute("user", new User());
            model.addAttribute("auth_error", "User already exist");
            return "login-page";
        } else if (actionName.equals("sigh_in")) {
            service.addUser(user);
            return "main-page";
        }

        //Check for Log in if user doesn't exist
        if (actionName.equals("log_in") && !service.isUserPresent(userName)) {
            model.addAttribute("user", new User());
            model.addAttribute("auth_error", "User doesn't exist");
            return "login-page";
        } else if (actionName.equals("log_in")
                && service.isUserPresent(userName)) {
            User checkedUser = service.getUserByUserName(userName);
            if (checkedUser.getPassword().equals(user.getPassword())) {
                return "main-page";
            } else {
                model.addAttribute("auth_error", "Password is wrong");
                return "login-page";
            }
        }
        return "main-page";
    }

    @GetMapping(value = "/main_page")
    public String showMainPage(){
        return "main-page";
    }
}
