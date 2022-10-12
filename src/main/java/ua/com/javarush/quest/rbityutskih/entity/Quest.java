package ua.com.javarush.quest.rbityutskih.entity;

import lombok.*;
import java.util.Collection;
@Data
@EqualsAndHashCode(callSuper = false)
@Builder(builderMethodName = "with")
public class Quest extends Entity{
    Long id;
    String name;
    String authorId;
    Collection<Question> questions;
}
