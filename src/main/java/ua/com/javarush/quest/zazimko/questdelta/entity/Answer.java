package ua.com.javarush.quest.zazimko.questdelta.entity;

import lombok.*;
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderMethodName = "with")
public class Answer {
    String text;
    Long id;
    Long nextQuestionId;
}
