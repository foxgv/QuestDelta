package com.javarush.khmelov.filter;

import com.javarush.khmelov.dto.ui.UserDto;
import com.javarush.khmelov.entity.Role;
import com.javarush.khmelov.util.Go;
import com.javarush.khmelov.util.Jsp;
import com.javarush.khmelov.util.Parser;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;


@WebFilter(filterName = "RoleSelector", value = {Go.ROOT, Go.USERS, Go.LOGIN, Go.SIGNUP, Go.PROFILE, Go.LOGOUT, Go.EDIT_USER, Go.GAME, Go.CREATE, Go.QUEST, Go.QUESTS})
public class RoleSelectorFilter implements Filter {

    private final Map<Role, List<String>> uriMap = Map.of(
            Role.GUEST, List.of(Go.ROOT, Go.USERS, Go.LOGIN, Go.SIGNUP, Go.GAME),
            Role.USER, List.of(Go.ROOT, Go.USERS, Go.LOGIN, Go.SIGNUP, Go.PROFILE, Go.LOGOUT, Go.EDIT_USER, Go.GAME, Go.QUESTS),
            Role.ADMIN, List.of(Go.ROOT, Go.USERS, Go.LOGIN, Go.SIGNUP, Go.PROFILE, Go.LOGOUT, Go.EDIT_USER, Go.GAME, Go.CREATE, Go.QUESTS, Go.QUEST)
    );

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        Object user = request.getSession().getAttribute(Jsp.Key.USER);
        Role role = (Objects.isNull(user))
                ? Role.GUEST
                : ((UserDto) user).getRole();
        String command = Parser.getCommand(request);
        if (uriMap.get(role).contains(command)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            Jsp.redirect(request, response, Go.LOGIN,
                    "Недостаточно прав для этой операции. Роль: " + role);
        }
    }


    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
