package ua.com.javarush.quest.mogutov.questdelta.test.ua.com.javarush.quest.mogutov.questdelta.test;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ua.com.javarush.quest.mogutov.questdelta.servlets.QuestServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


class QuestServletTest extends Mockito {

    // it's not working yet
    // if redirect is ENABLE - test didn't run success
    // to SUCCESS - comment REDIRECT (48 line)
    @Disabled
    @Test
    public void testServlet() throws Exception {

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);

        // добавили "поведение" для request
        when(request.getParameter("answer")).thenReturn("1");
        when(request.getSession()).thenReturn(session);

        // doGet - запрос сервлету
        new QuestServlet().doGet(request, response);

        // проверяем, вызывается ли параметр "answer"
        verify(request, atLeast(1)).getParameter("answer");

    }
}