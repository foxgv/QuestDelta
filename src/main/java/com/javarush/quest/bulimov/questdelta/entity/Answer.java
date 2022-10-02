package com.javarush.quest.bulimov.questdelta.entity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Builder(builderMethodName = "with")
public class Answer extends AbstractEntity{
    Long id;
    Long questionId;
    String text;
    Long nextQuestionId;
    Boolean correct;

}
