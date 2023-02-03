package com.javarush.khmelov.controller.user;

import com.javarush.khmelov.config.Winter;
import com.javarush.khmelov.dto.FormData;
import com.javarush.khmelov.dto.ui.UserDto;
import com.javarush.khmelov.entity.Role;
import com.javarush.khmelov.service.ImageService;
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
import java.util.Optional;

@MultipartConfig(fileSizeThreshold = 1 << 20)
@WebServlet(value = Go.SIGNUP,name = "SignupServlet")
public class SignupServlet extends HttpServlet {



    private final UserService userService = Winter.getBean(UserService.class);
    private final ImageService imageService = Winter.getBean(ImageService.class);

    @Override
    public void init() {
        getServletContext().setAttribute(Jsp.Key.ROLES, Role.values());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Parser.getId(req);
        Optional<UserDto> opUser = userService.get(id);
        opUser.ifPresent(value -> req.setAttribute("user", value));
        Jsp.forward(req, resp, Go.SIGNUP);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Optional<UserDto> userDto = userService.create(FormData.of(req));
        if (userDto.isPresent()) {
            imageService.uploadImage(req, userDto.get().getImage());
        }
        Jsp.redirect(req, resp, Go.USERS);
    }

}
