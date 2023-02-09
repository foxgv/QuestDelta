package com.javarush.khmelov.controller;

import com.javarush.khmelov.config.Winter;
import com.javarush.khmelov.service.InitService;
import com.javarush.khmelov.service.UserService;
import com.javarush.khmelov.util.Go;
import com.javarush.khmelov.util.Jsp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(value = Go.STAT, name = "StatServlet")
public class StatServlet extends HttpServlet {

    UserService userService = Winter.getBean(UserService.class);
    InitService initService = Winter.getBean(InitService.class);


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("statistics", userService.getStat());
        Jsp.forward(request,response,Go.STAT);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        initService.save();
        Jsp.redirect(request,response,Go.STAT,"Сохранено: "+ LocalDateTime.now());
    }
}
