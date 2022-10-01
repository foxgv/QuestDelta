package ua.com.javarush.quest.zazimko.questdelta.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import ua.com.javarush.quest.zazimko.questdelta.entity.User;
import ua.com.javarush.quest.zazimko.questdelta.repository.UserRepository;
import ua.com.javarush.quest.zazimko.questdelta.util.Jsp;
import ua.com.javarush.quest.zazimko.questdelta.util.UserService;

import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "loginServlet", value = "/login")
public class loginServlet extends HttpServlet {
    private final UserService userService=UserService.INSTANCE;
    UserRepository userRepository= UserRepository.getUserRepository();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Jsp.forward(request,response,"login");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        Optional<User> optionalUser = userService.find(login, password);
        if(optionalUser.isPresent()){
            HttpSession session = request.getSession();
            User user = optionalUser.get();
            session.setAttribute("user", user);
            session.setAttribute("UserId",user.getId());
            Jsp.redirect(request,response,"profile");

        }else {
            request.setAttribute("error", "User not found");
        }
    }
}
