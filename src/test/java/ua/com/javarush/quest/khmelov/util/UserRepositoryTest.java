package ua.com.javarush.quest.khmelov.util;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ua.com.javarush.quest.khmelov.config.Winter;
import ua.com.javarush.quest.khmelov.entity.Role;
import ua.com.javarush.quest.khmelov.entity.User;
import ua.com.javarush.quest.khmelov.repository.impl.UserRepository;
import ua.com.javarush.quest.khmelov.service.RepositoryService;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserRepositoryTest {

    private static final UserRepository userRepository = Winter.getBean(UserRepository.class);
    private static final RepositoryService repositoryService = Winter.getBean(RepositoryService.class);

    @BeforeAll
    public static void load() {
        repositoryService.defaultTxtInit();
    }

    public static Stream<Arguments> getSamplePatternForSearch() {
        //several users with different nullable fields (need skipped)
        return Stream.of(
                Arguments.of(User.with().login("Elena").password("123").build(), 1),
                Arguments.of(User.with().login("Elena").password("badpass").build(), 0),
                Arguments.of(User.with().login("Elena").build(), 1),

                Arguments.of(User.with().login("Andrew").build(), 1),
                Arguments.of(User.with().password("789").build(), 1),
                Arguments.of(User.with().role(Role.GUEST).build(), 1),

                Arguments.of(User.with().login("Ivan").password("456").build(), 1),
                Arguments.of(User.with().login("Ivan").password("456").role(Role.ADMIN).build(), 1),

                Arguments.of(User.with().build(), 3),
                Arguments.of(User.with().id(0L).build(), 0)
        );
    }

    @ParameterizedTest
    @MethodSource("getSamplePatternForSearch")
    @DisplayName("Check find by not null fields")
    public void find(User user, int count) {
        long actualCount = userRepository.find(user).count();
        assertEquals(count, actualCount);
    }

}