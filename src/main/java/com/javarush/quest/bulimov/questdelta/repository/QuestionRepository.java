package com.javarush.quest.bulimov.questdelta.repository;

import com.javarush.quest.bulimov.questdelta.entity.AbstractEntity;
import com.javarush.quest.bulimov.questdelta.entity.Answer;
import com.javarush.quest.bulimov.questdelta.entity.Game;
import com.javarush.quest.bulimov.questdelta.entity.Question;

import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Stream;

public class QuestionRepository extends AbstractRepository<Question> implements Repository<Question> {

    public static final QuestionRepository questionRepository = new QuestionRepository();

    public static QuestionRepository get(){
        return questionRepository;
    }

    public QuestionRepository(){

    }
    @Override
    public Stream<Question> find(Question pattern) {
        return map.values().stream()
                .filter(entity -> isOk(pattern, entity, Question::getId)
                        && isOk(pattern, entity, Question::getQuestId)
                        && isOk(pattern, entity, Question::getText)
                        && isOk(pattern, entity, Question::getAnswers)
                )
                .sorted(Comparator.comparingLong(Question::getId));
    }
}
