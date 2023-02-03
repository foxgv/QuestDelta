package com.javarush.khmelov.filter;

import com.javarush.khmelov.config.Winter;
import com.javarush.khmelov.repository.SessionCreator;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import org.hibernate.Session;

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
