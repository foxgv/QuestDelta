package ua.com.javarush.quest_spring.ivanov.utils;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import ua.com.javarush.quest_spring.ivanov.entities.User;
import ua.com.javarush.quest_spring.ivanov.services.UserService;

import javax.servlet.http.HttpServletRequest;

@Component
public class LoginActionValidator {

    private final UserService service;

    public LoginActionValidator(UserService service) {
        this.service = service;
    }

    public String getSighInValidationResult(User user, HttpServletRequest request, Model model, String result) {
        if (service.isUserPresent(user.getUsername())) {
            model.addAttribute("auth_error", "User already exist");
            result = "login-page";
        } else {
            service.addUser(user);
            request.getSession().setAttribute("user", service.getUserByUserName(user.getUsername()));
        }
        return result;
    }

    public String getLogInValidationResult(User user, HttpServletRequest request, Model model, String result) {
        String userName = user.getUsername();
        if (!service.isUserPresent(userName)) {
            model.addAttribute("auth_error", "User doesn't exist");
            result = "login-page";
        } else {
            User checkedUser = service.getUserByUserName(userName);
            if (checkedUser.getPassword().equals(user.getPassword())) {
                request.getSession().setAttribute("user", checkedUser);
            } else {
                model.addAttribute("auth_error", "Password is wrong");
                result = "login-page";
            }
        }
        return result;
    }

}
