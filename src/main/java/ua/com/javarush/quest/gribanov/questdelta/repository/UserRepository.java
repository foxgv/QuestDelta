package ua.com.javarush.quest.gribanov.questdelta.repository;

import ua.com.javarush.quest.gribanov.questdelta.entity.User;

import java.util.Collection;
import java.util.stream.Collectors;

public class UserRepository extends AbstractRepository<User> {

    private static final UserRepository userRepository = new UserRepository();
     public static UserRepository get(){
         return userRepository;
     }
    private UserRepository(){

    }
    @Override
    public Collection<User> find(User template) {

         return repository.values().stream()
                 .filter(entity->isCoincide(template, entity, User::getId)
                        &&isCoincide(template, entity, User::getName)
                        &&isCoincide(template, entity, User::getLogin)
                        &&isCoincide(template, entity, User::getPassword)
                        &&isCoincide(template, entity, User::getRole)
                        &&isCoincide(template, entity, User::getAvatar)
                        &&isCoincide(template, entity, User::getPlayingGames)
                        &&isCoincide(template, entity, User::getCreatedQuests))
                 .collect(Collectors.toList());
    }
}
