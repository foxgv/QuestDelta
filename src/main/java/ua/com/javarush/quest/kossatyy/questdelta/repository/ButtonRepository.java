package ua.com.javarush.quest.kossatyy.questdelta.repository;

import ua.com.javarush.quest.kossatyy.questdelta.entity.Button;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

public class ButtonRepository implements Repository<Button>{

    private static final AtomicLong id = new AtomicLong(System.currentTimeMillis());

    private final Map<Long, Button> buttons = new HashMap<>();;

    @Override
    public Collection<Button> getAll() {
        return buttons.values()
                .stream()
                .toList();
    }

    @Override
    public Button getById(long id) {
        return buttons.get(id);
    }

    @Override
    public Stream<Button> find(Button entity) {
        return buttons.values()
                .stream()
                .filter(buttonInDb -> Objects.equals(buttonInDb.getId(), entity.getId()));
    }

    @Override
    public void create(Button entity) {
        if (entity.getId() == null) {
            entity.setId(id.incrementAndGet());
        }
        update(entity);
    }

    @Override
    public void update(Button entity) {
        buttons.put(entity.getId(), entity);
    }

    @Override
    public void deleteById(long id) {
        buttons.remove(id);
    }
}
