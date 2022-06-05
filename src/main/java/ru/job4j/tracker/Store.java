package ru.job4j.tracker;

import ru.job4j.tracker.model.Item;

import java.sql.SQLException;
import java.util.List;

public interface Store {
    Item add(Item item) throws SQLException;
    boolean replace(int id, Item item) throws SQLException;
    boolean delete(int id) throws SQLException;
    void deleteAll() throws SQLException;
    List<Item> findAll() throws SQLException;
    List<Item> findByName(String key) throws SQLException;
    Item findById(int id);
}