package ua.com.javarush.quest.kossatyy.questdelta.mapper;

public interface Mapper<T,V> {

    T toDto(V entity);
}
