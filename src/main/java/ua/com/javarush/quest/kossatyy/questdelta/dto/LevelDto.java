package ua.com.javarush.quest.kossatyy.questdelta.dto;

import lombok.Builder;
import lombok.Data;
import ua.com.javarush.quest.kossatyy.questdelta.entity.Button;
import ua.com.javarush.quest.kossatyy.questdelta.entity.Requirement;

import java.util.List;

@Data
@Builder
public class LevelDto {

    private Long id;
    private String name;
    private String image;
    private String description;
    private List<ButtonDto> buttons;

}
