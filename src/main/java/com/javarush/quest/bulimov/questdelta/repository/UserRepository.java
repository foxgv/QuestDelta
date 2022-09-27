package com.javarush.quest.bulimov.questdelta.repository;

import com.javarush.quest.bulimov.questdelta.entity.Answer;
import com.javarush.quest.bulimov.questdelta.entity.User;

import java.util.Comparator;
import java.util.stream.Stream;

public class UserRepository extends AbstractRepository<User> implements Repository<User>{
    private static final UserRepository userRepository = new UserRepository();

    public static UserRepository get(){
        return userRepository;
    }

    public UserRepository(){

    }
    @Override
    public Stream<User> find(User pattern) {
        return map.values().stream()
                .filter(entity -> isOk(pattern, entity, User::getId)
                        && isOk(pattern, entity, User::getRole)
                        && isOk(pattern, entity, User::getLogin)
                )
                .sorted(Comparator.comparingLong(User::getId));
    }
}
