import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.javarush.quest.bogdanov.questdelta.entities.User;
import ru.javarush.quest.bogdanov.questdelta.repositories.UserRepository;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {

    UserRepository userRepository = new UserRepository();

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findUserFromMapWithLoginAndPassword() {
        User pattern = new User("Misha", "1111");
        User result = userRepository.find(pattern).get();
        long expectedId = 1L;
        long actualId = result.getId();
        assertEquals(expectedId, actualId);
    }
}