package ua.com.javarush.quest.gribanov.questdelta.entity;

import java.util.Objects;

public abstract class AbstractEntity {
    private long id;

    public long getId(){
        return id;
    }
    public void setId(long id){
        this.id = id;
    }

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
