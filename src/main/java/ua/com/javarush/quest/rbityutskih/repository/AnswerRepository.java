package ua.com.javarush.quest.rbityutskih.repository;

import ua.com.javarush.quest.rbityutskih.entity.Answer;

import java.util.Comparator;
import java.util.stream.Stream;

public class AnswerRepository extends AbstractRepository<Answer> implements Repository<Answer> {
    private static final AnswerRepository answerRepository = new AnswerRepository();

    public static AnswerRepository get(){
        return answerRepository;
    }

    public AnswerRepository(){

    }
    @Override
    public Stream<Answer> find(Answer pattern) {
        return map.values().stream()
                .filter(entity -> isOk(pattern, entity, Answer::getId)
                        && isOk(pattern, entity, Answer::getQuestionId)
                        && isOk(pattern, entity, Answer::getText)
                )
                .sorted(Comparator.comparingLong(Answer::getId));
    }
}

