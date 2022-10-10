package ua.com.javarush.quest.lisyanoy.repository;

import ua.com.javarush.quest.lisyanoy.entity.Answer;

import java.util.HashMap;
import java.util.Map;

public class AnswerRepository {
    Answer answers = new Answer();
    public final Map<Integer, String> mapAnswers = new HashMap<>();

    public void createAnswers() {
        for (int i = 0; i < answers.getAnswers().size(); i++) {
            mapAnswers.put(i, answers.getAnswers().get(i));
        }
    }

    public String getAnswer(Integer number) {
        return mapAnswers.get(number);
    }
}
