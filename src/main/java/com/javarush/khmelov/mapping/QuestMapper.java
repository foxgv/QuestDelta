package com.javarush.khmelov.mapping;

import com.javarush.khmelov.dto.FormData;
import com.javarush.khmelov.dto.ui.QuestDto;
import com.javarush.khmelov.entity.Quest;

import java.util.Optional;

/**
 * Class package-private. Use only <code>interface Mapper</code>
 */
class QuestMapper implements Mapper<Quest, QuestDto> {

    @Override
    public Optional<QuestDto> get(Quest quest) {
        return quest != null
                ? Optional.of(QuestDto.builder()
                .id(quest.getId())
                .name(quest.getName())
                //.userId(quest.getUser().getId())
                .questions(quest.getQuestions().stream()
                        .map(question::get)
                        .map(Optional::orElseThrow)
                        .toList())
                .build()
        ) : Optional.empty();
    }

    @Override
    public Quest parse(FormData formData) {
        Quest quest = Quest.builder().build();
        return fill(quest, formData);
    }
}
