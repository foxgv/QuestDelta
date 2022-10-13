package ua.com.javarush.quest_spring.ivanov.utils;

import org.springframework.stereotype.Component;
import ua.com.javarush.quest_spring.ivanov.entities.Question;
import ua.com.javarush.quest_spring.ivanov.services.QuestionsService;

import javax.servlet.http.HttpServletRequest;

@Component
public class QuestionsHelper {

    private final QuestionsService service;

    public QuestionsHelper(QuestionsService service) {
        this.service = service;
    }

    public String getQuestionResult(int id,
                                    String answer,
                                    GameStatsHelper statsHelper,
                                    HttpServletRequest request,
                                    Question previousQuestion,
                                    String action,
                                    String result) {
        if (id == service.getQuestions().size() + 1) {
            if (previousQuestion.getCorrectAnswer().getText().equals(answer)) {
                statsHelper.setQuantityOfCorrectAnswers(request,"add");
            }
            result = "redirect:/tasks/happy-end";
            return result;
        }

        if (action.equals("quiz")) {
            if (previousQuestion.getCorrectAnswer().getText().equals(answer)) {
                statsHelper.setQuantityOfCorrectAnswers(request,"add");
                result = "question-page";
            }
        }
        if (action.equals("quest")) {
            if (previousQuestion.getCorrectAnswer().getText().equals(answer)) {
                result = "question-page";
            } else {
                result = "redirect:/tasks/fail";
            }
        }
        return result;
    }

}
