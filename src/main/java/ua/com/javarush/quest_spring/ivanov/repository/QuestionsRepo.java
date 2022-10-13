package ua.com.javarush.quest_spring.ivanov.repository;

import ua.com.javarush.quest_spring.ivanov.entities.Question;

import java.util.HashMap;

public interface QuestionsRepo {

    HashMap<Integer, Question> getQuestions();

    Question getQuestionById(int id);

    void fillQuestions(String pathQuestions, String pathAnswers);
}
