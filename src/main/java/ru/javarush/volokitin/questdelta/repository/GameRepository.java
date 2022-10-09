package ru.javarush.volokitin.questdelta.repository;

import ru.javarush.volokitin.questdelta.entity.Game;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicLong;

public class GameRepository extends AbstractRepository<Game> {
    private static final GameRepository gameRepository = new GameRepository();

    public static GameRepository get() {
        return gameRepository;
    }

    private GameRepository() {
        map.put(0L, Game.with()
                .id(0L)
                .user("Вася")
                .date(LocalDate.of(2022, 7, 5))
                .correctAnswersCount(5)
                .get());

        map.put(1L, Game.with()
                .id(1L)
                .user("Инга")
                .date(LocalDate.of(2022, 9, 1))
                .correctAnswersCount(4)
                .get());

        map.put(2L, Game.with()
                .id(2L)
                .user("Влад")
                .date(LocalDate.of(2022, 10, 4))
                .correctAnswersCount(6)
                .get());
    }

    public void create(String user, int correctAnswersCount) {
        AtomicLong id = new AtomicLong(System.currentTimeMillis());
        map.put(id.get(), Game.with()
                .id(id.get())
                .user(user)
                .date(LocalDate.now())
                .correctAnswersCount(correctAnswersCount)
                .get());
    }
}
