package ua.com.javarush.quest.kossatyy.questdelta.config;

import ua.com.javarush.quest.kossatyy.questdelta.repository.*;

import java.util.Arrays;
import java.util.Optional;

public enum Container {
    USER_REPOSITORY(UserRepository.class, new UserRepository()),
    GAME_REPOSITORY(GameRepository.class, new GameRepository()),
    LEVEL_REPOSITORY(LevelRepository.class, new LevelRepository()),
    BUTTON_REPOSITORY(ButtonRepository.class, new ButtonRepository()),
    REQUIREMENT_REPOSITORY(RequirementRepository.class, new RequirementRepository()),
    GAME_SESSION_REPOSITORY(GameSessionRepository.class, new GameSessionRepository());

    private final Class<?> clazz;
    private final Object instance;

    <T> Container(Class<T> clazz, T instance) {
        this.clazz = clazz;
        this.instance = instance;
    }

    public Class<?> getClazz() {
        return clazz;
    }

    @SuppressWarnings("unchecked")
    public static <T> T getInstance(Class<T> clazz) {
        Optional<Container> repository = Arrays.stream(Container.values())
                .filter(object -> object.getClazz() == clazz)
                .findFirst();
        if (repository.isPresent()) {
            Container container = repository.get();
            return (T) container.instance;
        } else {
            throw new RuntimeException("Instance of " + clazz.getName() + " dont exist");
        }
    }
}
