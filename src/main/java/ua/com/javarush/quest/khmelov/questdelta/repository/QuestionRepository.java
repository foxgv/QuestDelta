package ua.com.javarush.quest.khmelov.questdelta.repository;

import ua.com.javarush.quest.khmelov.questdelta.entity.Question;

import java.util.Collection;
import java.util.stream.Collectors;

public class QuestionRepository extends AbstractRepository<Question> {

    private static final QuestionRepository questionRepository = new QuestionRepository();
    public static QuestionRepository get(){
        return questionRepository;
    }
    private QuestionRepository(){

    }
    @Override
    public Collection<Question> find(Question template) {
        return repository.values().stream()
                .filter(entity->isCoincide(template, entity, Question::getId)
                        &&isCoincide(template, entity, Question::getQuestID)
                        &&isCoincide(template, entity, Question::getQuestionText)
                        &&isCoincide(template, entity, Question::getAnswers)
                        &&isCoincide(template, entity, Question::isALast))
                .collect(Collectors.toList());
    }
}
