package ua.com.javarush.quest_spring.ivanov.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ua.com.javarush.quest_spring.ivanov.entities.User;
import ua.com.javarush.quest_spring.ivanov.utils.LoginActionValidator;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@ControllerAdvice
public class LoginController {


    private final LoginActionValidator loginActionValidator;

    public LoginController(LoginActionValidator loginActionValidator) {
        this.loginActionValidator = loginActionValidator;
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
                                    HttpServletRequest request,
                                    Model model) {
        //Check for valid fields
        if (bindingResult.hasErrors()) {
            return "login-page";
        }
        String result = "main-page";
        //Check for Sigh in if user already exist
        if (actionName.equals("sigh_in")) {
            result = loginActionValidator.getSighInValidationResult(user, request, model, result);
        } else {
            //Check for Log in if user doesn't exist
            result = loginActionValidator.getLogInValidationResult(user, request, model, result);
        }
        return result;
    }


    @GetMapping(value = "/main_page")
    public String showMainPage() {
        return "main-page";
    }
}
