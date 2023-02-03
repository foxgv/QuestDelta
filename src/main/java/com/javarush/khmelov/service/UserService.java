package com.javarush.khmelov.service;

import com.javarush.khmelov.dto.FormData;
import com.javarush.khmelov.dto.ui.StatDto;
import com.javarush.khmelov.dto.ui.UserDto;
import com.javarush.khmelov.entity.Game;
import com.javarush.khmelov.entity.GameState;
import com.javarush.khmelov.entity.User;
import com.javarush.khmelov.mapping.Mapper;
import com.javarush.khmelov.repository.impl.GameRepository;
import com.javarush.khmelov.repository.impl.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final GameRepository gameRepository;

    public UserService(UserRepository userRepository, GameRepository gameRepository) {
        this.userRepository = userRepository;
        this.gameRepository = gameRepository;
    }

    public Collection<UserDto> getAll() {
        return userRepository.getAll()
                .map(Mapper.user::get)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
    }

    public Optional<UserDto> get(long id) {
        User user = userRepository.get(id);
        return Mapper.user.get(user);
    }

    public Optional<UserDto> find(FormData formData) {
        User user = Mapper.user.parse(formData);
        Optional<User> optionalUser = userRepository
                .find(user)
                .findFirst();
        return optionalUser.isPresent()
                ? Mapper.user.get(optionalUser.get())
                : Optional.empty();
    }

    public Optional<UserDto> update(FormData formData) {
        userRepository.beginTransactional();
        try {
            User user = userRepository.get(formData.getId());
            Mapper.user.fill(user, formData);
            userRepository.update(user);
            return Mapper.user.get(user);
        } finally {
            userRepository.endTransactional();
        }
    }

    public Optional<UserDto> create(FormData formData) {
        userRepository.beginTransactional();
        try {
            User user = new User();
            Mapper.user.fill(user, formData);
            userRepository.create(user);
            return Mapper.user.get(user);
        } finally {
            userRepository.endTransactional();
        }
    }

    public Optional<UserDto> delete(FormData formData) {
        userRepository.beginTransactional();
        try {
            User user = userRepository.get(formData.getId());
            userRepository.delete(user);
            return Mapper.user.get(user);
        } finally {
            userRepository.endTransactional();
        }
    }

    public Collection<StatDto> getStat() {
        return userRepository.getAll().map(this::getStatDto).toList();
    }

    private StatDto getStatDto(User user) {
        Game pattern = Game.builder().userId(user.getId()).build();
        List<Game> games = gameRepository.find(pattern).toList();
        long win = games.stream().filter(game -> game.getGameState().equals(GameState.WIN)).count();
        long lost = games.stream().filter(game -> game.getGameState().equals(GameState.LOST)).count();
        long play = games.stream().filter(game -> game.getGameState().equals(GameState.PLAY)).count();
        return StatDto.builder()
                .login(user.getLogin())
                .win(win)
                .lost(lost)
                .play(play)
                .total(win + lost + play)
                .build();
    }
}
