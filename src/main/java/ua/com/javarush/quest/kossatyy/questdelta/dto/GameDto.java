package ua.com.javarush.quest.kossatyy.questdelta.dto;

import lombok.Builder;
import lombok.Data;
import ua.com.javarush.quest.kossatyy.questdelta.entity.Requirement;

import java.util.List;

@Data
@Builder
public class GameDto {

    private Long id;
    private String name;
    private String description;
    private String image;
    private Long authorId;
    private Long startLevelId;
    private String requirementDescription;
    private List<Requirement>  requirements;

}
