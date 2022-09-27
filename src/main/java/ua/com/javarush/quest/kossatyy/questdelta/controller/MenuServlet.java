package ua.com.javarush.quest.kossatyy.questdelta.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ua.com.javarush.quest.kossatyy.questdelta.entity.Role;
import ua.com.javarush.quest.kossatyy.questdelta.utils.Attribute;
import ua.com.javarush.quest.kossatyy.questdelta.utils.Jsp;

import java.io.IOException;

import static java.util.Objects.isNull;

@WebServlet(name = "MenuServlet", value = "/menu")
public class MenuServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String roleAttribute = Attribute.ROLE.getValue();
        Object role = session.getAttribute(roleAttribute);
        if (isNull(role)) {
            session.setAttribute(roleAttribute, Role.GUEST);
        } else {
            session.setAttribute(roleAttribute, role);
        }
        Jsp.forward(req, resp, Jsp.MENU);
    }
}
