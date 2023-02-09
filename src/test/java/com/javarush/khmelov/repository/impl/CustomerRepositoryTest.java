package com.javarush.khmelov.repository.impl;

import com.javarush.khmelov.config.Winter;
import com.javarush.khmelov.entity.Role;
import com.javarush.khmelov.entity.User;
import com.javarush.khmelov.repository.Container;
import com.javarush.khmelov.repository.Repository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Order(1)
class CustomerRepositoryTest {

    @BeforeAll
    static void init(){
        Container.init();
    }

    private final Repository<User> userRepository = Winter.getBean(UserRepository.class);

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

    @Test
    @DisplayName("When get all then count>0")
    void getAll() {
        long count = userRepository.getAll().count();
        assertTrue(count > 0);
    }

    @Test
    @DisplayName("When get '0L' then get 'test_user'")
    void get() {
        User user = userRepository.get(0L);
        assertEquals(user.getLogin(), "test_user");
    }

    @Test
    @DisplayName("When create+update+delete tempUser then no Exception")
    void createUpdateDelete() {
        User tempUser = User.builder()
                .login("login_test")
                .password("password_test")
                .role(Role.GUEST)
                .build();
        userRepository.create(tempUser);

        tempUser.setPassword("password_test_update");
        userRepository.update(tempUser);

        userRepository.delete(tempUser);
        assertTrue(tempUser.getId() > 0);
    }
}