package ua.com.javarush.quest.khmelov.controller.user;

import com.javarush.khmelov.controller.user.LoginServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import com.javarush.khmelov.config.Winter;
import com.javarush.khmelov.dto.ui.UserDto;
import com.javarush.khmelov.entity.Role;
import com.javarush.khmelov.entity.User;
import com.javarush.khmelov.mapping.Mapper;
import ua.com.javarush.quest.khmelov.repository.Container;
import com.javarush.khmelov.repository.impl.UserRepository;
import com.javarush.khmelov.util.Go;
import com.javarush.khmelov.util.Jsp;

import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.fail;

public class LoginServletIT {

    @BeforeAll
    static void setUp() {
        Container.init();
    }


    private final String login = "login" + System.currentTimeMillis();


    public final User user = User.builder()
            .login(login)
            .password("password")
            .role(Role.USER)
            .build();

    @Test
    void doPost() {
        //prepare db
        UserRepository userRepository = Winter.getBean(UserRepository.class);
        userRepository.create(user);
        UserDto userDto = Mapper.user.get(user).orElseThrow();
        //mock
        HttpSession httpSession = Mockito.mock(HttpSession.class);
        //stub
        Map<String, String[]>  formData = Map.of(
                "login", new String[]{login},
                "password", new String[]{"password"}
        );
        HttpServletRequest requestStub = Mockito.mock(HttpServletRequest.class);
        Mockito.when(requestStub.getParameterMap()).thenReturn(formData);
        Mockito.when(requestStub.getSession()).thenReturn(httpSession);

        HttpServletResponse responseStub = Mockito.mock(HttpServletResponse.class);
        //static mock
        try (MockedStatic<Jsp> jsp = Mockito.mockStatic(Jsp.class)) {
            //Servlet with services and repo
            LoginServlet loginServlet = new LoginServlet();
            loginServlet.doPost(requestStub, responseStub);
            //assert forward (static method)
            jsp.verify(() -> Jsp.redirect(requestStub, responseStub, Go.PROFILE));
            //assert addition userDto to session (instance method)
            Mockito.verify(httpSession).setAttribute(Jsp.Key.USER, userDto);
        } catch (ServletException | IOException e) {
            fail(e);
        }
        userRepository.delete(user);
    }
}