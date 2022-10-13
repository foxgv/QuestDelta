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
    UserRepository userRepository= UserRepository.getUserRepository();
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        UserRole role = UserRole.valueOf(request.getParameter("role"));
        User user =new User(login,password,role);
        postUser(request,user);
        Jsp.redirect(request,response,"users");
    }

    private void postUser(HttpServletRequest request, User user) {
        if(request.getParameter("update")!=null){
            userRepository.update(user);
        } else if (request.getParameter("delete")!=null) {
            userRepository.delete(user);
        } else if (request.getParameter("create")!=null) {
            userRepository.create(user);
        }else {
            throw new UnsupportedOperationException("not found command");
        }
    }
}
