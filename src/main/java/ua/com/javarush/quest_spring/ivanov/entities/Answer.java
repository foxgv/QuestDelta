package ua.com.javarush.quest_spring.ivanov.entities;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Answer {

    private int id;
    private String text;
    private boolean isCorrect;

    private int questionId;

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", isCorrect=" + isCorrect +
                '}';
    }
}
