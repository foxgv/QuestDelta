package ua.com.javarush.quest.khmelov.questdelta.entity;

import java.util.Objects;

public abstract class AbstractEntity {
    private long id;

    public abstract long getId();
    public abstract void setId();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractEntity that = (AbstractEntity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
