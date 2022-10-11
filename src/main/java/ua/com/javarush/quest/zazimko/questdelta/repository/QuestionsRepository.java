package ua.com.javarush.quest.zazimko.questdelta.repository;

import ua.com.javarush.quest.zazimko.questdelta.entity.Answer;
import ua.com.javarush.quest.zazimko.questdelta.entity.Question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ua.com.javarush.quest.zazimko.questdelta.repository.AnswerRepository.getAnswerRepository;

public class QuestionsRepository {
    private final Map<Question, List<Answer>> questionsMap;
    private static  AnswerRepository answerRepository= getAnswerRepository();
    private static  QuestionsRepository questionRepository=new QuestionsRepository();
    public QuestionsRepository() {
        questionsMap=new HashMap<>();
        questionsMap.put(Question.with().id(1L).
                text("Ты потерял память. Принять вызов НЛО?").build(),
                List.of(answerRepository.find(1L),answerRepository.find(2L)));
        questionsMap.put(Question.with().id(2L).
                text("Ты принял вызов. Поднимешься на мостик к капитану?").build(),
                List.of(answerRepository.find(3L),answerRepository.find(4L)));
        questionsMap.put(Question.with().id(3L).
                text("Ты поднялся на мостик. Ты кто?").build(),
                List.of(answerRepository.find(5L),answerRepository.find(6L)));
        questionsMap.put(Question.with().id(91L).
                        text("Ты отклонил вызов. Поражение").build(),
                new ArrayList<>());
        questionsMap.put(Question.with().id(92L).
                        text("Ты не пошел на переговоры. Поражение").build(),
                new ArrayList<>());
        questionsMap.put(Question.with().id(93L).
                        text("Твою ложь разоблачили. Поражение").build(),
                new ArrayList<>());
        questionsMap.put(Question.with().id(94L).
                        text("Тебя вернули домой. Победа").build(),
                new ArrayList<>());
    }

    public Map<Question, List<Answer>> getQuestionsMap() {
        return questionsMap;
    }
    public static QuestionsRepository getQuestionsRepository() {
        return questionRepository;
    }
}
