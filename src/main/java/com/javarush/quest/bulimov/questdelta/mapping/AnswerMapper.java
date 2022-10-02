package com.javarush.quest.bulimov.questdelta.mapping;

import com.javarush.quest.bulimov.questdelta.dto.AnswerDto;
import com.javarush.quest.bulimov.questdelta.dto.FormData;
import com.javarush.quest.bulimov.questdelta.dto.QuestionDto;
import com.javarush.quest.bulimov.questdelta.entity.Answer;
import com.javarush.quest.bulimov.questdelta.entity.Question;

import java.util.Optional;

public class AnswerMapper implements Mapper<Answer, AnswerDto>{
    @Override
    public Optional<AnswerDto> get(Answer answer) {
        return answer != null
                ? Optional.of(AnswerDto.with()
                        .id(answer.getId())
                        .questionId(answer.getQuestionId())
                        .correct(answer.getCorrect())
                        .nextQuestionId(answer.getNextQuestionId())
                        .text(answer.getText())

                .build()
        ) : Optional.empty();
    }

    @Override
    public Answer parse(FormData formData) {
        Answer answer = Answer.with().build();
        return fill(answer, formData);
    }
}
