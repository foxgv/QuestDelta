package ua.com.javarush.quest.khmelov.questdelta.entity;

import java.util.Collection;
import java.util.Objects;

public class User extends AbstractEntity {
    private String name;
    private String login;
    private String password;
    private Role role;
    private String avatar;
    private Collection<Game> playingGames;
    private Collection<Quest> createdQuests;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Collection<Game> getPlayingGames() {
        return playingGames;
    }

    public void setPlayingGames(Collection<Game> playingGames) {
        this.playingGames = playingGames;
    }

    public Collection<Quest> getCreatedQuests() {
        return createdQuests;
    }

    public void setCreatedQuests(Collection<Quest> createdQuests) {
        this.createdQuests = createdQuests;
    }

    @Override
    public long getId() {
        return 0;
    }

    @Override
    public void setId() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(login, user.login) && Objects.equals(password, user.password) && role == user.role && Objects.equals(avatar, user.avatar) && Objects.equals(playingGames, user.playingGames) && Objects.equals(createdQuests, user.createdQuests);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, login, password, role, avatar, playingGames, createdQuests);
    }
}
