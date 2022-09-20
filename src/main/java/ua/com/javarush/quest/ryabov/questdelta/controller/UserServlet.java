package ua.com.javarush.quest.ryabov.questdelta.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import ua.com.javarush.quest.ryabov.questdelta.entity.Role;
import ua.com.javarush.quest.ryabov.questdelta.entity.User;
import ua.com.javarush.quest.ryabov.questdelta.service.AvatarService;
import ua.com.javarush.quest.ryabov.questdelta.service.UserService;
import ua.com.javarush.quest.ryabov.questdelta.util.Jsp;

import java.io.IOException;
import java.io.Serial;
import java.util.Optional;

@MultipartConfig(fileSizeThreshold = 1 << 20)
@WebServlet({"/user","/profile", "/signup"})
public class UserServlet extends HttpServlet {

    @Serial
    private static final long serialVersionUID = 6978028341247457550L;
    private final UserService userService = UserService.INSTANCE;
    private final AvatarService avatarService = AvatarService.INSTANCE;

    @Override
    public void init() {
        getServletContext().setAttribute("roles", Role.values());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = getId(req);
        Optional<User> opUser = userService.get(id);
        opUser.ifPresent(value -> req.setAttribute("user", value));
        Jsp.forward(req, resp, "user");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        long id = getId(req);
        Part data = req.getPart("image");
        String image = "avatar-" + id;
        avatarService.uploadAvatar(image, data.getInputStream());
        User user = User.with()
                .id(id)
                .login(req.getParameter("login"))
                .password(req.getParameter("password"))
                .image(image)
                .role(Role.valueOf(req.getParameter("role")))
                .get();
        postUser(req, user);
        Jsp.redirect(resp, "users");
    }

    private void postUser(HttpServletRequest req, User user) {
        boolean present = userService.get(user.getId()).isPresent();
        if (present && req.getParameter("update") != null) {
            userService.update(user);
        } else if (present && req.getParameter("delete") != null) {
            userService.delete(user);
        } else if (!present && req.getParameter("create") != null) {
            userService.create(user);
        } else {
            throw new UnsupportedOperationException("not found cmd");
        }
    }

    private long getId(HttpServletRequest req) {
        return req.getParameter("id") != null
                ? Long.parseLong("0" + req.getParameter("id"))
                : 0L;
    }

}
