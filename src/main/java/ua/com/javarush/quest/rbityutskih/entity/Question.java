package ua.com.javarush.quest.rbityutskih.entity;

import lombok.*;

import java.util.Collection;

@Data
@EqualsAndHashCode(callSuper = false)
@Builder(builderMethodName = "with")
public class Question extends Entity{
    Long id;
    Long questId;
    Collection<Answer> answers;
    String text;
    Long incorrectQuestionId;
    Long correctQuestionId;

}