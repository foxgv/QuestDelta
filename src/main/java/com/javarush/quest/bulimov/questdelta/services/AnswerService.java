package com.javarush.quest.bulimov.questdelta.services;

import com.javarush.quest.bulimov.questdelta.dto.AnswerDto;
import com.javarush.quest.bulimov.questdelta.dto.FormData;
import com.javarush.quest.bulimov.questdelta.dto.QuestionDto;
import com.javarush.quest.bulimov.questdelta.entity.Answer;
import com.javarush.quest.bulimov.questdelta.entity.Question;
import com.javarush.quest.bulimov.questdelta.mapping.Mapper;
import com.javarush.quest.bulimov.questdelta.repository.AnswerRepository;
import com.javarush.quest.bulimov.questdelta.repository.QuestionRepository;
import com.javarush.quest.bulimov.questdelta.repository.Repository;

import java.util.Collection;
import java.util.Optional;

public enum AnswerService {

    INSTANCE;
    private final Repository<Answer> answerRepository = AnswerRepository.get();


    public Collection<AnswerDto> getAll(){
        return answerRepository.getAll()
                .map(Mapper.answer::get)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
    }

    public Optional<AnswerDto> get(Long id){
        return Mapper.answer.get(answerRepository.get(id));
    }

    public Optional<AnswerDto> find(FormData formData) {
        Answer answer = Mapper.answer.parse(formData);
        Optional<Answer> optionalAnswer = answerRepository
                .find(answer)
                .findFirst();
        return optionalAnswer.isPresent()
                ? Mapper.answer.get(optionalAnswer.get())
                : Optional.empty();
    }

}
