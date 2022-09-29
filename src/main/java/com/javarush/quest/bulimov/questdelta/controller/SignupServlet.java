package com.javarush.quest.bulimov.questdelta.controller;

import com.javarush.quest.bulimov.questdelta.dto.FormData;
import com.javarush.quest.bulimov.questdelta.services.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(name = "SignupServlet", value = "/signup")
public class SignupServlet extends HttpServlet {

    private final UserService userService = UserService.INSTANCE;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FormData data = FormData.of(req);
        if(userService.find(data).isEmpty()){
            doPost(req, resp);
        }

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        userService.create(FormData.of(req));
        getServletContext().getRequestDispatcher("/hello-servlet").forward(req, resp);
    }
}
