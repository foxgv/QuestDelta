package ru.javarush.volokitin.questdelta.dto;

import lombok.Builder;
import lombok.Data;
import ru.javarush.volokitin.questdelta.entity.Answer;

import java.util.List;

@Data
@Builder(builderMethodName = "with", buildMethodName = "get")
public class QuestionDTO {
    public Long id;
    String text;
    List<Answer> answers;
}
