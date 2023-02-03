package com.javarush.khmelov.repository.impl;

import com.javarush.khmelov.entity.User;
import com.javarush.khmelov.repository.BaseRepository;
import com.javarush.khmelov.repository.SessionCreator;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository extends BaseRepository<User> {


    public UserRepository(SessionCreator sessionCreator) {
        super(sessionCreator, User.class);
    }


}
