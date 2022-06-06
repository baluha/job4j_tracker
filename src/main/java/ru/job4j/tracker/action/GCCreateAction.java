package ru.job4j.tracker.action;

import ru.job4j.tracker.Store;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;

import java.sql.SQLException;

public class GCCreateAction implements UserAction {

    private final Output out;

    public GCCreateAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== CreateGC a new Item ====";
    }

    @Override
    public boolean execute(Input input, Store tracker) throws SQLException, InterruptedException {
        for (int i = 0; i < 100000; i++) {
            String name = i + "_N";
            Thread.sleep(1);
            tracker.add(new Item(name));
        }
        return true;
    }
}