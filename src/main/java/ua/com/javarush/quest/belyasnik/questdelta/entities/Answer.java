package ua.com.javarush.quest.belyasnik.questdelta.entities;

import lombok.*;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Answer extends Entity {
    String id;
    String text;
}