package com.javarush.khmelov.mapping;

import com.javarush.khmelov.dto.FormData;
import com.javarush.khmelov.dto.ui.QuestionDto;
import com.javarush.khmelov.entity.Question;

import java.util.Optional;

/**
 * Class package-private. Use only <code>interface Mapper</code>
 */
class QuestionMapper implements Mapper<Question, QuestionDto> {

    @Override
    public Optional<QuestionDto> get(Question question) {
        return question != null
                ? Optional.of(QuestionDto.builder()
                .id(question.getId())
                //.quest(question.getQuest().getId())
                .image(question.getImage())
                .text(question.getText())
                .answers(question.getAnswers().stream()
                        .map(Mapper.answer::get)
                        .map(Optional::orElseThrow)
                        .toList()
                )
                .build()
        ) : Optional.empty();
    }

    @Override
    public Question parse(FormData formData) {
        Question quest = Question.builder().build();
        return fill(quest, formData);
    }
}
