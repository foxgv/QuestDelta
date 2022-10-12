package ua.com.javarush.quest.zazimko.questdelta.repository;

import ua.com.javarush.quest.zazimko.questdelta.entity.User;
import ua.com.javarush.quest.zazimko.questdelta.util.UserRole;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private static Map<Long,User> userList;
    private static final UserRepository userRepository=new UserRepository();

    public static UserRepository getUserRepository() {
        return userRepository;
    }

    public UserRepository() {
       userList= new HashMap<>();
       userList.put(1L,new User("Ivan","123", UserRole.ADMIN));
       userList.put(2L,new User("Fedor","456", UserRole.USER));
       userList.put(3L,new User("Ivan","789", UserRole.USER));
       userList.put(4L,new User("Gleb","147", UserRole.USER));
    }

    public  Map<Long, User> getUsers() {
        return userList;
    }
    public  User getUser(long id) {
        return userList.get(id);
    }

    public void update(User user) {
        User updateUser = userList.get(user.getId());
        updateUser.setLogin(user.getLogin());
        updateUser.setPassword(user.getPassword());
        updateUser.setRole(user.getRole());
    }

    public void delete(User user) {
        userList.remove(user.getId());
    }

    public void create(User user) {
        userList.put(user.getId(), user);
    }
    public Collection<User> find(User user){
        return userList.values().stream().filter(userList1 -> userList1.getLogin().equalsIgnoreCase(user.getLogin())).toList();
    }


}