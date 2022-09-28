package ua.com.javarush.quest.zazimko.questdelta.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.com.javarush.quest.zazimko.questdelta.entity.User;
import ua.com.javarush.quest.zazimko.questdelta.repository.UserRepository;
import ua.com.javarush.quest.zazimko.questdelta.util.Jsp;
import ua.com.javarush.quest.zazimko.questdelta.util.UserRole;

import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "UserServlet", value = "/user")
public class UserServlet extends HttpServlet {
    UserRepository userRepository=new UserRepository();
    public void init(){
        getServletContext().setAttribute("roles", UserRole.values());
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      Optional<String> stringId = Optional.ofNullable(request.getParameter("id"));
      if(stringId.isPresent()){
          long id = Long.parseLong(stringId.get());
          Optional <User> user = Optional.ofNullable(userRepository.getUser(id));
          user.ifPresent(value -> request.setAttribute("user", value));
      }
        Jsp.forward(request,response,"user");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
