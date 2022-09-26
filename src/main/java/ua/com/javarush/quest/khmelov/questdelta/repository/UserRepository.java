package ua.com.javarush.quest.khmelov.questdelta.repository;

import ua.com.javarush.quest.khmelov.questdelta.entity.User;

public class UserRepository extends AbstractRepository<User> {

    public static final UserRepository USER_REPOSITORY = new UserRepository();
    private UserRepository(){

    }
    @Override
    public User find(User template) {
        return null;
    }
}
