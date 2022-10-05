package ua.com.javarush.quest.kossatyy.questdelta.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ButtonDto {

    private Long id;
    private String description;
    private Long levelId;

}
