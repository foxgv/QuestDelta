package ua.com.javarush.quest.lisyanoy.repository;

import ua.com.javarush.quest.lisyanoy.entity.Question;

import java.util.HashMap;
import java.util.Map;

public class QuestionRepository {

    Question questions = new Question();
    public final Map<Integer, String> mapQuestions = new HashMap<>();


    public void createQuestion() {
        for (int i = 0; i < questions.getQuestions().size(); i++) {
            mapQuestions.put(i, questions.getQuestions().get(i));
        }
    }
}
