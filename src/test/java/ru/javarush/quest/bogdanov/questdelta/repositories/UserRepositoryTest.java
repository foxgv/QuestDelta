package ru.javarush.quest.bogdanov.questdelta.repositories;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.javarush.quest.bogdanov.questdelta.entities.User;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

class UserRepositoryTest {

    static UserRepository userRepository;
    @BeforeAll
    public static void init() {
        userRepository = new UserRepository();
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findUserFromMapWithLoginAndPasswordAndFound() {
        User pattern = new User("Misha", "1111");
        Optional<User> actual = userRepository.find(pattern);
        assertTrue(actual.isPresent());
    }

    @Test
    void findUserFromMapWithLoginAndPasswordAndNotFound() {
        User pattern = new User("Misha", "1112");
        Optional<User> actual = userRepository.find(pattern);
        assertTrue(actual.isEmpty());
    }
}