package ru.javarush.volokitin.questdelta.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder(builderMethodName = "with", buildMethodName = "get")
public class Answer extends AbstractEntity {
    String text;
    Long nextQuestionId;
    Boolean isCorrect;
}
