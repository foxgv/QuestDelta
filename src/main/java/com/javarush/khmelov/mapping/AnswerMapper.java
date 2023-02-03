package com.javarush.khmelov.mapping;

import com.javarush.khmelov.dto.FormData;
import com.javarush.khmelov.dto.ui.AnswerDto;
import com.javarush.khmelov.entity.Answer;

import java.util.Optional;

/**
 * Class package-private. Use only <code>interface Mapper</code>
 */
class AnswerMapper implements Mapper<Answer, AnswerDto> {

    @Override
    public Optional<AnswerDto> get(Answer answer) {
        return answer != null
                ? Optional.of(AnswerDto.builder()
                .id(answer.getId())
                .text(answer.getText())
                .nextQuestionId(answer.getNextQuestionId())
                .build()
        ) : Optional.empty();
    }


    @Override
    public Answer parse(FormData formData) {
        Answer quest = Answer.builder().build();
        return fill(quest, formData);
    }
}
