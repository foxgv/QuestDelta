package ru.javarush.volokitin.questdelta.service;

import ru.javarush.volokitin.questdelta.dto.GameDTO;
import ru.javarush.volokitin.questdelta.dto.QuestionDTO;
import ru.javarush.volokitin.questdelta.entity.Answer;
import ru.javarush.volokitin.questdelta.entity.Question;
import ru.javarush.volokitin.questdelta.mapper.QuestionMapper;
import ru.javarush.volokitin.questdelta.mapper.StatisticsMapper;
import ru.javarush.volokitin.questdelta.repository.AnswerRepository;
import ru.javarush.volokitin.questdelta.repository.GameRepository;
import ru.javarush.volokitin.questdelta.repository.QuestionRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Objects;
import java.util.Optional;

public enum GameService {
    INSTANCE;

    private final GameRepository gameRepository = GameRepository.get();
    private final QuestionRepository questionRepository = QuestionRepository.get();
    private final AnswerRepository answerRepository = AnswerRepository.get();

    public QuestionDTO getQuestion(Long questionID) {
        questionID = Objects.isNull(questionID) ? 0L : questionID;
        Question question = questionRepository.get(questionID);
        return QuestionMapper.get(question);
    }

    public HashMap<String, Object> checkAnswer(Long answerID) {
        Answer answer = answerRepository.get(answerID);

        HashMap<String, Object> responseMap = new HashMap<>();
        responseMap.put("answerIsCorrect", answer.getIsCorrect());
        responseMap.put("nextQuestionID", Optional.ofNullable(answer.getNextQuestionId()));

        return responseMap;
    }

    public Collection<GameDTO> getStatistics() {
        return gameRepository.getAll().map(StatisticsMapper::get).toList();
    }

    public void saveGameStatistics(String user, int correctAnswersCount) {
        gameRepository.create(user, correctAnswersCount);
    }
}
