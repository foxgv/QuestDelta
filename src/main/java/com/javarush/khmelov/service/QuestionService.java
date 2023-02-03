package com.javarush.khmelov.service;

import com.javarush.khmelov.dto.FormData;
import com.javarush.khmelov.dto.ui.AnswerDto;
import com.javarush.khmelov.dto.ui.QuestionDto;
import com.javarush.khmelov.entity.Question;
import com.javarush.khmelov.mapping.Mapper;
import com.javarush.khmelov.repository.impl.QuestionRepository;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;

    public Optional<QuestionDto> get(long id) {
        questionRepository.beginTransactional();
        try {
            Question question = questionRepository.get(id);
            //here can be service for answers, but it found in entity
            List<AnswerDto> answersDto = question.getAnswers().stream()
                    .map(Mapper.answer::get)
                    .map(Optional::orElseThrow)
                    .toList();
            Optional<QuestionDto> questionDto = Mapper.question.get(question);
            questionDto.orElseThrow().setAnswers(answersDto);
            return questionDto;
        } finally {
            questionRepository.endTransactional();
        }
    }

    @SneakyThrows
    @Transactional
    public Optional<QuestionDto> update(FormData formData) {
        questionRepository.beginTransactional();
        try {
            Question question = questionRepository.get(formData.getId());
            Mapper.question.fill(question, formData);
            questionRepository.update(question);
            return Mapper.question.get(question);
        } finally {
            questionRepository.endTransactional();
        }
    }
}
