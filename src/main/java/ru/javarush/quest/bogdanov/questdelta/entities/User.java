package ru.javarush.quest.bogdanov.questdelta.entities;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class User {

    private static final AtomicLong ID_USER_COUNTER = new AtomicLong(1);
    public long id;
    public Role role;
    private String login;
    private String password;

    public List<Quest> quests;

    public List<Game> games;

    public User(String login, String password, Role role) {
        this.id = ID_USER_COUNTER.getAndIncrement();
        this.role = role;
        this.login = login;
        this.password = password;
    }

    public User() {
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", role=" + role +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
