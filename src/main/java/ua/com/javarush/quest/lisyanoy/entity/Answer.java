package ua.com.javarush.quest.lisyanoy.entity;

import java.util.List;

public class Answer {
    private final String answer1 = "Принять вызов";
    private final String answer2 = "Отклонить вызов";
    private final String answer3 = "Подняться на мостик";
    private final String answer4 = "Отказаться подниматься на мостик";
    private final String answer5 = "Рассказать правду о себе";
    private final String answer6 = "Солгать о себе";

    private final List<String> answers = List.of(answer1, answer2, answer3, answer4, answer5, answer6);

    public List<String> getAnswers() {
        return answers;
    }
}
