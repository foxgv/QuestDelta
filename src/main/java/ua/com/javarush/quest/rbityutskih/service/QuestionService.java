package ua.com.javarush.quest.rbityutskih.service;

import ua.com.javarush.quest.rbityutskih.entity.Question;
import ua.com.javarush.quest.rbityutskih.repository.QuestionRepository;
import ua.com.javarush.quest.rbityutskih.repository.Repository;

import java.util.Collection;

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
