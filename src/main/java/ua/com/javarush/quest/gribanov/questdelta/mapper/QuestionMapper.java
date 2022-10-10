package ua.com.javarush.quest.gribanov.questdelta.mapper;

import ua.com.javarush.quest.gribanov.questdelta.entity.AbstractEntity;

import java.util.Optional;

public class QuestionMapper implements Mapper {
    @Override
    public Optional get(AbstractEntity entity) {
        return Optional.empty();
    }
}
