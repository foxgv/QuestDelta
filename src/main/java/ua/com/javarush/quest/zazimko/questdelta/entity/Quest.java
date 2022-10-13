package ua.com.javarush.quest.zazimko.questdelta.entity;

import lombok.*;

import java.util.ArrayList;
import java.util.Collection;
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderMethodName = "with")
public class Quest {
    Long id;
     String name;
    String text;
    Long startQuestionId;
   Collection<Question> questions=new ArrayList<>();


}
