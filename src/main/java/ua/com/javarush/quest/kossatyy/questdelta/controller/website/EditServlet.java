package ua.com.javarush.quest.kossatyy.questdelta.controller.website;

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

@WebServlet(name = "EditServlet", value = "/edit")
public class EditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Jsp.forward(req, resp, Jsp.EDIT);
    }
}
