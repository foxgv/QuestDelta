package ru.javarush.quest.bogdanov.questdelta.entities;

import java.util.concurrent.atomic.AtomicLong;

public class User {

    private static final AtomicLong ID_USER_COUNTER = new AtomicLong(1);
    public long id;
    public Role role;
    public final String login;
    private final String password;

    public User(Role role, String login, String password) {
        this.id = ID_USER_COUNTER.getAndIncrement();
        this.role = role;
        this.login = login;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", role=" + role +
                '}';
    }
}
