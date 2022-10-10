package ua.com.javarush.quest.kossatyy.questdelta.entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Level {

    private Long id;
    private Long gameId;
    private String name;
    private String image;
    private String description;
    private List<Button> buttons;

}
