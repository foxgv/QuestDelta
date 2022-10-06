package ua.com.javarush.quest.kossatyy.questdelta.service;

import ua.com.javarush.quest.kossatyy.questdelta.config.Container;
import ua.com.javarush.quest.kossatyy.questdelta.dto.ButtonDto;
import ua.com.javarush.quest.kossatyy.questdelta.entity.Button;
import ua.com.javarush.quest.kossatyy.questdelta.entity.Requirement;
import ua.com.javarush.quest.kossatyy.questdelta.repository.Repository;
import ua.com.javarush.quest.kossatyy.questdelta.repository.RequirementRepository;

import java.util.Objects;

import static java.util.Objects.isNull;

public class ButtonService {

    private final Repository<Requirement> requirementRepository = Container.getInstance(RequirementRepository.class);

    private String getDescription(Button button, Requirement requirement) {
        if (isNull(button.getRequirementId())) {
            return button.getMainDescription();
        }

        Requirement buttonRequirement = requirementRepository.getById(button.getRequirementId());
        return Objects.equals(buttonRequirement, requirement)
                ? button.getMainDescription()
                : button.getAltDescription();
    }

    public Long getNextLevelId(Button button, Requirement requirement) {
        if (isNull(button.getRequirementId())) {
            return button.getMainLevelId();
        }

        Requirement buttonRequirement = requirementRepository.getById(button.getRequirementId());
        return Objects.equals(buttonRequirement, requirement)
                ? button.getMainLevelId()
                : button.getAltLevelId();
    }

    public ButtonDto getBtnDto(Button button, Requirement requirement) {
        return ButtonDto.builder()
                .id(button.getId())
                .description(getDescription(button, requirement))
                .levelId(getNextLevelId(button, requirement))
                .build();
    }
}
