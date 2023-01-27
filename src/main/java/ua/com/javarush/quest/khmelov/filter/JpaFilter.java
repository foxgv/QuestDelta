package ua.com.javarush.quest.khmelov.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import org.hibernate.Session;
import ua.com.javarush.quest.khmelov.config.Winter;
import ua.com.javarush.quest.khmelov.repository.SessionCreator;

import java.io.IOException;

@WebFilter(filterName = "JpaFilter")
public class JpaFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        SessionCreator sessionCreator = Winter.getBean(SessionCreator.class);
        Session session = sessionCreator.get();
        try (session){
            chain.doFilter(request, response);
        }
    }
}
