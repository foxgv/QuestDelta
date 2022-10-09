package ru.javarush.volokitin.questdelta.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder(builderMethodName = "with", buildMethodName = "get")
public class Game extends AbstractEntity{
    LocalDate date;
    String user;
    int correctAnswersCount;
}
