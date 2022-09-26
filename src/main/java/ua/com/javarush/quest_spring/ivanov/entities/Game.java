package ua.com.javarush.quest_spring.ivanov.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Game {
    private int gameCounter;
    private int gameCompleted;
    private int gameFailed;
    private int quantityQuizCorrectAnswers;
}
