package com.javarush.khmelov.controller.game;

import com.javarush.khmelov.config.Winter;
import com.javarush.khmelov.dto.FormData;
import com.javarush.khmelov.dto.ui.QuestDto;
import com.javarush.khmelov.dto.ui.QuestionDto;
import com.javarush.khmelov.dto.ui.UserDto;
import com.javarush.khmelov.entity.Role;
import com.javarush.khmelov.service.ImageService;
import com.javarush.khmelov.service.QuestService;
import com.javarush.khmelov.service.QuestionService;
import com.javarush.khmelov.util.Go;
import com.javarush.khmelov.util.Jsp;
import com.javarush.khmelov.util.Parser;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@MultipartConfig(fileSizeThreshold = 1 << 20)
@WebServlet(value = {Go.QUEST}, name = "QuestServlet")
public class QuestServlet extends HttpServlet {

    private final QuestService questService = Winter.getBean(QuestService.class);
    private final QuestionService questionService = Winter.getBean(QuestionService.class);
    private final ImageService imageService = Winter.getBean(ImageService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Parser.getId(req);
        Optional<QuestDto> questDto = questService.get(id);
        req.setAttribute(Jsp.Key.QUEST, questDto.orElseThrow());
        Jsp.forward(req, resp, Go.QUEST);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        FormData formData = FormData.of(req);
        Optional<UserDto> editor = Parser.getUser(req.getSession());
        if (editor.isPresent() && editor.get().getRole() == Role.ADMIN) {
            Long id = Parser.getId(req);
            Long idQuest = Parser.getId(req, "idQuest");
            Optional<QuestionDto> questionDto = questionService.update(formData);
            if (questionDto.isPresent()) {
                Jsp.im(req, questionDto.get().getImage(), imageService);
            }
            String uri = "%s?id=%d#q%d".formatted(Go.QUEST, idQuest, id);
            Jsp.redirect(req, resp, uri);
        } else {
            Jsp.forward(req, resp, Go.QUEST, "Недостаточно прав для редактирования");
        }
    }
}
