package ru.job4j.cars.service;

import ru.job4j.cars.model.Item;
import ru.job4j.cars.model.Mark;

import java.util.Collection;

public interface Repository {

    Collection<Item> lastDay();

    Collection<Item> withPhoto();

    Collection<Item> mark(Mark mark);
}
