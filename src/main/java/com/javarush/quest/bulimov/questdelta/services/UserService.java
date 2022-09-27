package com.javarush.quest.bulimov.questdelta.services;

import com.javarush.quest.bulimov.questdelta.dto.FormData;
import com.javarush.quest.bulimov.questdelta.dto.UserDto;
import com.javarush.quest.bulimov.questdelta.entity.User;
import com.javarush.quest.bulimov.questdelta.mapping.Mapper;
import com.javarush.quest.bulimov.questdelta.repository.Repository;
import com.javarush.quest.bulimov.questdelta.repository.UserRepository;

import java.util.Collection;
import java.util.Optional;

public enum UserService {
    INSTANCE;
    private final Repository<User> userRepository = UserRepository.get();


    public Collection<UserDto> getAll(){
        return userRepository.getAll()
                .map(Mapper.user::get)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
    }

    public Optional<UserDto> get(Long id){
        return Mapper.user.get(userRepository.get(id));
    }
    public Optional<UserDto> find(FormData formData) {
        User user = Mapper.user.parse(formData);
        Optional<User> optionalUser = userRepository
                .find(user)
                .findFirst();
        return optionalUser.isPresent()
                ? Mapper.user.get(optionalUser.get())
                : Optional.empty();
    }

    public void update(FormData formData) {
        User user = userRepository.get(formData.getId());
        Mapper.user.parse(formData);
        userRepository.update(user);
    }

    public void create(FormData formData) {
        User user = Mapper.user.parse(formData);
        userRepository.create(user);
    }

    public void delete(FormData formData) {
        User user = userRepository.get(formData.getId());
        userRepository.delete(user);
    }

}
