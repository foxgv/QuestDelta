package com.javarush.quest.bulimov.questdelta.services;

import com.javarush.quest.bulimov.questdelta.dto.FormData;
import com.javarush.quest.bulimov.questdelta.dto.GameDto;
import com.javarush.quest.bulimov.questdelta.entity.Game;
import com.javarush.quest.bulimov.questdelta.entity.GameStatus;
import com.javarush.quest.bulimov.questdelta.mapping.Mapper;
import com.javarush.quest.bulimov.questdelta.repository.GameRepository;
import com.javarush.quest.bulimov.questdelta.repository.Repository;

import java.util.Collection;
import java.util.Optional;

public enum GameService {

    INSTANCE;
    private final Repository<Game> gameRepository = GameRepository.get();


    public Collection<GameDto> getAll(){
        return gameRepository.getAll()
                .map(Mapper.game::get)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
    }

    public Optional<GameDto> get(Long id){
        return Mapper.game.get(gameRepository.get(id));
    }

    public Optional<GameDto> find(FormData formData) {
        Game game = Mapper.game.parse(formData);
        Optional<Game> optionalGame = gameRepository
                .find(game)
                .findFirst();
        return optionalGame.isPresent()
                ? Mapper.game.get(optionalGame.get())
                : Optional.empty();
    }

    public void update(FormData formData) {
        Game game = gameRepository.get(formData.getId());
        Mapper.game.parse(formData);
        gameRepository.update(game);
    }

    public void create(FormData formData) {
        Game game = Mapper.game.parse(formData);
        game.setQuestId(1L);
        game.setCurrentQuestionId(1L);
        game.setGameStatus(GameStatus.PLAY);
        gameRepository.create(game);
    }

    public void delete(FormData formData) {
        Game game = gameRepository.get(formData.getId());
        gameRepository.delete(game);
    }
}
