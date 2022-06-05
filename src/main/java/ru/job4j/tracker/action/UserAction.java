package ru.job4j.tracker.action;

import ru.job4j.tracker.Store;
import ru.job4j.tracker.input.Input;

import java.sql.SQLException;

public interface UserAction {
    String name();
    boolean execute(Input input, Store tracker) throws SQLException, InterruptedException;
}
