package ru.javarush.volokitin.questdelta.mapper;

import ru.javarush.volokitin.questdelta.dto.QuestionDTO;
import ru.javarush.volokitin.questdelta.entity.Question;

public class QuestionMapper {

    public static QuestionDTO get(Question question) {
        return QuestionDTO.with()
                .id(question.getId())
                .text(question.getText())
                .answers(question.getAnswers())
                .get();
    }
}
