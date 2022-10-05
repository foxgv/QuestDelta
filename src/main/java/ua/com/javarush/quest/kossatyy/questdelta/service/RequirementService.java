package ua.com.javarush.quest.kossatyy.questdelta.service;

import ua.com.javarush.quest.kossatyy.questdelta.config.Container;
import ua.com.javarush.quest.kossatyy.questdelta.entity.Requirement;
import ua.com.javarush.quest.kossatyy.questdelta.repository.Repository;
import ua.com.javarush.quest.kossatyy.questdelta.repository.RequirementRepository;

import java.util.ArrayList;
import java.util.List;

public class RequirementService {

    private final Repository<Requirement> requirementRepository = Container.getInstance(RequirementRepository.class);

    // TODO for edit game feature
    public List<Requirement> createRequirements(List<String> reqs){
        List<Requirement> requirements = new ArrayList<>();
        for (String name : reqs) {
            Requirement requirement = Requirement.builder()
                    .name(name)
                    .build();
            requirementRepository.create(requirement);
            requirements.add(requirement);
        }

        return requirements;
    }

    public Requirement getById(long requirementId) {
        return requirementRepository.getById(requirementId);
    }
}
