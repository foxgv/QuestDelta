package com.javarush.quest.bulimov.questdelta.mapping;

import com.javarush.quest.bulimov.questdelta.dto.FormData;
import com.javarush.quest.bulimov.questdelta.dto.GameDto;
import com.javarush.quest.bulimov.questdelta.dto.QuestionDto;
import com.javarush.quest.bulimov.questdelta.entity.Game;
import com.javarush.quest.bulimov.questdelta.entity.Question;

import java.util.Optional;

public class QuestionMapper implements Mapper<Question, QuestionDto>{
    @Override
    public Optional<QuestionDto> get(Question question) {
        return question != null
                ? Optional.of(QuestionDto.with()
                        .id(question.getId())
                        .text(question.getText())
                        .questId(question.getQuestId())
                        .answers(question.getAnswers().stream().map(Mapper.answer::get).toList().stream().map(Optional::get).toList())
                .build()
        ) : Optional.empty();
    }

    @Override
    public Question parse(FormData formData) {
        Question quest = Question.with().build();
        return fill(quest, formData);
    }
}
