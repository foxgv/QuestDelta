package ua.com.javarush.quest.belyasnik.questdelta.entities;


import lombok.*;

import java.util.ArrayList;
import java.util.Collection;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Question extends Entity {
    String title;
    String fabula;
    String text;
    String viewAddress;
    String loosMessage;
    //Answer[] answers;
    Collection<Answer> answers = new ArrayList<>();
    String[] answerPath;
    int submitAnswerIndex;
}