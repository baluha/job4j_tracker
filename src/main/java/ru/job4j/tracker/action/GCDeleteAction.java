package ru.job4j.tracker.action;

import ru.job4j.tracker.Store;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.output.Output;

import java.sql.SQLException;
import java.util.List;

public class GCDeleteAction implements UserAction {

    private final Output out;

    public GCDeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== DeleteGC item ====";
    }

    @Override
    public boolean execute(Input input, Store tracker) throws SQLException {
        tracker.deleteAll();
        return true;
    }
}
