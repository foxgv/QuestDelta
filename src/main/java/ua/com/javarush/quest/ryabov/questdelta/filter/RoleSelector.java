package ua.com.javarush.quest.ryabov.questdelta.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.com.javarush.quest.ryabov.questdelta.entity.Role;
import ua.com.javarush.quest.ryabov.questdelta.entity.User;
import ua.com.javarush.quest.ryabov.questdelta.util.Jsp;
import ua.com.javarush.quest.ryabov.questdelta.util.UriString;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;


@WebFilter({UriString.ROOT, UriString.USERS, UriString.LOGIN, UriString.SIGNUP, UriString.PROFILE, UriString.LOGOUT, UriString.USER})
public class RoleSelector implements Filter {

    private final Map<Role, List<String>> uriMap = Map.of(
            Role.GUEST, List.of(UriString.ROOT, UriString.USERS, UriString.LOGIN, UriString.SIGNUP),
            Role.USER, List.of(UriString.ROOT, UriString.USERS, UriString.LOGIN, UriString.SIGNUP, UriString.PROFILE, UriString.LOGOUT),
            Role.ADMIN, List.of(UriString.ROOT, UriString.USERS, UriString.LOGIN, UriString.SIGNUP, UriString.PROFILE, UriString.LOGOUT, UriString.USER)
    );

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String command = Jsp.getCommand(request);
        Object user = request.getSession().getAttribute("user");
        Role role = (Objects.isNull(user))
                ? Role.GUEST
                : ((User) user).getRole();
        if (uriMap.get(role).contains(command)){
            filterChain.doFilter(servletRequest,servletResponse);
        } else {
            Jsp.redirect(response, UriString.USERS);
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
