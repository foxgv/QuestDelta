package ua.com.javarush.quest.zazimko.questdelta.entity;

import ua.com.javarush.quest.zazimko.questdelta.util.UserRole;

import java.util.Objects;

public class User {
    private static long idCount=4;
    private final long id;
    private String login;
    private String password;
    private UserRole role;

    public User(String login, String password, UserRole role) {
        User.idCount++;
        this.id = idCount;
        this.login = login;
        this.password = password;
        this.role = role;

    }

    public long getId() {
        return id;
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

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(login, user.login) && Objects.equals(password, user.password) && role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, role);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
