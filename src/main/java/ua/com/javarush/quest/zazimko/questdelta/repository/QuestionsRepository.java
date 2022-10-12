package ua.com.javarush.quest.zazimko.questdelta.repository;

import ua.com.javarush.quest.zazimko.questdelta.entity.Question;

import java.util.ArrayList;
import java.util.List;

import static ua.com.javarush.quest.zazimko.questdelta.repository.AnswerRepository.getAnswerRepository;

public class QuestionsRepository {
    private final List<Question> questionList;
    private static final AnswerRepository answerRepository= getAnswerRepository();
    private static final QuestionsRepository questionRepository=new QuestionsRepository();
    public QuestionsRepository() {
        questionList =new ArrayList<>();
        questionList.add(Question.with().id(1L).
                text("Ты потерял память. Принять вызов НЛО?").answers(List.of(answerRepository.find(1L),
                                answerRepository.find(2L))).build());
        questionList.add(Question.with().id(2L).
                text("Ты принял вызов. Поднимешься на мостик к капитану?").answers(
                List.of(answerRepository.find(3L),answerRepository.find(4L))).build());
        questionList.add(Question.with().id(3L).
                text("Ты поднялся на мостик. Ты кто?").answers(List.of(answerRepository.find(5L),
                        answerRepository.find(6L))).build());
        questionList.add(Question.with().id(91L).
                        text("Ты отклонил вызов. Поражение").answers(
                new ArrayList<>()).build());
        questionList.add(Question.with().id(92L).
                        text("Ты не пошел на переговоры. Поражение").answers(
                new ArrayList<>()).build());
        questionList.add(Question.with().id(93L).
                        text("Твою ложь разоблачили. Поражение").answers(
                new ArrayList<>()).build());
        questionList.add(Question.with().id(94L).
                        text("Тебя вернули домой. Победа").answers(
                new ArrayList<>()).build());
    }

    public List<Question> getQuestionList() {
        return questionList;
    }
    public Question findQuestion(Long id){
        for (Question question : questionList) {
            if(question.getId().equals(id)){
                return question;
            }
        }
        return null;
    }
    public static QuestionsRepository getQuestionsRepository() {
        return questionRepository;
    }

}
