package ua.com.javarush.quest_spring.ivanov.repository;

import ua.com.javarush.quest_spring.ivanov.entities.Question;
import ua.com.javarush.quest_spring.ivanov.utils.SourceLoader;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class QuestionsRepoImpl implements QuestionsRepo {


    private HashMap<Integer, Question> questions;
    private final SourceLoader sourceLoader;

    public QuestionsRepoImpl(SourceLoader sourceLoader) {
        this.sourceLoader = sourceLoader;
    }

    @Override
    public HashMap<Integer, Question> getQuestions() {
        return questions;
    }

    @Override
    public Question getQuestionById(int id) {
        return questions.get(id);
    }

    public void fillQuestions(String pathQuestions, String pathAnswers) {
        questions = new HashMap<>();
        for (int i = 1; i < sourceLoader.getQuantityOfQuestions(pathQuestions) + 1; i++) {
            sourceLoader.setVariables(i,pathQuestions,pathAnswers);
            if (!sourceLoader.hasError()) {
                questions.put(i, sourceLoader.build());
            }
        }
    }

}
