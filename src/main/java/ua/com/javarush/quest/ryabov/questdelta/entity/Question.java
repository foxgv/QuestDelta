package ua.com.javarush.quest.ryabov.questdelta.entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder(builderMethodName = "with", buildMethodName = "get")
public class Question {
    Long questionID;
    String question;
    List<Answer> answers;
}
