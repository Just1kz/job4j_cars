package ru.job4j.cars.repository;

import ru.job4j.cars.model.*;

import java.util.Collection;

public interface Repository {

    Collection<Item> lastDay();

    Collection<Item> withPhoto();

    Collection<Item> mark(Mark mark);

    Collection<Mark> allMark();

    Collection<Model> allModel();

    Collection<TypeBody> allTypeBody();

    Collection<Item> allItem();

    Collection<Item> myItem(User user);

    Collection<Item> noSoldItem();

    public void soldItem(int id);

    public void createUser(User user);

    public User findByEmailAndPhoneUser(String email, String phone);

    public User findByEmailAndPasswordUser(String email, String password);

    public Photo createPhoto(Photo photo);

    public Mark findByNameMark(String name);

    public Model findByNameModel(String name);

    public TypeBody findByNameTypeBody(String name);

    public Photo findByNamePhoto(String name);

    public void addItem(Item item);

    public Item findByIdItem(int id);
}
