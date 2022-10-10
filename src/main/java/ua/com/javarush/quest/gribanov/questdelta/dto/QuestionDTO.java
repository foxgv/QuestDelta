package ua.com.javarush.quest.gribanov.questdelta.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QuestionDTO {
    long id;
    long questID;
    String questionText;
    boolean isALast;
    String image;
}
