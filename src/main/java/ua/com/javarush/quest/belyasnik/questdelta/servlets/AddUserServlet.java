package ua.com.javarush.quest.belyasnik.questdelta.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import ua.com.javarush.quest.belyasnik.questdelta.entities.User;
import ua.com.javarush.quest.belyasnik.questdelta.repository.UserRepository;
import ua.com.javarush.quest.belyasnik.questdelta.util.Go;
import ua.com.javarush.quest.belyasnik.questdelta.util.Ids;
import ua.com.javarush.quest.belyasnik.questdelta.util.Jsp;

import javax.swing.text.html.Option;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AddUserServlet", value = Go.ADDUSER)
public class AddUserServlet extends HttpServlet {
    User user;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("title", Go.AddUserTitle);
        Jsp.show(request, response, Go.ADDUSER);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        User user = User.builder()
                .id(++Ids.userId)
                .login(login)
                .password(password)
                .build();
        UserRepository users = UserRepository.getInstance();
        users.add(user);

        HttpSession session = request.getSession();
        session.setAttribute("userId", user.getId()); // запомнить пользователя в сессии
        session.setAttribute("login", login);
        request.setAttribute("login", login);

        doGet(request, response);
    }
}
