package ua.com.javarush.quest.kossatyy.questdelta.entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Game {

    private Long id;
    private String name;
    private String description;
    private String image;
    private Long authorId;
    private Long startQuestionId;
    private List<Requirement> requirements;
    private List<Level> levels;

}
