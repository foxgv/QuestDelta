package ua.com.javarush.quest.kossatyy.questdelta.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Button {

    private Long id;
    private String mainDescription;
    private String altDescription;
    private Long mainLevelId;
    private Long altLevelId;
    private Long requirementId;

}
