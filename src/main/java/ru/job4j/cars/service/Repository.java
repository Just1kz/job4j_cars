package ru.job4j.cars.service;

import ru.job4j.cars.model.Item;
import ru.job4j.cars.model.Mark;
import ru.job4j.cars.model.User;

import java.util.Collection;

public interface Repository {

    Collection<Item> lastDay();

    Collection<Item> withPhoto();

    Collection<Item> mark(Mark mark);

    public void createUser(User user);

    public User findByEmailAndPhoneUser(User user);

    public User findByEmailAndPasswordUser(User user);
}
