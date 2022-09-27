package com.javarush.quest.bulimov.questdelta.controller;

import com.javarush.quest.bulimov.questdelta.services.UserService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(name = "signupServlet", value = "/signup")
public class SignupServlet extends HttpServlet {

    private final UserService userService = UserService.INSTANCE;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{

    }
}
