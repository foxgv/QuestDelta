package ua.com.javarush.quest.gribanov.questdelta.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ua.com.javarush.quest.gribanov.questdelta.entity.Role;

@Data
@Builder
@EqualsAndHashCode
public class StatUserDTO {
    Long id;
    String name;
    Integer createdQuests;
    Integer allGames;
    Integer inProgressGames;
    Integer winGames;
    Integer lostGames;
}
