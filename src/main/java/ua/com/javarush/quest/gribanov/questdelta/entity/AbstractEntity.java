package ua.com.javarush.quest.gribanov.questdelta.entity;

import java.util.Objects;

public abstract class AbstractEntity {
    private Long id;

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

}
