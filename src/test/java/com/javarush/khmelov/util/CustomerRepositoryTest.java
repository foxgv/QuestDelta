package com.javarush.khmelov.util;

import com.javarush.khmelov.config.Winter;
import com.javarush.khmelov.entity.User;
import com.javarush.khmelov.repository.impl.UserRepository;
import com.javarush.khmelov.service.InitService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerRepositoryTest {

    private static final UserRepository userRepository = Winter.getBean(UserRepository.class);
    private static final InitService INIT_SERVICE = Winter.getBean(InitService.class);


    public static Stream<Arguments> getSamplePatternForSearch() {
        //several users with different nullable fields (need skipped)
        return Stream.of(
                Arguments.of(User.builder().id(0L).build(), 1),
                Arguments.of(User.builder().id(1234567890L).build(), 0),
                Arguments.of(User.builder().login("test_user").build(), 1)
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