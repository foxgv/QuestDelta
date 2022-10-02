package com.javarush.quest.bulimov.questdelta.entity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Collection;
@Data
@EqualsAndHashCode(callSuper = false)
@Builder(builderMethodName = "with")
public class Quest extends AbstractEntity{
    Long id;
    String name;
    String authorId;
    Collection<Question> questions;
}
