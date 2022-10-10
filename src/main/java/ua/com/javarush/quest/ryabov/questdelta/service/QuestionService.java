package ua.com.javarush.quest.ryabov.questdelta.service;

import ua.com.javarush.quest.ryabov.questdelta.entity.Question;
import ua.com.javarush.quest.ryabov.questdelta.repository.Repository;
import ua.com.javarush.quest.ryabov.questdelta.repository.RepositoryLoader;

import java.util.Collection;
import java.util.Optional;

@SuppressWarnings("ALL")
public enum QuestionService {
    INSTANCE;
    private final Repository<Question> questionRepository = RepositoryLoader.questionRepository;

    public Collection<Question> getAll() {
        return questionRepository.getAll();
    }

    public Optional<Question> get(long id) {
        return questionRepository.get(id);
    }
}
