package ua.com.javarush.quest_spring.ivanov.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ua.com.javarush.quest_spring.ivanov.entities.User;
import ua.com.javarush.quest_spring.ivanov.services.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

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

    @PostMapping("/delete")
    public String showDeletePage(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        service.deleteUserById(user.getId());
        request.getSession().setAttribute("user", null);
        return "delete-page";
    }

    @PostMapping("/success_change")
    public String showSuccessChangesPage(@Valid @ModelAttribute User user,
                                         BindingResult bindingResult,
                                         HttpServletRequest request) {

        if (bindingResult.hasErrors()) {
            return "profile-page";
        }
        service.updateUser(user);
        request.getSession().setAttribute("user", user);
        return "successfully-changed-page";
    }

}
