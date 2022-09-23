package ua.com.javarush.quest.ryabov.questdelta.repository;

import ua.com.javarush.quest.ryabov.questdelta.entity.Question;
import ua.com.javarush.quest.ryabov.questdelta.entity.User;

public class RepositoryLoader {
    public static final Repository<Question> questionRepository = QuestionRepository.get();
    public static final Repository<User> userRepository = UserRepository.get();
}
