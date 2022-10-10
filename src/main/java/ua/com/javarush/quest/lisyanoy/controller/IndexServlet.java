package ua.com.javarush.quest.lisyanoy.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "IndexServlet", value = "/IndexServlet")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String firstName = request.getParameter("firstName");
        HttpSession session = request.getSession(true);
        if (!Objects.equals(firstName, "") && firstName != null) {
            session.setAttribute("name", firstName);
        }
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }

}
