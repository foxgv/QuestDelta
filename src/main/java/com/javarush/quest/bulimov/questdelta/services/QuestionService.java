package com.javarush.quest.bulimov.questdelta.services;


import com.javarush.quest.bulimov.questdelta.entity.Question;

import com.javarush.quest.bulimov.questdelta.repository.QuestionRepository;
import com.javarush.quest.bulimov.questdelta.repository.Repository;

import java.util.Collection;
import java.util.Optional;

public enum QuestionService {

    INSTANCE;
    private final Repository<Question> questionRepository = QuestionRepository.get();


    public Collection<Question> getAll(){
        return questionRepository.getAll()
                .toList();
    }

    public Question get(Long id){
        return questionRepository.get(id);
    }


}
