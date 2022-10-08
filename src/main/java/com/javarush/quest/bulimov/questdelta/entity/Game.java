package com.javarush.quest.bulimov.questdelta.entity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.ZonedDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
@Builder(builderMethodName = "with")
public class Game extends AbstractEntity{
    Long id;
    String userName;
    ZonedDateTime startTime;
    Long currentQuestionId;
    Long questId;


}
