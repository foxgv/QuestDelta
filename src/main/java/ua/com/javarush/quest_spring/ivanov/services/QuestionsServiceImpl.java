package ua.com.javarush.quest_spring.ivanov.services;

import org.springframework.stereotype.Service;
import ua.com.javarush.quest_spring.ivanov.entities.Question;
import ua.com.javarush.quest_spring.ivanov.repository.QuestionsRepo;

import java.util.HashMap;

@Service
public class QuestionsServiceImpl implements QuestionsService {

    private final QuestionsRepo repo;

    public QuestionsServiceImpl(QuestionsRepo repo) {
        this.repo = repo;
    }

    @Override
    public HashMap<Integer, Question> getQuestions() {
        return repo.getQuestions();
    }

    @Override
    public Question getQuestionById(int id) {
        return repo.getQuestionById(id);
    }

    @Override
    public void fillQuestions(String pathQuestions, String pathAnswers) {
        repo.fillQuestions(pathQuestions,pathAnswers);
    }
}
