package ua.com.javarush.quest.zazimko.questdelta.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ua.com.javarush.quest.zazimko.questdelta.entity.User;
import ua.com.javarush.quest.zazimko.questdelta.util.Jsp;
import ua.com.javarush.quest.zazimko.questdelta.util.UserService;

import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "loginServlet", value = "/login")
public class loginServlet extends HttpServlet {
    private final UserService userService=UserService.INSTANCE;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Jsp.forward(request,response,"login");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
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
            Jsp.forward(request,response,"login","Нет такого пользователя!");
        }
    }
}
