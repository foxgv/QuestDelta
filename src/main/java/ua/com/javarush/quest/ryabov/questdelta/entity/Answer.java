package ua.com.javarush.quest.ryabov.questdelta.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(builderMethodName = "with", buildMethodName = "get")
public class Answer {
    Long id;
    String answer;
    long nextQuestionID;
}
