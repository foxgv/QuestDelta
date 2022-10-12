package ua.com.javarush.quest.rbityutskih.service;

import ua.com.javarush.quest.rbityutskih.entity.Answer;
import ua.com.javarush.quest.rbityutskih.repository.AnswerRepository;
import ua.com.javarush.quest.rbityutskih.repository.Repository;

import java.util.Collection;
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
