package com.javarush.quest.bulimov.questdelta.services;

import com.javarush.quest.bulimov.questdelta.dto.FormData;
import com.javarush.quest.bulimov.questdelta.dto.GameDto;
import com.javarush.quest.bulimov.questdelta.dto.QuestionDto;
import com.javarush.quest.bulimov.questdelta.entity.Game;
import com.javarush.quest.bulimov.questdelta.entity.GameStatus;
import com.javarush.quest.bulimov.questdelta.entity.Question;
import com.javarush.quest.bulimov.questdelta.mapping.Mapper;
import com.javarush.quest.bulimov.questdelta.repository.GameRepository;
import com.javarush.quest.bulimov.questdelta.repository.QuestionRepository;
import com.javarush.quest.bulimov.questdelta.repository.Repository;

import java.util.Collection;
import java.util.Optional;

public enum QuestionService {

    INSTANCE;
    private final Repository<Question> questionRepository = QuestionRepository.get();


    public Collection<QuestionDto> getAll(){
        return questionRepository.getAll()
                .map(Mapper.question::get)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
    }

    public Optional<QuestionDto> get(Long id){
        return Mapper.question.get(questionRepository.get(id));
    }

    public Optional<QuestionDto> find(FormData formData) {
        Question question = Mapper.question.parse(formData);
        Optional<Question> optionalQuestion = questionRepository
                .find(question)
                .findFirst();
        return optionalQuestion.isPresent()
                ? Mapper.question.get(optionalQuestion.get())
                : Optional.empty();
    }

}
