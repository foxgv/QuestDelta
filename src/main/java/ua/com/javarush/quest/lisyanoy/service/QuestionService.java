package ua.com.javarush.quest.lisyanoy.service;

import ua.com.javarush.quest.lisyanoy.repository.AnswerRepository;
import ua.com.javarush.quest.lisyanoy.repository.QuestionRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum QuestionService {
    INSTANCE;
    private final QuestionRepository questionRepository = new QuestionRepository();
    private final AnswerRepository answerRepository = new AnswerRepository();
    public final Map<Integer, List<String>> mapQuestionAnswers = new HashMap<>();


    public void createMapQuestionAnswers() {
        answerRepository.createAnswers();
        questionRepository.createQuestion();
        List<String> answers = new ArrayList<>();
        for (int i = 0; i < questionRepository.mapQuestions.size(); i++) {
            Integer numberQuestion = i;
            List<String> list = new ArrayList<>();
            for (int j = 0; j <= 1; j++) {
                list.add(j, answerRepository.getAnswer(j + (i * 2)));
                answers = list;
            }
            mapQuestionAnswers.put(numberQuestion, answers);
        }
    }
}


