package ua.com.javarush.quest.kossatyy.questdelta.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Requirement {

    private Long id;
    private String name;

}
