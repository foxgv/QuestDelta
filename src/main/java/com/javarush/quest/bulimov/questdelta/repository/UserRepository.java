package com.javarush.quest.bulimov.questdelta.repository;

import com.javarush.quest.bulimov.questdelta.entity.Answer;
import com.javarush.quest.bulimov.questdelta.entity.Game;
import com.javarush.quest.bulimov.questdelta.entity.User;

import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Stream;

public class UserRepository extends AbstractRepository<User> implements Repository<User>{

    public static final UserRepository userRepository = new UserRepository();

    public static UserRepository get(){
        return userRepository;
    }
    @Override
    public Stream<User> find(User pattern) {
        return map.values().stream()
                .filter(entity -> isOk(pattern, entity, User::getId)
                        && isOk(pattern, entity, User::getRole)
                        && isOk(pattern, entity, User::getLogin)
                        && isOk(pattern, entity, User::getQuests)
                )
                .sorted(Comparator.comparingLong(User::getId));
    }
}
