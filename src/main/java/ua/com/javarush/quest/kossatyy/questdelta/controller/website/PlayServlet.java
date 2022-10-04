package ua.com.javarush.quest.kossatyy.questdelta.controller.website;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.com.javarush.quest.kossatyy.questdelta.dto.GameDto;
import ua.com.javarush.quest.kossatyy.questdelta.service.PlayService;
import ua.com.javarush.quest.kossatyy.questdelta.config.Container;
import ua.com.javarush.quest.kossatyy.questdelta.utils.Attribute;
import ua.com.javarush.quest.kossatyy.questdelta.utils.Jsp;

import java.io.IOException;
import java.util.Collection;

@WebServlet(name = "PlayServlet", value = "/play")
public class PlayServlet extends HttpServlet {

    private final PlayService playService = new PlayService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Collection<GameDto> games = playService.getAll();
        req.setAttribute(Attribute.GAMES.getValue(), games);
        Jsp.forward(req,resp, Jsp.PLAY);
    }
}
