package ua.com.javarush.quest.zazimko.questdelta.entity;

import java.util.concurrent.atomic.AtomicLong;

public class User {
    private final AtomicLong id=new AtomicLong();
    private String login;
    private String password;
    private String role;
}
