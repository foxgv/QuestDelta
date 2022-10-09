package ru.javarush.volokitin.questdelta.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder(builderMethodName = "with", buildMethodName = "get")
public class Question extends AbstractEntity {
    String text;
    List<Answer> answers;
}
