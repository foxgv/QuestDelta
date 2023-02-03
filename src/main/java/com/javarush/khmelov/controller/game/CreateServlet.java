package com.javarush.khmelov.controller.game;

import com.javarush.khmelov.config.Winter;
import com.javarush.khmelov.dto.FormData;
import com.javarush.khmelov.dto.ui.QuestDto;
import com.javarush.khmelov.dto.ui.UserDto;
import com.javarush.khmelov.service.QuestService;
import com.javarush.khmelov.util.Go;
import com.javarush.khmelov.util.Jsp;
import com.javarush.khmelov.util.Parser;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet(value = Go.CREATE,name = "CreateServlet")
public class CreateServlet extends HttpServlet {

    private final QuestService questService = Winter.getBean(QuestService.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Optional<UserDto> user = Parser.getUser(request.getSession());
        if (user.isPresent()) {
            Jsp.forward(request, response, Go.CREATE);
        } else {
            Jsp.redirect(request, response, Go.LOGIN, "Сначала нужно войти в аккаунт");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Optional<UserDto> user = Parser.getUser(request.getSession());
        FormData formData = FormData.of(request);
        if (user.isPresent()) {
            Optional<QuestDto> questDto = questService.create(formData, user.get().getId());
            if (questDto.isPresent()){
                Jsp.redirect(request, response, Go.QUESTS);
            } else {
                Jsp.redirect(request, response, Go.CREATE,"Некорректные данные квеста");
            }
        } else {
            Jsp.redirect(request, response, Go.LOGIN,"Сначала нужно войти в аккаунт");
        }
    }
}
