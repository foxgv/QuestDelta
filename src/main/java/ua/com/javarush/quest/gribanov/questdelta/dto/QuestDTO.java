package ua.com.javarush.quest.gribanov.questdelta.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QuestDTO {
    Long id;
    Long authorId;
    Long firstQuestionID;
    String name;
    String description;
    Integer duration;
    Integer numberOfQuestions;
    String image;
}
