package ua.com.javarush.quest.gribanov.questdelta.mapper;

import ua.com.javarush.quest.gribanov.questdelta.dto.ClientData;
import ua.com.javarush.quest.gribanov.questdelta.dto.QuestionDTO;
import ua.com.javarush.quest.gribanov.questdelta.entity.AbstractEntity;
import ua.com.javarush.quest.gribanov.questdelta.entity.Question;

import java.util.Optional;

public class QuestionMapper implements Mapper<Question, QuestionDTO> {
    @Override
    public Optional<QuestionDTO> get(Question question) {
        return question != null ? Optional.of(QuestionDTO.builder()
                .id(question.getId())
                .questionText(question.getQuestionText())
                .questID(question.getQuestID())
                .isALast(question.isALast())
                .image(question.getImage())
                .build())
                :Optional.empty();
    }

    @Override
    public Question create(ClientData data) {
        return null;
    }
}
