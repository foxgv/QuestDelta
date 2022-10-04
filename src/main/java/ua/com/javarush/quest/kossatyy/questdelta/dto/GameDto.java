package ua.com.javarush.quest.kossatyy.questdelta.dto;

import lombok.Builder;
import lombok.Data;
import ua.com.javarush.quest.kossatyy.questdelta.entity.Level;
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
    private Long startQuestionId;
    private List<Requirement>  requirements;
//    private List<Level> levelsId;
    private int levels;

}
