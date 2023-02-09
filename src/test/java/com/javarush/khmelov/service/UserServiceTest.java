package com.javarush.khmelov.service;

import com.javarush.khmelov.dto.FormData;
import com.javarush.khmelov.dto.ui.UserDto;
import com.javarush.khmelov.entity.Role;
import com.javarush.khmelov.entity.User;
import com.javarush.khmelov.repository.impl.GameRepository;
import com.javarush.khmelov.repository.impl.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    public static final Long ID = 999L;
    public static final Map<String, String[]> MAP = Map.of(
            "id", new String[]{ID.toString()}
    );

    @Mock
    UserRepository userRepositoryMock;

    @Mock
    GameRepository gameRepository;

    @Mock
    HttpServletRequest requestStub;

    private UserService userService;
    private User user;
    private User userIdOnly;
    private FormData formData;

    @BeforeEach
    void createService() {
        userService = new UserService(userRepositoryMock, gameRepository);
        user = User.builder()
                .id(ID)
                .login("Test")
                .password("Test")
                .role(Role.USER)
                .build();
        userIdOnly = User.builder()
                .id(ID)
                .build();
        Mockito.when(requestStub.getParameterMap()).thenReturn(MAP);
        formData = FormData.of(requestStub);
    }

    @Test
    @DisplayName("when get id then return user from repo")
    void get() {
        Mockito.when(userRepositoryMock.get(ID)).thenReturn(user);
        Optional<UserDto> userDto = userService.get(ID);
        Assertions.assertEquals(userDto.orElseThrow().getLogin(), user.getLogin());
        Mockito.verify(userRepositoryMock).get(ID);
    }


    @Test
    void delete() {
        Mockito.when(userRepositoryMock.get(ID)).thenReturn(user);
        userService.delete(formData);
        Mockito.verify(userRepositoryMock).delete(user);
    }
}