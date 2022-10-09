package ru.javarush.volokitin.questdelta.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder(builderMethodName = "with", buildMethodName = "get")
public class GameDTO {
    LocalDate date;
    String user;
    int correctAnswersCount;
}
