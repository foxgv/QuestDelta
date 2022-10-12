package ua.com.javarush.quest.rbityutskih.dto;

import lombok.Builder;
import lombok.Data;
import ua.com.javarush.quest.rbityutskih.entity.GameState;

import java.util.Collection;

@Data
@Builder(builderMethodName = "with")
public class QuestionDto {
    Long id;
    Long questId;
    String image;
    String text;
    Collection<AnswerDto> answers;
    GameState state;
}
