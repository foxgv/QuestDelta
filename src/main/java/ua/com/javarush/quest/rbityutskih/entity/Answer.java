package ua.com.javarush.quest.rbityutskih.entity;

import lombok.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Builder(builderMethodName = "with")
public class Answer extends Entity {
    Long id;
    Long questionId;
    String text;
    Boolean correct;
    Long nextQuestionId;
}

