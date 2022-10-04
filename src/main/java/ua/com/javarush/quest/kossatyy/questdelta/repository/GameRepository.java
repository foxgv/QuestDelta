package ua.com.javarush.quest.kossatyy.questdelta.repository;

import ua.com.javarush.quest.kossatyy.questdelta.entity.Game;
import ua.com.javarush.quest.kossatyy.questdelta.entity.Level;
import ua.com.javarush.quest.kossatyy.questdelta.entity.Requirement;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

public class GameRepository implements Repository<Game> {

    private static final AtomicLong id = new AtomicLong(System.currentTimeMillis());

    private final Map<Long, Game> games = new HashMap<>();
    ;

    public GameRepository() {

//        this.create(Game.builder()
//                        .name("Tomb of magic")
//                        .description("История повествует о странствующем волшебнике, искавшего древний источник знаний")
//                        .image("tomb_of_magic.jpg")
//                        .authorId(1L)
//                        .startQuestionId(1L)
//                        .requirements(new Requirement[]{Requirement.builder()
//                                .id(1L)
//                                .name("req1_1")
//                                .build(),
//                        Requirement.builder()
//                                .id(2L)
//                                .name("req1_2")
//                                .build()})
//                        .levelsId(List.of(1L,2L,3L))
//                .build());
//        this.create(Game.builder()
//                .name("Boomland")
//                .description("Безлюдный лес, окруженный множеством загадок")
//                .image("util/bg.jpg")
//                .authorId(2L)
//                .startQuestionId(1L)
//                .requirements(new Requirement[]{Requirement.builder()
//                        .id(3L)
//                        .name("req2_1")
//                        .build(),
//                        Requirement.builder()
//                                .id(4L)
//                                .name("req2_2")
//                                .build()})
//                .levelsId(List.of(1L,2L,3L))
//                .build());
    }

    @Override
    public Collection<Game> getAll() {
        return games.values();
    }

    @Override
    public Game getById(long id) {
        return games.get(id);
    }

    @Override
    public Stream<Game> find(Game entity) {
        return games.values()
                .stream()
                .filter(gameInDB -> Objects.equals(gameInDB.getName(), entity.getName()));
    }

    @Override
    public void create(Game entity) {
        if (entity.getId() == null) {
            entity.setId(id.incrementAndGet());
        }
        update(entity);
    }

    @Override
    public void update(Game entity) {
        games.put(entity.getId(), entity);
    }

    @Override
    public void deleteById(long id) {
        games.remove(id);
    }
}
