package ua.com.javarush.quest_spring.ivanov.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.com.javarush.quest_spring.ivanov.entities.User;
import ua.com.javarush.quest_spring.ivanov.services.UserService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }


    @GetMapping("/profile")
    public String showProfilePage(HttpServletRequest request, Model model) {
        User user = (User) request.getSession().getAttribute("user");
        model.addAttribute("user", user);
        return "profile-page";
    }

    @GetMapping("/delete")
    public String showDeletePage() {
        return "delete-page";
    }

    @GetMapping("/successChange")
    public String showSuccessChangesPage() {
        return "successfully-changed-page";
    }

}
