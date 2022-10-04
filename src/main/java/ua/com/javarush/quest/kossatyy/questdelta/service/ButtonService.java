package ua.com.javarush.quest.kossatyy.questdelta.service;

import ua.com.javarush.quest.kossatyy.questdelta.entity.Button;
import ua.com.javarush.quest.kossatyy.questdelta.entity.Requirement;
import ua.com.javarush.quest.kossatyy.questdelta.repository.ButtonRepository;
import ua.com.javarush.quest.kossatyy.questdelta.repository.Repository;
import ua.com.javarush.quest.kossatyy.questdelta.config.Container;

import java.util.Objects;

import static java.util.Objects.isNull;

public class ButtonService {

    private final Repository<Button> buttonRepository = Container.getInstance(ButtonRepository.class);
//    private final Repository<Requirement> requirementRepository = (Repository<Requirement>) Container.BUTTON_REPOSITORY.getInstance();

    public Button getButton(Long buttonId) {
        return buttonRepository.getById(buttonId);
    }

    public String getDescription(Requirement requirement, Button button) {
        if (isNull(requirement)) {
            return button.getMainDescription();
        }

//        return Objects.equals(button.getRequirement(), requirement)
//                ? button.getMainDescription()
//                : button.getAltDescription();
        return button.getAltDescription();
    }

    public Long getNextLevelId(Requirement requirement, Long buttonId) {
        Button button = buttonRepository.getById(buttonId);

//        if (isNull(button.getRequirement())) {
//            return button.getMainLevelId();
//        }

//        return Objects.equals(button.getRequirement(), requirement)
//                ? button.getMainLevelId()
//                : button.getAltLevelId();
        return button.getAltLevelId();
    }
}
