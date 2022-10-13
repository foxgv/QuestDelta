package ua.com.javarush.quest_spring.ivanov.utils;

import ua.com.javarush.quest_spring.ivanov.dto.AnswersDTO;
import ua.com.javarush.quest_spring.ivanov.dto.QuestionsDTO;
import ua.com.javarush.quest_spring.ivanov.entities.Answer;
import ua.com.javarush.quest_spring.ivanov.entities.Question;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class SourceLoader {

    private String source;
    private Exception error;
    private int id;
    private List<Answer> answers;
    private Answer correctAnswer;


    public void setVariables(int id, String pathQuestions,String pathAnswers) {
        answers = new ArrayList<>();
        this.id = id;
        try {
            ObjectMapper mapper = new ObjectMapper();
            QuestionsDTO[] questionsDTOS = mapper.readValue(new File(pathQuestions), QuestionsDTO[].class);
            AnswersDTO[] answersDTOS = mapper.readValue(new File(pathAnswers), AnswersDTO[].class);
            setSource(id, questionsDTOS);
            setAnswers(id, answersDTOS);
            setCorrectAnswer();
        } catch (IOException e) {
            error = e;
        }
    }


    private void setCorrectAnswer() {
        answers.forEach(item -> {
            if (item.isCorrect()) {
                correctAnswer = item;
            }
        });
    }

    private void setAnswers(int id, AnswersDTO[] answersDTOS) {
        for (AnswersDTO item : answersDTOS) {
            if (item.getQuestionsId() == id) {
                answers.add(new Answer(item.getId(), item.getText(), item.isCorrect(), id));
            }
        }
    }

    private void setSource(int id, QuestionsDTO[] questionsDTOS) {
        for (QuestionsDTO item : questionsDTOS) {
            if (item.getId() == id) {
                source = item.getText();
            }
        }
    }

    public int getQuantityOfQuestions(String pathQuestions) {
        ObjectMapper mapper = new ObjectMapper();
        QuestionsDTO[] questionsDTOS = new QuestionsDTO[0];
        try {
            questionsDTOS = mapper.readValue(new File(pathQuestions), QuestionsDTO[].class);
        } catch (IOException e) {
            error = e;
        }
        return questionsDTOS.length;
    }

    public boolean hasError() {
        return error != null;
    }

    public Question build() {
        return Question.builder()
                .text(source)
                .answers(answers)
                .id(id)
                .correctAnswer(correctAnswer)
                .build();
    }
}
