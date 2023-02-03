package com.javarush.khmelov.controller.user;

import com.javarush.khmelov.config.Winter;
import com.javarush.khmelov.entity.Role;
import com.javarush.khmelov.service.UserService;
import com.javarush.khmelov.util.Go;
import com.javarush.khmelov.util.Jsp;
import com.javarush.khmelov.util.Parser;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@MultipartConfig(fileSizeThreshold = 1 << 20)
@WebServlet(value = Go.PROFILE,name = "ProfileServlet")
public class ProfileServlet extends HttpServlet {

    private final UserService userService = Winter.getBean(UserService.class);

    @Override
    public void init() {
        getServletContext().setAttribute("roles", Role.values());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Parser.getId(req.getSession());
        userService
                .get(id)
                .ifPresent(value -> req.setAttribute(Jsp.Key.USER, value));
        Jsp.forward(req, resp, Go.PROFILE);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        if (EditUserServlet.checkProfileEditor(req)) {
            Jsp.redirect(req, resp, Go.EDIT_USER + "?id=" + Parser.getId(req));
        } else {
            Jsp.forward(req, resp, Go.PROFILE, "Недостаточно прав для редактирования");
        }
    }

}
