package com.javarush.quest.bulimov.questdelta.dto;

import com.javarush.quest.bulimov.questdelta.entity.AbstractEntity;
import com.javarush.quest.bulimov.questdelta.entity.GameStatus;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.ZonedDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
@Builder(builderMethodName = "with")
public class GameDto{
    Long id;
    ZonedDateTime startTime;
    Long currentQuestionId;
    Long questId;
    GameStatus gameStatus;

}

