package com.javarush.quest.bulimov.questdelta.repository;

import com.javarush.quest.bulimov.questdelta.entity.AbstractEntity;
import com.javarush.quest.bulimov.questdelta.entity.Answer;
import com.javarush.quest.bulimov.questdelta.entity.User;

import java.util.Collection;
import java.util.Comparator;

public class AnswerRepository extends AbstractRepository<Answer> implements Repository<Answer>{

    public static final AnswerRepository answerRepository = new AnswerRepository();

    public static AnswerRepository get(){
        return answerRepository;
    }

    public AnswerRepository(){

    }
    @Override
    public Collection<Answer> find(Answer pattern) {
        return map.values().stream()
                .filter(entity -> isOk(pattern, entity, Answer::getId)
                        && isOk(pattern, entity, Answer::getQuestionId)
                        && isOk(pattern, entity, Answer::getText)
                )
                .sorted(Comparator.comparingLong(Answer::getId))
                .toList();
    }
}
