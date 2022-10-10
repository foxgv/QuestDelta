package ua.com.javarush.quest.lisyanoy.entity;

import java.util.List;

public class Question {
    private final String question1 = "Ты потерял память. Принять вызов НЛО?";
    private final String question2 = "Ты принял вызов. Поднимаешься на мостик к капитану?";
    private final String question3 = "Ты поднялся на мостик. Ты кто?";

    private final List<String> questions = List.of(question1, question2,question3);


    public List<String> getQuestions() {
        return questions;
    }
}
