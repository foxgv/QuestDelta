package ua.com.javarush.quest.zazimko.questdelta.entity;


import lombok.*;

import java.util.Collection;
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderMethodName = "with")
public class Question {
    Long id;
    private Collection<Answer> answers;
    private String text;


}
