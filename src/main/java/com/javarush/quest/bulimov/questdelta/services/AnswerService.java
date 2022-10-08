package com.javarush.quest.bulimov.questdelta.services;

import com.javarush.quest.bulimov.questdelta.entity.Answer;
import com.javarush.quest.bulimov.questdelta.repository.AnswerRepository;
import com.javarush.quest.bulimov.questdelta.repository.Repository;
import java.util.Collection;
import java.util.Optional;

public enum AnswerService {

    INSTANCE;
    private final Repository<Answer> answerRepository = AnswerRepository.get();


    public Collection<Answer> getAll(){
        return answerRepository.getAll()
                .toList();
    }

    public Answer get(Long id){
        return answerRepository.get(id);
    }


}
