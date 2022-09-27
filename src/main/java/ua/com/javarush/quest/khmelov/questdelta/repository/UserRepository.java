package ua.com.javarush.quest.khmelov.questdelta.repository;

import ua.com.javarush.quest.khmelov.questdelta.entity.User;

public class UserRepository extends AbstractRepository<User> {

    private static final UserRepository userRepository = new UserRepository();
     public static UserRepository get(){
         return userRepository;
     }
    private UserRepository(){

    }
    @Override
    public User find(User template) {
        return null;
    }
}
