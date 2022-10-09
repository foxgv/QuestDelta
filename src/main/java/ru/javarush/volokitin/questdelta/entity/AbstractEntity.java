package ru.javarush.volokitin.questdelta.entity;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder(builderMethodName = "with", buildMethodName = "get")
public abstract class AbstractEntity {
    Long id;
}
