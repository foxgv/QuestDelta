package ua.com.javarush.quest_spring.ivanov.entities;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Question {
    private int id;
    private String text;
    private List<Answer> answers;
    private Answer correctAnswer;

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", questionText='" + text + '\'' +
                ", answers=" + answers +
                ", correctAnswer=" + correctAnswer +
                '}';
    }

}
