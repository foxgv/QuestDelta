package com.javarush.khmelov.mapping;

import com.javarush.khmelov.dto.ui.*;
import com.javarush.khmelov.entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface Dto {

    Dto MAPPER = Mappers.getMapper(Dto.class);

    UserDto to(User user);

    @Mapping(target = "userId", source = "user.id")
    QuestDto to(Quest quest);

    @Mapping(target = "questId", source = "quest.id")
    QuestionDto to(Question question);

    AnswerDto to(Answer answer);

    @Mapping(target = "question", ignore = true)
    GameDto to(Game game);

}
