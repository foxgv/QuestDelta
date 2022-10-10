package ua.com.javarush.quest.kossatyy.questdelta.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ButtonDto {

    private Long id;
    private String description;
    private Long levelId;

}
