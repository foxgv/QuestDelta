package com.javarush.khmelov.controller.game;

import com.javarush.khmelov.config.Winter;
import com.javarush.khmelov.service.QuestService;
import com.javarush.khmelov.util.Go;
import com.javarush.khmelov.util.Jsp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(value = {Go.HOME, Go.QUESTS},name = "QuestsServlet")
public class QuestsServlet extends HttpServlet {

    private final QuestService questService = Winter.getBean(QuestService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute(Jsp.Key.QUESTS, questService.getAll());
        Jsp.forward(req, resp, Go.QUESTS);
    }
}
