package ua.com.javarush.quest.ryabov.questdelta.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.com.javarush.quest.ryabov.questdelta.util.Jsp;

import java.io.IOException;

@WebServlet("/stats")
public class StatsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String back = req.getParameter("back");
        if (back != null && back.equals("back")) {
            Jsp.redirect(resp, "/");
        }else {
            Jsp.forward(req, resp, "stats");
        }
    }
}
