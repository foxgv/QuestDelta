package ua.com.javarush.quest.zazimko.questdelta.repository;

import ua.com.javarush.quest.zazimko.questdelta.entity.Answer;
import ua.com.javarush.quest.zazimko.questdelta.entity.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AnswerRepository {
    private static  List<Answer> answers = new ArrayList<>();
    private static  AnswerRepository answerRepository = new AnswerRepository();

    public AnswerRepository() {
        answers.add(Answer.with().text("Принять вызов").id(1L).nextQuestionId(2L).build());
        answers.add(Answer.with().text("Отклонить вызов").id(2L).nextQuestionId(91L).build());
        answers.add(Answer.with().text("Поднятья на мостик").id(3L).nextQuestionId(3L).build());
        answers.add(Answer.with().text("Отказаться подниматься на мостик").id(4L).nextQuestionId(92L).build());
        answers.add(Answer.with().text("Рассказать правду о себе").id(5L).nextQuestionId(94L).build());
        answers.add(Answer.with().text("Солгать о себе").id(6L).nextQuestionId(93L).build());
    }

    public static AnswerRepository getAnswerRepository() {
        return answerRepository;
    }

    public Answer find(Long id) {
        for (Answer answer : answers) {
            if (answer.getId() == id) {
                return answer;
            }
        }
        return null;
    }
}