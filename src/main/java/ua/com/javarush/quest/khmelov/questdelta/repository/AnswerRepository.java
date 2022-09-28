package ua.com.javarush.quest.khmelov.questdelta.repository;

import ua.com.javarush.quest.khmelov.questdelta.entity.Answer;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

public class AnswerRepository extends AbstractRepository<Answer> {
    private static final AnswerRepository answerRepository = new AnswerRepository();

    private AnswerRepository() {
    }

    public static AnswerRepository get(){
        return answerRepository;
    }

    @Override
    public Collection<Answer> find(Answer template) {
        return repository.values().stream()
                .filter(entity->isCoincide(template, entity, Answer::getQuestionID)
                        &&isCoincide(template, entity, Answer::getAnswerText)
                        &&isCoincide(template, entity, Answer::getId))
                .collect(Collectors.toList());
    }
}
