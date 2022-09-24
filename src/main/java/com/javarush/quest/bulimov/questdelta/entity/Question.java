package com.javarush.quest.bulimov.questdelta.entity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Collection;

@Data
@EqualsAndHashCode(callSuper = false)
@Builder(builderMethodName = "with")
public class Question extends AbstractEntity{
    Long id;
    Long questId;
    Collection<Answer> answers;
    String text;
    Long incorrectQuestionId;
    Long correctQuestionId;
}
