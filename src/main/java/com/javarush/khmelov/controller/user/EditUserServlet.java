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
@WebServlet(value = Go.EDIT_USER, name = "EditUserServlet")
public class EditUserServlet extends HttpServlet {

    private final UserService userService = Winter.getBean(UserService.class);
    private final ImageService imageService = Winter.getBean(ImageService.class);

    private static boolean checkEditorInSession(HttpServletRequest req) {
        long id = Parser.getId(req);
        Optional<UserDto> editor = Parser.getUser(req.getSession());
        return editor.isPresent() &&
                (editor.get().getId() == id || editor.get().getRole() == Role.ADMIN);
    }

    static boolean checkProfileEditor(HttpServletRequest req) {
        long id = Parser.getId(req);
        Optional<UserDto> editor = Parser.getUser(req.getSession());
        return editor.isPresent() && (editor.get().getId() == id);
    }

    @Override
    public void init() {
        getServletContext().setAttribute(Jsp.Key.ROLES, Role.values());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (checkEditorInSession(req)) {
            long id = Parser.getId(req);
            Optional<UserDto> user = userService.get(id);
            user.ifPresent(value -> req.setAttribute(Jsp.Key.USER, value));
            Jsp.forward(req, resp, Go.EDIT_USER);
        } else {
            req.setAttribute(Jsp.Key.USERS, userService.getAll());
            Jsp.forward(req, resp, Go.USERS, "Недостаточно прав для редактирования");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        FormData formData = FormData.of(req);
        final String DEST = checkProfileEditor(req) ? Go.PROFILE : Go.USERS;
        if (checkEditorInSession(req)) {
            if (req.getParameter("update") != null) {
                Optional<UserDto> userDto = userService.update(formData);
                if (userDto.isPresent()) {
                    Jsp.im(req, userDto.get().getImage(), imageService);
                }
            } else if (req.getParameter("delete") != null) {
                userService.delete(formData);
            }
            Jsp.redirect(req, resp, DEST);
        } else {
            Jsp.forward(req, resp, DEST, "Недостаточно прав для редактирования");
        }
    }
}
