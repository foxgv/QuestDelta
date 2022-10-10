package ua.com.javarush.quest.gribanov.questdelta.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnswerDTO {
    long id;
    long questionID;
    long nextQuestionID;
    String answerText;
}
