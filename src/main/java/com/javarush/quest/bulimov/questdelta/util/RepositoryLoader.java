package com.javarush.quest.bulimov.questdelta.util;

import com.javarush.quest.bulimov.questdelta.repository.AnswerRepository;
import com.javarush.quest.bulimov.questdelta.repository.QuestRepository;
import com.javarush.quest.bulimov.questdelta.repository.QuestionRepository;
import com.javarush.quest.bulimov.questdelta.repository.UserRepository;
import lombok.experimental.UtilityClass;

@UtilityClass
public class RepositoryLoader {

    private final UserRepository userRepository = UserRepository.get();
    private final QuestRepository questRepository = QuestRepository.get();
    private final QuestionRepository questionRepository = QuestionRepository.get();
    private final AnswerRepository answerRepository = AnswerRepository.get();

    public void load() {

    }
}
